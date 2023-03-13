package ambience;

import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.List;

import static ambience.util.Localization.localized;

public final class ClothConfigScreenFactory {
	static Screen genConfig(Screen parent) {
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(localized("config", "title"))
				.setSavingRunnable(AmbienceMod.config::save);
		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		// general
		//sky
		builder.getOrCreateCategory(localized("config", "category.general"))

				.addEntry(entryBuilder
						.startTextDescription(
								localized("config", "empty")
						)
						.build()
				)

				.addEntry(entryBuilder
						.startBooleanToggle(
								localized("config", "custom_sky"),
								AmbienceMod.config.customSky
						)
						.setSaveConsumer(value -> AmbienceMod.config.customSky = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "sky_red"),
								AmbienceMod.config.skyRed,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.skyRed = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "sky_green"),
								AmbienceMod.config.skyGreen,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.skyGreen = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "sky_blue"),
								AmbienceMod.config.skyBlue,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.skyBlue = value)
						.build()
				)












				.addEntry(entryBuilder
						.startBooleanToggle(
								localized("config", "custom_sky_end"),
								AmbienceMod.config.customSkyEnd
						)
						.setSaveConsumer(value -> AmbienceMod.config.customSkyEnd = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "sky_red_end"),
								AmbienceMod.config.skyRedEnd,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.skyRedEnd = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "sky_green_end"),
								AmbienceMod.config.skyGreenEnd,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.skyGreenEnd = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "sky_blue_end"),
								AmbienceMod.config.skyBlueEnd,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.skyBlueEnd = value)
						.build()
				)























				.addEntry(entryBuilder
						.startTextDescription(
								localized("config", "empty1")
						)
						.build()
				)


















				.addEntry(entryBuilder
						.startBooleanToggle(
								localized("config", "custom_cloud"),
								AmbienceMod.config.customCloud
						)
						.setSaveConsumer(value -> AmbienceMod.config.customCloud = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "cloud_red"),
								AmbienceMod.config.cloudRed,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.cloudRed = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "cloud_green"),
								AmbienceMod.config.cloudGreen,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.cloudGreen = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "cloud_blue"),
								AmbienceMod.config.cloudBlue,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.cloudBlue = value)
						.build()
				)















				.addEntry(entryBuilder
						.startTextDescription(
								localized("config", "empty2")
						)
						.build()
				)

















				//water
				.addEntry(entryBuilder
						.startBooleanToggle(
								localized("config", "custom_water"),
								AmbienceMod.config.customWater
						)
						.setSaveConsumer(value -> AmbienceMod.config.customWater = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "water_red"),
								AmbienceMod.config.waterRed,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.waterRed = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "water_green"),
								AmbienceMod.config.waterGreen,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.waterGreen = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "water_blue"),
								AmbienceMod.config.waterBlue,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.waterBlue = value)
						.build()
				)



















				//grass


				.addEntry(entryBuilder
						.startTextDescription(
								localized("config", "empty3")
						)
						.build()
				)






















				.addEntry(entryBuilder
						.startBooleanToggle(
								localized("config", "custom_grass"),
								AmbienceMod.config.customGrass
						)
						.setSaveConsumer(value -> AmbienceMod.config.customGrass = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "grass_red"),
								AmbienceMod.config.grassRed,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.grassRed = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "grass_green"),
								AmbienceMod.config.grassGreen,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.grassGreen = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "grass_blue"),
								AmbienceMod.config.grassBlue,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.grassBlue = value)
						.build()
				);






		//lava
				/*.addEntry(entryBuilder
						.startBooleanToggle(
								localized("config", "custom_lava"),
								AmbienceMod.config.customLava
						)
						.setSaveConsumer(value -> AmbienceMod.config.customLava = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "lava_red"),
								AmbienceMod.config.lavaRed,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.lavaRed = value)
						.build()
				)
				.addEntry(entryBuilder
						.startIntSlider(
								localized("config", "lava_green"),
								AmbienceMod.config.lavaGreen,
								0, 255
						)
						.setSaveConsumer(value -> AmbienceMod.config.lavaGreen = value)
						.build()
				)
				.addEntry(entryBuilder
								.startIntSlider(
										localized("config", "lava_blue"),
										AmbienceMod.config.lavaBlue,
										0, 255
								)
								.setSaveConsumer(value -> AmbienceMod.config.lavaBlue = value)
								.build()
						);*/

		return builder.build();
	}
}