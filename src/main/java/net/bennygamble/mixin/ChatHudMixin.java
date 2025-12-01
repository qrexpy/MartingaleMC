package net.bennygamble.mixin;

import net.bennygamble.BennyGambleClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public class ChatHudMixin {
    @Inject(method = "addMessage(Lnet/minecraft/text/Text;)V", at = @At("HEAD"))
    private void onAddMessage(Text message, CallbackInfo ci) {
        String text = message.getString();

        // Check for win/loss messages
        if (text.contains("Won Coinflip")) {
            BennyGambleClient.STRATEGY_MANAGER.onWin();
        } else if (text.contains("Lost Coinflip")) {
            BennyGambleClient.STRATEGY_MANAGER.onLoss();
        }

        // Balance check logic could go here if needed
        // Example: [System] [CHAT] SMP > Balance: £48,001,041
        if (text.contains("Balance:") && text.contains("SMP")) {
            // Parse balance if we want to implement safety checks later
        }
    }
}
