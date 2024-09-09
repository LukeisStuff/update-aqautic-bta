package luke.aquatic.mixin;

import luke.aquatic.AquaticBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolAxe;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = ItemToolAxe.class, remap = false)
public class ItemToolAxeMixin extends ItemTool {

	public ItemToolAxeMixin(String name, int id, int damageDealt, ToolMaterial toolMaterial, Tag<Block> tagEffectiveAgainst) {
		super(name, id, damageDealt, toolMaterial, tagEffectiveAgainst);
	}

	@Override
	public boolean onUseItemOnBlock(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		int i1 = world.getBlockId(blockX, blockY, blockZ);
		int meta = world.getBlockMetadata(blockX, blockY, blockZ);

		if (i1 == Block.logOak.id) {
			Block scrapedBlock = AquaticBlocks.logStrippedOak;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == Block.logPine.id) {
			Block blockToScrape = AquaticBlocks.logStrippedPine;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == Block.logBirch.id) {
			Block blockToScrape = AquaticBlocks.logStrippedBirch;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == Block.logCherry.id) {
			Block blockToScrape = AquaticBlocks.logStrippedCherry;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == Block.logEucalyptus.id) {
			Block blockToScrape = AquaticBlocks.logStrippedEucalyptus;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == Block.logThorn.id) {
			Block blockToScrape = AquaticBlocks.logStrippedThorn;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == Block.logPalm.id) {
			Block blockToScrape = AquaticBlocks.logStrippedPalm;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == Block.logOakMossy.id) {
			Block blockToScrape = AquaticBlocks.logStrippedOakMossy;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}



		if (i1 == AquaticBlocks.woodOak.id) {
			Block blockToScrape = AquaticBlocks.woodStrippedOak;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == AquaticBlocks.woodPine.id) {
			Block blockToScrape = AquaticBlocks.woodStrippedPine;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == AquaticBlocks.woodBirch.id) {
			Block blockToScrape = AquaticBlocks.woodStrippedBirch;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == AquaticBlocks.woodCherry.id) {
			Block blockToScrape = AquaticBlocks.woodStrippedCherry;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == AquaticBlocks.woodEucalyptus.id) {
			Block blockToScrape = AquaticBlocks.woodStrippedEucalyptus;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == AquaticBlocks.woodThorn.id) {
			Block blockToScrape = AquaticBlocks.woodStrippedThorn;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == AquaticBlocks.woodPalm.id) {
			Block blockToScrape = AquaticBlocks.woodStrippedPalm;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		if (i1 == AquaticBlocks.woodOakMossy.id) {
			Block blockToScrape = AquaticBlocks.woodStrippedOakMossy;
			world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockToScrape, EnumBlockSoundEffectType.MINE);
			if (!world.isClientSide) {
				world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockToScrape.id, meta);
				itemstack.damageItem(1, entityplayer);
				entityplayer.swingItem();
			}
			entityplayer.swingItem();
		}
		return false;
	}
}
