package luke.aquatic.blockmodels;

import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;

import static luke.aquatic.AquaticMod.MOD_ID;

public class BlockModelCoralPlant<T extends Block> extends BlockModelStandard<T> {
	public final IconCoordinate[] coralColors = new IconCoordinate[]{
		TextureRegistry.getTexture(MOD_ID + ":block/coral_plant_blue"),
		TextureRegistry.getTexture(MOD_ID + ":block/coral_plant_pink"),
		TextureRegistry.getTexture(MOD_ID + ":block/coral_plant_purple"),
		TextureRegistry.getTexture(MOD_ID + ":block/coral_plant_red"),
		TextureRegistry.getTexture(MOD_ID + ":block/coral_plant_yellow"),
	};

	public BlockModelCoralPlant(Block block) {
		super(block);
	}

	@Override
	public boolean render(Tessellator tessellator, int x, int y, int z) {
		this.block.setBlockBoundsBasedOnState(BlockModelCrossedSquares.renderBlocks.blockAccess, x, y, z);
		float brightness = 1.0f;
		if (!LightmapHelper.isLightmapEnabled()) {
			brightness = this.getBlockBrightness(BlockModelCrossedSquares.renderBlocks.blockAccess, x, y, z);
		} else {
			tessellator.setLightmapCoord(this.block.getLightmapCoord(BlockModelCrossedSquares.renderBlocks.blockAccess, x, y, z));
		}
		int color = BlockColorDispatcher.getInstance().getDispatch(this.block).getWorldColor(BlockModelCrossedSquares.renderBlocks.blockAccess, x, y, z);
		float r = (float)(color >> 16 & 0xFF) / 255.0f;
		float g = (float)(color >> 8 & 0xFF) / 255.0f;
		float b = (float)(color & 0xFF) / 255.0f;
		tessellator.setColorOpaque_F(brightness * r, brightness * g, brightness * b);
        int metadata = BlockModelCrossedSquares.renderBlocks.blockAccess.getBlockMetadata(x, y, z);
		IconCoordinate texIndex = this.getBlockTextureFromSideAndMetadata(Side.BOTTOM, metadata);
        double minU = texIndex.getIconUMin();
		double maxU = texIndex.getIconUMax();
		double minV = texIndex.getIconVMin();
		double maxV = texIndex.getIconVMax();
		double minX = (double) x + 0.5 - 0.45;
		double maxX = (double) x + 0.5 + 0.45;
		double minZ = (double) z + 0.5 - 0.45;
		double maxZ = (double) z + 0.5 + 0.45;
		tessellator.addVertexWithUV(minX, (double) y + 1.0 + 0.0, minZ, minU, minV);
		tessellator.addVertexWithUV(minX, (double) y + 0.0, minZ, minU, maxV);
		tessellator.addVertexWithUV(maxX, (double) y + 0.0, maxZ, maxU, maxV);
		tessellator.addVertexWithUV(maxX, (double) y + 1.0 + 0.0, maxZ, maxU, minV);
		tessellator.addVertexWithUV(maxX, (double) y + 1.0 + 0.0, maxZ, minU, minV);
		tessellator.addVertexWithUV(maxX, (double) y + 0.0, maxZ, minU, maxV);
		tessellator.addVertexWithUV(minX, (double) y + 0.0, minZ, maxU, maxV);
		tessellator.addVertexWithUV(minX, (double) y + 1.0 + 0.0, minZ, maxU, minV);
		tessellator.addVertexWithUV(minX, (double) y + 1.0 + 0.0, maxZ, minU, minV);
		tessellator.addVertexWithUV(minX, (double) y + 0.0, maxZ, minU, maxV);
		tessellator.addVertexWithUV(maxX, (double) y + 0.0, minZ, maxU, maxV);
		tessellator.addVertexWithUV(maxX, (double) y + 1.0 + 0.0, minZ, maxU, minV);
		tessellator.addVertexWithUV(maxX, (double) y + 1.0 + 0.0, minZ, minU, minV);
		tessellator.addVertexWithUV(maxX, (double) y + 0.0, minZ, minU, maxV);
		tessellator.addVertexWithUV(minX, (double) y + 0.0, maxZ, maxU, maxV);
		tessellator.addVertexWithUV(minX, (double) y + 1.0 + 0.0, maxZ, maxU, minV);
		return true;
	}

	@Override
	public boolean shouldItemRender3d() {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(WorldSource blockAccess, int x, int y, int z, int side) {
		return super.shouldSideBeRendered(blockAccess, x, y, z, side);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return this.coralColors[MathHelper.clamp(data, 0, 15)];
	}
}
