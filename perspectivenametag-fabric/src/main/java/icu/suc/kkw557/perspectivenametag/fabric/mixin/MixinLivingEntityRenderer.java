package icu.suc.kkw557.perspectivenametag.fabric.mixin;

import icu.suc.kkw557.perspectivenametag.PerspectiveNametag;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.ServerEntry;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public abstract class MixinLivingEntityRenderer {
    @Inject(method = "method_4055", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;isHudEnabled()Z"), cancellable = true)
    private void injectHasLabel(@NotNull LivingEntity livingEntity, @NotNull CallbackInfoReturnable<Boolean> cir) {
        if (PerspectiveNametag.DISABLED) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        ServerEntry server = mc.getCurrentServerEntry();
        if (server != null && PerspectiveNametag.BLACKLIST.contains(server.address)) return;
        cir.setReturnValue(MinecraftClient.isHudEnabled() && !livingEntity.canSeePlayer(mc.player) && !livingEntity.hasPassengers());
    }
}