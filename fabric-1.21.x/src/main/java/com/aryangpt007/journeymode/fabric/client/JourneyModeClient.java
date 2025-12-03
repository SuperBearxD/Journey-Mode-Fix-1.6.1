package com.aryangpt007.journeymode.fabric.client;

import com.aryangpt007.journeymode.fabric.network.packets.OpenJourneyMenuPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

/**
 * Client-side initialization for Journey Mode on Fabric
 */
public class JourneyModeClient implements ClientModInitializer {

    private static KeyMapping journeyKeyBinding;

    @Override
    public void onInitializeClient() {
        // Register screen handler for Journey Mode menu
        net.minecraft.client.gui.screens.MenuScreens.register(
                com.aryangpt007.journeymode.fabric.JourneyModeFabric.JOURNEY_MODE_MENU,
                com.aryangpt007.journeymode.fabric.client.screen.JourneyModeScreen::new);

        // Register client-side packet handlers
        net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking.registerGlobalReceiver(
                com.aryangpt007.journeymode.fabric.network.packets.SyncJourneyDataPacket.TYPE,
                (payload, context) -> com.aryangpt007.journeymode.fabric.network.packets.SyncJourneyDataPacket
                        .handle(payload, context));

        // Register keybinding
        journeyKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.journeymode.open_menu",
                GLFW.GLFW_KEY_J,
                "category.journeymode"));

        // Register key event handler
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (journeyKeyBinding.consumeClick()) {
                if (client.player != null) {
                    // Send packet to server to open menu
                    ClientPlayNetworking.send(new OpenJourneyMenuPacket());
                }
            }
        });
    }
}
