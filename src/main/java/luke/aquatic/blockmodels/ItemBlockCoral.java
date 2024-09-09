package luke.aquatic.blockmodels;

import luke.aquatic.blocks.BlockCoral;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;

public class ItemBlockCoral extends ItemBlock {
	public final boolean upperMetadata;

	public ItemBlockCoral(Block block, boolean upperMetadata) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.upperMetadata = upperMetadata;
	}

	public int getPlacedBlockMetadata(int i) {
		return i;
	}

	public String getLanguageKey(ItemStack itemstack) {
		return this.upperMetadata ? super.getKey() + "." + BlockCoral.coralColors[BlockCoral.getMetadataForColors((itemstack.getMetadata() & 16) >> 4)] : super.getKey() + "." + BlockCoral.coralColors[BlockCoral.getMetadataForColors(itemstack.getMetadata())];
	}
}
