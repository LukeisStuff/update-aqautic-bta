package luke.aquatic.blocks;

import luke.aquatic.AquaticBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
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

	public boolean isWaterNearby(World world, int x, int y, int z, int range) {
		for (int x1 = x - range; x1 <= x + range; ++x1) {
			for (int y1 = y - range; y1 <= y + range; ++y1) {
				for (int z1 = z - range; z1 <= z + range; ++z1) {
					if (!Block.hasTag(world.getBlockId(x1, y1, z1), BlockTags.IS_WATER)) continue;
					return true;
				}
			}
		}
		return false;
	}

	public boolean canBecomeWet(World world, int x, int y, int z) {
        return this.isWaterNearby(world, x, y, z, 1);
    }

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!this.canBecomeWet(world, x, y, z)) {
			world.setBlockWithNotify(x, y, z, AquaticBlocks.coralDead.id);
        }
	}

}
