package ambience.mixin;

import ambience.util.Color;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static ambience.AmbienceMod.config;



@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {

    private int r = config.skyRed;
    private int g = config.skyGreen;
    private int b = config.skyBlue;

    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void onGetSkyColor(Vec3d cameraPos, float tickDelta, CallbackInfoReturnable<Vec3d> info) {
        if (config.customSky) {
            Color skyColor = new Color(r, g, b);
            Vec3d newSkyColor = new Vec3d(skyColor.r/255f, skyColor.g/255f, skyColor.b/255f);
            info.setReturnValue(newSkyColor);
            info.cancel();
        }
    }
}
