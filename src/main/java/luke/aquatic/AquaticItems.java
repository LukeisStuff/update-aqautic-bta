package luke.aquatic;

public class AquaticItems {
	public int itemID(String blockName) {
		return AquaticConfig.cfg.getInt("Item IDs." + blockName);
	}

	public void initilizeItems() {

	}
}
