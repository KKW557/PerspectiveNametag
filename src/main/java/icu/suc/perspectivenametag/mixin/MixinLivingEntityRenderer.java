package icu.suc.perspectivenametag.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class MixinLivingEntityRenderer {
    @Inject(method = "hasLabel(Lnet/minecraft/entity/LivingEntity;)Z", at = @At(value = "RETURN", ordinal = 6), cancellable = true)
    private void hasLabel(@NotNull LivingEntity livingEntity, @NotNull CallbackInfoReturnable<Boolean> cir) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        boolean bl = !livingEntity.canSeePlayer(clientPlayerEntity);
        cir.setReturnValue(MinecraftClient.isHudEnabled() && bl && !livingEntity.hasPassengers());
    }
}
