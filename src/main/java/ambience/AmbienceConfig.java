package ambience;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;

public final class AmbienceConfig {
	private transient File file;


//sky

	public boolean customSky = false;

	public int skyBlue = 1;
	public int skyRed = 1;
	public int skyGreen = 1;

	//water

	public boolean customWater = false;
	public int waterBlue = 1;
	public int waterRed = 1;
	public int waterGreen = 1;

	//lava

	//public boolean customLava = false;
	//public int lavaBlue = 1;
	//public int lavaRed = 1;
	//public int lavaGreen = 1;

	//grass

	public boolean customGrass = false;
	public int grassBlue = 1;
	public int grassRed = 1;
	public int grassGreen = 1;





	private AmbienceConfig() {}

	public static AmbienceConfig load() {
		File file = new File(
			FabricLoader.getInstance().getConfigDir().toString(),
			AmbienceMod.MOD_ID + ".toml"
		);

		AmbienceConfig config;
		if (file.exists()) {
			Toml configTOML = new Toml().read(file);
			config = configTOML.to(AmbienceConfig.class);
			config.file = file;
		} else {
			config = new AmbienceConfig();
			config.file = file;
			config.save();
		}
		return config;
	}

	public void save() {
		TomlWriter writer = new TomlWriter();
		try {
			writer.write(this, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
