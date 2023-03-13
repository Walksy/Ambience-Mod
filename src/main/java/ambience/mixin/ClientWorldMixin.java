package ambience.mixin;

import ambience.util.Color;
import ambience.util.PlayerDimension;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static ambience.AmbienceMod.config;
import static ambience.AmbienceMod.mc;


@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {

    @Shadow public abstract Vec3d getCloudsColor(float tickDelta);

    private int sR = config.skyRed;
    private int sG = config.skyGreen;
    private int sB = config.skyBlue;


    private int cR = config.cloudRed;
    private int cG = config.cloudGreen;
    private int cB = config.cloudBlue;


    private static PlayerDimension getDimension() {
        if (mc.world == null) return PlayerDimension.Overworld;

        return switch (mc.world.getRegistryKey().getValue().getPath()) {
            case "the_nether" -> PlayerDimension.Nether;
            case "the_end" -> PlayerDimension.End;
            default -> PlayerDimension.Overworld;
        };
    }


    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void onGetSkyColor(Vec3d cameraPos, float tickDelta, CallbackInfoReturnable<Vec3d> info) {
            if (!config.customSkyEnd && getDimension() == PlayerDimension.End || !config.customSky && getDimension() == PlayerDimension.Overworld) {
                return;
            }
            Color skyColor = new Color(sR, sG, sB);
            Vec3d newSkyColor = new Vec3d(skyColor.r/255f, skyColor.g/255f, skyColor.b/255f);
            info.setReturnValue(newSkyColor);
            info.cancel();
        }

    @Inject(method = "getCloudsColor", at = @At("HEAD"), cancellable = true)
    private void onGetCloudColor(float tickDelta, CallbackInfoReturnable<Vec3d> cir) {
        if (config.customCloud) {
            Color cloudColor = new Color(cR, cG, cB);
            Vec3d newCloudColor = new Vec3d(cloudColor.r / 255f, cloudColor.g / 255f, cloudColor.b / 255f);
            cir.setReturnValue(newCloudColor);
            cir.cancel();
        }
    }
}
