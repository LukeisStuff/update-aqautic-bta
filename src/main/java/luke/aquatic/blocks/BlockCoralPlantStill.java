package luke.aquatic.blocks;

import luke.aquatic.AquaticBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFluidStill;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockCoralPlantStill extends BlockFluidStill {

	public BlockCoralPlantStill(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		this.checkForHarden(world, x, y, z);
		if (blockId == Side.TOP.getId()) {
			return;
		}
		if (world.getBlockId(x, y, z) == this.id) {
			this.func_30004_j(world, x, y, z);
		}
	}

	private void func_30004_j(World world, int i, int j, int k) {
		int l = world.getBlockMetadata(i, j, k);
		world.editingBlocks = true;
		world.setBlockAndMetadata(i, j, k, AquaticBlocks.coralPlantFlowing.id, l);
		world.markBlocksDirty(i, j, k, i, j, k);
		world.scheduleBlockUpdate(i, j, k, AquaticBlocks.coralPlantFlowing.id, this.tickRate());
		world.editingBlocks = false;
	}

	private void checkForHarden(World world, int x, int y, int z) {
		int meta;
		boolean flag;
		if (world.getBlockId(x, y, z) != this.id) {
			return;
		}
		if (this.blockMaterial == Material.lava) {
			flag = world.getBlockMaterial(x, y, z - 1) == Material.water;
			if (flag || world.getBlockMaterial(x, y, z + 1) == Material.water) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x - 1, y, z) == Material.water) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x + 1, y, z) == Material.water) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x, y + 1, z) == Material.water) {
				flag = true;
			}
			if (flag) {
				meta = world.getBlockMetadata(x, y, z);
				if (meta == 0) {
					world.setBlockWithNotify(x, y, z, Block.obsidian.id);
				} else if (meta <= 2) {
					world.setBlockWithNotify(x, y, z, Block.cobbleGranite.id);
				} else if (meta <= 4) {
					world.setBlockWithNotify(x, y, z, Block.cobbleStone.id);
				} else {
					world.setBlockWithNotify(x, y, z, Block.cobbleBasalt.id);
				}
				this.fizz(world, x, y, z);
			}
		}
		if (this.blockMaterial == Material.water) {
			flag = world.getBlockMaterial(x, y, z - 1) == Material.lava;
			if (flag || world.getBlockMaterial(x, y, z + 1) == Material.lava) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x - 1, y, z) == Material.lava) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x + 1, y, z) == Material.lava) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x, y + 1, z) == Material.lava) {
				flag = true;
			}
			if (flag && world.getBlockMetadata(x, y, z) == 0) {
				world.setBlockWithNotify(x, y, z, Block.cobbleLimestone.id);
				this.fizz(world, x, y, z);
			}
		}
	}


	public boolean canThisPlantGrowOnThisBlockID(int i) {
		return i == Block.sand.id || i == Block.dirtScorched.id || i == Block.dirt.id || i == Block.mud.id;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return super.canPlaceBlockAt(world, x, y, z) && world.getBlockId(x, y, z) == Block.fluidWaterStill.id && world.getBlockMetadata(x, y, z) == 0 && this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z));
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		this.func_268_h(world, x, y, z);
	}

	protected final void func_268_h(World world, int i, int j, int k) {
		if (!this.canBlockStay(world, i, j, k)) {
			world.setBlockAndMetadataWithNotify(i, j, k, fluidWaterStill.id, world.getBlockMetadata(i, j, k));
		}
	}

	@Override
	public void onBlockRemoved(World world, int x, int y, int z, int data) {
		super.onBlockRemoved(world, x, y, z, data);
		if (world.getBlockId(x, y, z) == 0) {
			world.setBlockAndMetadataWithNotify(x, y, z, fluidWaterStill.id, world.getBlockMetadata(x, y, z));
		}
	}

	public boolean canCollideCheck(int meta, boolean shouldCollideWithFluids) {
		return this.isCollidable();
	}

	@Override
	public boolean isCollidable() {
		return super.isCollidable();
	}

	@Override
	public int getRenderBlockPass() {
		return 0;
	}


	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
			case SILK_TOUCH: {
				return new ItemStack[]{new ItemStack(this)};
			}
		}
		return new ItemStack[]{};
	}
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return (this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z))) && world.getBlock(x, y, z) != null && world.getBlock(x, y, z).blockMaterial == Material.water;
	}
}
