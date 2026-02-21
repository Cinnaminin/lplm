package dev.cinnaminin.mixin;

import dev.cinnaminin.lplmConfig;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {

	@Inject(method = "getMaxPlayerCount", at = @At("RETURN"), cancellable = true)
	private void lplm$overrideDisplayedLimit(CallbackInfoReturnable<Integer> cir) {
		if (lplmConfig.INSTANCE != null) {
			cir.setReturnValue(lplmConfig.INSTANCE.maxPlayers);
		}
	}
}