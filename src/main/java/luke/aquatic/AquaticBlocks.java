package luke.aquatic;

import luke.aquatic.blockmodels.BlockModelCoral;
import luke.aquatic.blockmodels.BlockModelCoralPlant;
import luke.aquatic.blockmodels.ItemBlockCoral;
import luke.aquatic.blocks.BlockCoral;
import luke.aquatic.blocks.BlockCoralPlantStill;
import luke.aquatic.blocks.BlockStrippedLog;
import net.minecraft.client.render.block.model.BlockModelAxisAligned;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import static luke.aquatic.AquaticMod.MOD_ID;

public class AquaticBlocks {
	public int blockID(String blockName) {
		return AquaticConfig.cfg.getInt("Block IDs." + blockName);
	}

	public static Block iceBlue;

	public static Block conduit;

	public static Block coral;
	public static Block coralDead;
	public static Block coralFan;
	public static Block coralFanDead;
	public static Block coralPlant;
	public static Block coralPlantDead;

	public static Block kelp;
	public static Block blockKelp;

	public static Block seagrass;

	public static Block pickle;

	public static Block eggTurtle;

	public static Block logStrippedOak;
	public static Block logStrippedPine;
	public static Block logStrippedBirch;
	public static Block logStrippedCherry ;
	public static Block logStrippedEucalyptus;
	public static Block logStrippedOakMossy;
	public static Block logStrippedThorn;
	public static Block logStrippedPalm;

	public static Block woodOak;
	public static Block woodPine;
	public static Block woodBirch;
	public static Block woodCherry ;
	public static Block woodEucalyptus;
	public static Block woodOakMossy;
	public static Block woodThorn;
	public static Block woodPalm;

	public static Block woodStrippedOak;
	public static Block woodStrippedPine;
	public static Block woodStrippedBirch;
	public static Block woodStrippedCherry ;
	public static Block woodStrippedEucalyptus;
	public static Block woodStrippedOakMossy;
	public static Block woodStrippedThorn;
	public static Block woodStrippedPalm;


	public void initializeBlockDetails() {
		LookupFuelFurnace.instance.addFuelEntry(logStrippedOak.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(logStrippedPine.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(logStrippedBirch.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(logStrippedCherry.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(logStrippedEucalyptus.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(logStrippedOakMossy.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(logStrippedThorn.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(logStrippedPalm.id, 300);

		LookupFuelFurnace.instance.addFuelEntry(woodOak.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodPine.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodBirch.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodCherry.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodEucalyptus.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodOakMossy.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodThorn.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodPalm.id, 300);

		LookupFuelFurnace.instance.addFuelEntry(woodStrippedOak.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodStrippedPine.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodStrippedBirch.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodStrippedCherry.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodStrippedEucalyptus.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodStrippedOakMossy.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodStrippedThorn.id, 300);
		LookupFuelFurnace.instance.addFuelEntry(woodStrippedPalm.id, 300);

		for (int color = 2; color < 6; color++) {
			CreativeHelper.setParent(coral, color - 1, coral, 0);
		}

		for (int color = 2; color < 6; color++) {
			CreativeHelper.setParent(coralPlant, color - 1, coralPlant, 0);
		}

	}

	public void initializeBlocks() {
		BlockBuilder log = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setHardness(2.0F)
			.setResistance(1.0f)
			.setFlammability(5, 5)
			.setBlockModel(BlockModelAxisAligned::new)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT);

		BlockBuilder coralBlockBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setHardness(1.5F)
			.setResistance(6.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		BlockBuilder coralPlantBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setHardness(0.0F)
			.setResistance(0.0f)
			.setBlockModel(BlockModelCrossedSquares::new)
			.setTags(BlockTags.PLANTABLE_IN_JAR);

		BlockBuilder coralFanBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setHardness(0.0F)
			.setResistance(0.0f)
			.setBlockModel(BlockModelCrossedSquares::new)
			.setTags(BlockTags.PLANTABLE_IN_JAR);



		coral = coralBlockBuilder
			.setBlockModel(BlockModelCoral::new)
			.setItemBlock(block -> new ItemBlockCoral(block, false))
			.setTicking(true)
			.setTickOnLoad()
			.build(new BlockCoral("coral", blockID("coral"), Material.stone));

		coralDead = coralBlockBuilder
			.setTextures("aquatic:block/coral_dead")
			.build(new Block("coral.dead", blockID("coralDead"), Material.stone));

		coralPlant = coralPlantBuilder
			.setBlockModel(BlockModelCoralPlant::new)
			.setItemBlock(block -> new ItemBlockCoral(block, false))
			.setTicking(true)
			.setTickOnLoad()
			.build(new BlockCoralPlantStill("coral.plant", blockID("coralPlant"), Material.water));




		float pixel = 0.0625f;
		logStrippedOak = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_oak_top", "aquatic:block/log_stripped_oak").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("log.stripped.oak", blockID("logStrippedOak"), Material.wood));

		logStrippedOakMossy = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_oak_mossy_top", "aquatic:block/log_stripped_oak_mossy").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("log.stripped.oak.mossy", blockID("logStrippedOakMossy"), Material.wood));

		logStrippedPine = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_pine_top", "aquatic:block/log_stripped_pine").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("log.stripped.pine", blockID("logStrippedPine"), Material.wood));

		logStrippedBirch = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_birch_top", "aquatic:block/log_stripped_birch").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("log.stripped.birch", blockID("logStrippedBirch"), Material.wood));

		logStrippedCherry = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_cherry_top", "aquatic:block/log_stripped_cherry").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("log.stripped.cherry", blockID("logStrippedCherry"), Material.wood));

		logStrippedEucalyptus = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_eucalyptus_top", "aquatic:block/log_stripped_eucalyptus").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("log.stripped.eucalyptus", blockID("logStrippedEucalyptus"), Material.wood));

		logStrippedThorn = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_thorn_top", "aquatic:block/log_stripped_thorn").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("log.stripped.thorn", blockID("logStrippedThorn"), Material.wood));

		logStrippedPalm = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_palm_top", "aquatic:block/log_stripped_palm").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("log.stripped.palm", blockID("logStrippedPalm"), Material.wood));



		woodOak = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_oak_side", "minecraft:block/log_oak_side"))
			.build(new BlockLog("wood.oak", blockID("woodOak")));

		woodOakMossy = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_oak_mossy_side", "minecraft:block/log_oak_mossy_side"))
			.build(new BlockLog("wood.oak.mossy", blockID("woodOakMossy")));

		woodPine = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_pine_side", "minecraft:block/log_pine_side"))
			.build(new BlockLog("wood.pine", blockID("woodPine")));

		woodBirch = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_birch_side", "minecraft:block/log_birch_side"))
			.build(new BlockLog("wood.birch", blockID("woodBirch")));

		woodCherry = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_cherry_side", "minecraft:block/log_cherry_side"))
			.build(new BlockLog("wood.cherry", blockID("woodCherry")));

		woodEucalyptus = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_eucalyptus_side", "minecraft:block/log_eucalyptus_side"))
			.build(new BlockLog("wood.eucalyptus", blockID("woodEucalyptus")));

		woodThorn = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_thorn_side", "minecraft:block/log_thorn_side"))
			.build(new BlockLog("wood.thorn", blockID("woodThorn")));

		woodPalm = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("minecraft:block/log_palm_side", "minecraft:block/log_palm_side"))
			.build(new BlockLog("wood.palm", blockID("woodPalm")));



		woodStrippedOak = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("aquatic:block/log_stripped_oak", "aquatic:block/log_stripped_oak").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("wood.stripped.oak", blockID("woodStrippedOak"), Material.wood));

		woodStrippedOakMossy = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("aquatic:block/log_stripped_oak_mossy", "aquatic:block/log_stripped_oak_mossy").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("wood.stripped.oak.mossy", blockID("woodStrippedOakMossy"), Material.wood));

		woodStrippedPine = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("aquatic:block/log_stripped_pine", "aquatic:block/log_stripped_pine").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("wood.stripped.pine", blockID("woodStrippedPine"), Material.wood));

		woodStrippedBirch = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("aquatic:block/log_stripped_birch", "aquatic:block/log_stripped_birch").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("wood.stripped.birch", blockID("woodStrippedBirch"), Material.wood));

		woodStrippedCherry = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("aquatic:block/log_stripped_cherry", "aquatic:block/log_stripped_cherry").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("wood.stripped.cherry", blockID("woodStrippedCherry"), Material.wood));

		woodStrippedEucalyptus = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("aquatic:block/log_stripped_eucalyptus", "aquatic:block/log_stripped_eucalyptus").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("wood.stripped.eucalyptus", blockID("woodStrippedEucalyptus"), Material.wood));

		woodStrippedThorn = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("aquatic:block/log_stripped_thorn", "aquatic:block/log_stripped_thorn").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("wood.stripped.thorn", blockID("woodStrippedThorn"), Material.wood));

		woodStrippedPalm = log
			.setHardness(1.5f)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("aquatic:block/log_stripped_palm", "aquatic:block/log_stripped_palm").withCustomItemBounds(pixel, 0.0, pixel, 1.0 - pixel, 1.0, 1.0 - pixel))
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.CAN_HANG_OFF, BlockTags.FENCES_CONNECT)
			.build(new BlockStrippedLog("wood.stripped.palm", blockID("woodStrippedPalm"), Material.wood));


	}

}
