package net.bennygamble;

import net.minecraft.client.MinecraftClient;

public class StrategyManager {
    private boolean active = false;
    private long initialBet = 0;
    private long currentBet = 0;
    private boolean isHeads = true; // true = heads, false = tails

    public void start(long initialBet) {
        this.initialBet = initialBet;
        this.currentBet = initialBet;
        this.active = true;
        // Randomly choose heads or tails to start
        this.isHeads = Math.random() < 0.5;

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

        String face = isHeads ? "heads" : "tails";
        String command = "cf " + currentBet + " " + face;

        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.networkHandler.sendChatCommand(command);
        }
    }
}
