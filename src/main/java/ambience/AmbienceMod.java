package ambience;

import ambience.util.KeyBindingHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import com.mojang.blaze3d.glfw.Window;
import net.minecraft.client.util.Session;
import net.minecraft.util.Util;
import org.lwjgl.glfw.GLFW;

import static ambience.util.Localization.translationKey;

public class AmbienceMod implements ModInitializer {
	public static final String MOD_ID = "walksyambience";

	public static AmbienceConfig config = null;

	public static MinecraftClient mc;

	private static boolean isDisabled = false;

	public static boolean isDisabled() {
		return isDisabled;
	}

	private static boolean isForcingLowFPS = false;

	public static boolean isForcingLowFPS() {
		return isForcingLowFPS;
	}


	private static final KeyBindingHandler toggleForcedKeyBinding = new KeyBindingHandler(
			translationKey("key", "toggle_forced"),
			"key.categories.misc",
			() -> isForcingLowFPS = !isForcingLowFPS
	);

	private static final KeyBindingHandler toggleDisabledKeyBinding = new KeyBindingHandler(
			translationKey("key", "toggle_disabled"),
			"key.categories.misc",
			() -> isDisabled = !isDisabled
	);

	@Override
	public void onInitialize() {
		mc = MinecraftClient.getInstance();
		config = AmbienceConfig.load();

		toggleForcedKeyBinding.register();
		toggleDisabledKeyBinding.register();

		HudRenderCallback.EVENT.register(new HudInfoRenderer());
	}
	private static MinecraftClient client;
	private static Window window;
	private static boolean isFocused, isVisible, isHovered;
	private static long lastRender;

	public static boolean checkForRender() {

		if (client == null) {
			client = MinecraftClient.getInstance();
			window = client.getWindow();
		}
		isFocused = client.isWindowFocused();
		isVisible = GLFW.glfwGetWindowAttrib(window.getHandle(), GLFW.GLFW_VISIBLE) != 0;
		isHovered = GLFW.glfwGetWindowAttrib(window.getHandle(), GLFW.GLFW_HOVERED) != 0;


		long currentTime = Util.getMeasuringTimeMs();
		lastRender = currentTime;
		return true;
	}
}
	

