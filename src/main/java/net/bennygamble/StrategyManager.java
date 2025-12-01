package net.bennygamble;

import net.minecraft.client.MinecraftClient;

public class StrategyManager {
    private boolean active = false;
    private long initialBet = 0;
    private long currentBet = 0;
    private boolean isHeads = true; // true = heads, false = tails
    private boolean waitingForBalance = false;

    public void start(long initialBet) {
        this.initialBet = initialBet;
        this.currentBet = initialBet;
        this.active = true;
        this.isHeads = true; // Default start with heads
        this.waitingForBalance = false;

        executeBet();
    }

    public void stop() {
        this.active = false;
    }

    public void onWin() {
        if (!active)
            return;
        // Win: Reset to initial bet, switch face
        currentBet = initialBet;
        isHeads = !isHeads;
        executeBet();
    }

    public void onLoss() {
        if (!active)
            return;
        // Loss: Double bet, same face
        currentBet *= 2;
        executeBet();
    }

    private void executeBet() {
        if (!active)
            return;

        // Check balance first? The prompt says "check the user's balance in a command
        // with /balance"
        // But the example flow shows just doing /cf.
        // However, the prompt also says "We need the mod to check the user's balance...
        // and then the program calculates an initial bet OR ask the user to input one."
        // Since we ask the user to input one in /bg start, we might not strictly need
        // to check balance every time unless we want to be safe.
        // Let's just execute the bet for now as per the simple flow.

        String face = isHeads ? "heads" : "tails";
        String command = "cf " + currentBet + " " + face;

        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.networkHandler.sendChatCommand(command);
        }
    }
}
