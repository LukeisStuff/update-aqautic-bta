package luke.aquatic.blocks;

import luke.aquatic.AquaticBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockCoral extends Block {
	public static final String[] coralColors = new String[]{"unusued", "unusued", "unusued", "unusued", "unusued", "unusued", "unusued", "unusued", "unusued", "unusued", "unusued", "horn", "fire", "bubble", "brain", "tube",};

	public BlockCoral(String key, int id, Material material) {
		super(key, id, material);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(this, 1, meta)};
	}

	public static int getMetadataForColors(int i) {
		return ~i & 15;
	}

	public boolean isWaterNearby(World world, int x, int y, int z) {
        return world.getBlockMaterial(x, y, z - 1) == Material.water ||
			world.getBlockMaterial(x, y, z + 1) == Material.water ||
			world.getBlockMaterial(x - 1, y, z) == Material.water ||
			world.getBlockMaterial(x + 1, y, z) == Material.water ||
			world.getBlockMaterial(x, y + 1, z) == Material.water ||
			(world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation);
    }

	public boolean canBecomeWet(World world, int x, int y, int z) {
        return this.isWaterNearby(world, x, y, z);
    }

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!this.canBecomeWet(world, x, y, z)) {
			world.setBlockWithNotify(x, y, z, AquaticBlocks.coralDead.id);
        }
	}

}
