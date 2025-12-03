package com.aryangpt007.journeymode.fabric;

import com.aryangpt007.journeymode.fabric.commands.JourneyModeCommand;
import com.aryangpt007.journeymode.fabric.network.packets.RequestItemPacket;
import com.aryangpt007.journeymode.fabric.network.packets.SubmitDepositPacket;
import com.aryangpt007.journeymode.fabric.network.packets.SyncJourneyDataPacket;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for Journey Mode on Fabric
 */
public class JourneyModeFabric implements ModInitializer {
    public static final String MOD_ID = "journeymode";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final net.minecraft.world.inventory.MenuType<com.aryangpt007.journeymode.fabric.menu.JourneyModeMenu> JOURNEY_MODE_MENU = net.minecraft.core.Registry
            .register(
                    net.minecraft.core.registries.BuiltInRegistries.MENU,
                    net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(MOD_ID, "journey_mode_menu"),
                    new net.minecraft.world.inventory.MenuType<>(
                            (syncId, playerInventory) -> new com.aryangpt007.journeymode.fabric.menu.JourneyModeMenu(
                                    syncId, playerInventory),
                            net.minecraft.world.flag.FeatureFlags.DEFAULT_FLAGS));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Journey Mode for Fabric");

        // Register sounds
        com.aryangpt007.journeymode.fabric.sound.ModSounds.registerSounds();

        // Register network packets
        registerPackets();

        // Register commands
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            JourneyModeCommand.register(dispatcher);
        });

        // Register player connection events for data persistence
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            com.aryangpt007.journeymode.fabric.platform.FabricDataHandler.loadPlayerData(handler.getPlayer());
            LOGGER.info("Loaded Journey Mode data for player: {}", handler.getPlayer().getName().getString());
        });

        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            com.aryangpt007.journeymode.fabric.platform.FabricDataHandler.savePlayerData(handler.getPlayer());
            LOGGER.info("Saved Journey Mode data for player: {}", handler.getPlayer().getName().getString());
        });

        // Register server lifecycle events
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            LOGGER.info("Journey Mode server started");
        });

        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            LOGGER.info("Journey Mode server stopping - saving all player data");
            // Save all player data before server stops
            for (net.minecraft.server.level.ServerPlayer player : server.getPlayerList().getPlayers()) {
                com.aryangpt007.journeymode.fabric.platform.FabricDataHandler.savePlayerData(player);
            }
        });
    }

    private void registerPackets() {
        // STEP 1: Register all payload types FIRST
        // Client-to-Server packets
        PayloadTypeRegistry.playC2S().register(
                com.aryangpt007.journeymode.fabric.network.packets.OpenJourneyMenuPacket.TYPE,
                com.aryangpt007.journeymode.fabric.network.packets.OpenJourneyMenuPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(SubmitDepositPacket.TYPE, SubmitDepositPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(RequestItemPacket.TYPE, RequestItemPacket.STREAM_CODEC);

        // Server-to-Client packets
        PayloadTypeRegistry.playS2C().register(SyncJourneyDataPacket.TYPE, SyncJourneyDataPacket.STREAM_CODEC);

        // STEP 2: Register server-side handlers AFTER types are registered
        ServerPlayNetworking.registerGlobalReceiver(
                com.aryangpt007.journeymode.fabric.network.packets.OpenJourneyMenuPacket.TYPE,
                (packet, context) -> com.aryangpt007.journeymode.fabric.network.packets.OpenJourneyMenuPacket
                        .handle(packet, context));

        ServerPlayNetworking.registerGlobalReceiver(SubmitDepositPacket.TYPE,
                (packet, context) -> SubmitDepositPacket.handle(packet, context));

        ServerPlayNetworking.registerGlobalReceiver(RequestItemPacket.TYPE,
                (packet, context) -> RequestItemPacket.handle(packet, context));

        LOGGER.info("Registered Journey Mode network packets");
    }

    /**
     * Helper method to create translatable components
     */
    public static net.minecraft.network.chat.Component translatable(String key, Object... args) {
        return net.minecraft.network.chat.Component.translatable(MOD_ID + "." + key, args);
    }
}
