package luke.aquatic.blockmodels;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;

import static luke.aquatic.AquaticMod.MOD_ID;

public class BlockModelCoral<T extends Block> extends BlockModelStandard<T> {
	public final IconCoordinate[] coralColors = new IconCoordinate[]{
		TextureRegistry.getTexture(MOD_ID + ":block/coral_blue"),
		TextureRegistry.getTexture(MOD_ID + ":block/coral_pink"),
		TextureRegistry.getTexture(MOD_ID + ":block/coral_purple"),
		TextureRegistry.getTexture(MOD_ID + ":block/coral_red"),
		TextureRegistry.getTexture(MOD_ID + ":block/coral_yellow"),
	};

	public BlockModelCoral(Block block) {
		super(block);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return this.coralColors[MathHelper.clamp(data, 0, 15)];
	}
}
