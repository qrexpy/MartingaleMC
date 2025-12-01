package net.martingalemc.mixin;

import net.martingalemc.MartingaleMCClient;
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
        // Win: [System] [CHAT] COINFLIP > You won! Your balance has been increased by
        // ...
        // Loss: [System] [CHAT] COINFLIP > You lost! ... has been deducted from your
        // balance.
        if (text.contains("COINFLIP > You won!")) {
            MartingaleMCClient.STRATEGY_MANAGER.onWin();
        } else if (text.contains("COINFLIP > You lost!")) {
            MartingaleMCClient.STRATEGY_MANAGER.onLoss();
        }
    }
}
