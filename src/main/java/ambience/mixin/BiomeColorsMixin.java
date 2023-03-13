package ambience.mixin;

import ambience.util.Color;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static ambience.AmbienceMod.config;

@Mixin(BiomeColors.class)
public class BiomeColorsMixin {

    private int r = config.waterRed;
    private int g = config.waterGreen;
    private int b = config.waterBlue;

    @Inject(method = "getWaterColor", at = @At("HEAD"), cancellable = true)
    private static void onGetWaterColor(BlockRenderView world, BlockPos pos, CallbackInfoReturnable<Integer> info) {
        if (config.customWater) {
            Color waterColor = new Color(config.waterRed, config.waterGreen, config.waterBlue);
            int newWaterColor = waterColor.getPacked();
            info.setReturnValue(newWaterColor);
            info.cancel();
        }
    }

    @Inject(method = "getGrassColor", at = @At("HEAD"), cancellable = true)
    private static void onGetGrassColor(BlockRenderView world, BlockPos pos, CallbackInfoReturnable<Integer> info) {
        if (config.customGrass) {
            Color grassColor = new Color(config.grassRed, config.grassGreen, config.grassBlue);
            int newGrassColor = grassColor.getPacked();
            info.setReturnValue(newGrassColor);
            info.cancel();
        }
    }
}

