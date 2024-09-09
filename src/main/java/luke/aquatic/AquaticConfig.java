package luke.aquatic;

import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static luke.aquatic.AquaticMod.MOD_ID;

public class AquaticConfig {
	public static ConfigUpdater updater = ConfigUpdater.fromProperties();
	public static final Toml properties = new Toml("Update Aquatic TOML Config");
	public static TomlConfigHandler cfg;

	public static int blockIDs = 1300;
	public static int itemIDs = 30000;

	static {
		properties.addCategory("Update Aquatic")
			.addEntry("cfgVersion", 5);

		properties.addCategory("Block IDs");
		properties.addEntry("Block IDs.startingID", blockIDs);
		properties.addCategory("Item IDs");
		properties.addEntry("Item IDs.startingID", itemIDs);

		List<Field> blockFields = Arrays.stream(AquaticBlocks.class.getDeclaredFields()).filter((F)-> Block.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field blockField : blockFields) {
			properties.addEntry("Block IDs." + blockField.getName(), blockIDs++);
		}
		List<Field> itemFields = Arrays.stream(AquaticItems.class.getDeclaredFields()).filter((F)-> Item.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field itemField : itemFields) {
			properties.addEntry("Item IDs." + itemField.getName(), itemIDs++);
		}

		cfg = new TomlConfigHandler(updater, MOD_ID, properties);

	}
}
