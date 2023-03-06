package ambience.util;

import ambience.AmbienceMod;
import net.minecraft.text.Text;

public final class Localization {
	public static String translationKey(String domain, String path) {
		return domain + "." + AmbienceMod.MOD_ID + "." + path;
	}
	
	public static Text localized(String domain, String path, Object... args) {
		return Text.translatable(translationKey(domain, path), args);
	}
	
	private Localization() {}
}
