package net.bennygamble;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import com.mojang.brigadier.arguments.LongArgumentType;
import net.minecraft.text.Text;

public class BennyGambleClient implements ClientModInitializer {
    public static final StrategyManager STRATEGY_MANAGER = new StrategyManager();

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("bg")
                    .then(ClientCommandManager.literal("start")
                            .then(ClientCommandManager.argument("initialBet", LongArgumentType.longArg(1))
                                    .executes(context -> {
                                        long initialBet = LongArgumentType.getLong(context, "initialBet");
                                        STRATEGY_MANAGER.start(initialBet);
                                        context.getSource().sendFeedback(
                                                Text.of("BennyGamble started with initial bet: " + initialBet));
                                        return 1;
                                    })))
                    .then(ClientCommandManager.literal("stop")
                            .executes(context -> {
                                STRATEGY_MANAGER.stop();
                                context.getSource().sendFeedback(Text.of("BennyGamble stopped."));
                                return 1;
                            })));
        });
    }
}
