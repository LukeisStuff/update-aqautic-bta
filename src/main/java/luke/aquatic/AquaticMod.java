package luke.aquatic;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class AquaticMod implements ModInitializer, GameStartEntrypoint {
    public static final String MOD_ID = "aquatic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Updated Aquatic initialized.");
    }

	@Override
	public void beforeGameStart() {
		new AquaticBlocks().initializeBlocks();
		new AquaticItems().initilizeItems();
		new AquaticEntities().initializeEntities();
	}

	@Override
	public void afterGameStart() {
		new AquaticBlocks().initializeBlockDetails();
	}

}
