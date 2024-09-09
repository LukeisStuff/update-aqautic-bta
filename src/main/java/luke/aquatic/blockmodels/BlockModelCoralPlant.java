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
		double xd = x;
		double yd = y;
		double zd = z;
		if (this.block == Block.tallgrass || this.block == Block.tallgrassFern || this.block == Block.spinifex) {
			long dRandom = (long)x * 3129871L ^ (long)z * 116129781L ^ (long)y;
			dRandom = dRandom * dRandom * 42317861L + dRandom * 11L;
			xd += ((double)((float)(dRandom >> 16 & 0xFL) / 15.0f) - 0.5) * 0.5;
			yd += ((double)((float)(dRandom >> 20 & 0xFL) / 15.0f) - 1.0) * 0.2;
			zd += ((double)((float)(dRandom >> 24 & 0xFL) / 15.0f) - 0.5) * 0.5;
		}
		int metadata = BlockModelCrossedSquares.renderBlocks.blockAccess.getBlockMetadata(x, y, z);
		IconCoordinate texIndex = this.getBlockTextureFromSideAndMetadata(Side.BOTTOM, metadata);
		if (BlockModelCrossedSquares.renderBlocks.overrideBlockTexture != null) {
			texIndex = BlockModelCrossedSquares.renderBlocks.overrideBlockTexture;
		}
		double minU = texIndex.getIconUMin();
		double maxU = texIndex.getIconUMax();
		double minV = texIndex.getIconVMin();
		double maxV = texIndex.getIconVMax();
		double minX = xd + 0.5 - 0.45;
		double maxX = xd + 0.5 + 0.45;
		double minZ = zd + 0.5 - 0.45;
		double maxZ = zd + 0.5 + 0.45;
		tessellator.addVertexWithUV(minX, yd + 1.0 + 0.0, minZ, minU, minV);
		tessellator.addVertexWithUV(minX, yd + 0.0, minZ, minU, maxV);
		tessellator.addVertexWithUV(maxX, yd + 0.0, maxZ, maxU, maxV);
		tessellator.addVertexWithUV(maxX, yd + 1.0 + 0.0, maxZ, maxU, minV);
		tessellator.addVertexWithUV(maxX, yd + 1.0 + 0.0, maxZ, minU, minV);
		tessellator.addVertexWithUV(maxX, yd + 0.0, maxZ, minU, maxV);
		tessellator.addVertexWithUV(minX, yd + 0.0, minZ, maxU, maxV);
		tessellator.addVertexWithUV(minX, yd + 1.0 + 0.0, minZ, maxU, minV);
		tessellator.addVertexWithUV(minX, yd + 1.0 + 0.0, maxZ, minU, minV);
		tessellator.addVertexWithUV(minX, yd + 0.0, maxZ, minU, maxV);
		tessellator.addVertexWithUV(maxX, yd + 0.0, minZ, maxU, maxV);
		tessellator.addVertexWithUV(maxX, yd + 1.0 + 0.0, minZ, maxU, minV);
		tessellator.addVertexWithUV(maxX, yd + 1.0 + 0.0, minZ, minU, minV);
		tessellator.addVertexWithUV(maxX, yd + 0.0, minZ, minU, maxV);
		tessellator.addVertexWithUV(minX, yd + 0.0, maxZ, maxU, maxV);
		tessellator.addVertexWithUV(minX, yd + 1.0 + 0.0, maxZ, maxU, minV);
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
