package icu.suc.kkw557.perspectivenametag.common.mixin;

import icu.suc.kkw557.perspectivenametag.PerspectiveNametag;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public abstract class MixinLivingEntityRenderer {
    @Inject(method = "shouldShowName(Lnet/minecraft/world/entity/LivingEntity;D)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Hud;isHidden()Z"), cancellable = true)
    private void injectHasLabel(@NotNull LivingEntity entity, double distanceToCameraSq, @NotNull CallbackInfoReturnable<Boolean> cir) {
        if (PerspectiveNametag.DISABLED) return;
        var mc = Minecraft.getInstance();
        var server = mc.getCurrentServer();
        if (server != null && PerspectiveNametag.BLACKLIST.contains(server.ip)) return;
        //noinspection DataFlowIssue
        cir.setReturnValue(!Minecraft.getInstance().gui.hud.isHidden() && !entity.isInvisibleTo(mc.player) && !entity.isVehicle());
    }
}