package com.aryangpt007.journeymode.platform.neoforge;

import com.aryangpt007.journeymode.core.JourneyData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.LevelResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * NeoForge data handler for storing player Journey Mode data.
 * Uses a simple in-memory map with JSON file serialization for persistence.
 * Replaces the AttachmentType system to fix data loss issues.
 */
public class NeoForgeDataHandler {

    public static final String MODID = "journeymode";
    private static final Logger LOGGER = LoggerFactory.getLogger("JourneyMode");

    // In-memory cache
    private static final Map<UUID, JourneyData> PLAYER_DATA = new HashMap<>();

    /**
     * Get Journey Mode data for a player
     */
    public static JourneyData getJourneyData(Player player) {
        return PLAYER_DATA.computeIfAbsent(player.getUUID(), uuid -> new JourneyData());
    }

    /**
     * Save Journey Mode data for a player (updates cache)
     */
    public static void saveJourneyData(Player player, JourneyData data) {
        PLAYER_DATA.put(player.getUUID(), data);
    }

    /**
     * Remove player data when they disconnect
     */
    public static void removePlayerData(UUID playerUUID) {
        PLAYER_DATA.remove(playerUUID);
    }

    /**
     * Load player data from file when they join the server
     */
    public static void loadPlayerData(ServerPlayer player) {
        try {
            File playerDataDir = new File(
                    player.getServer().getWorldPath(LevelResource.PLAYER_DATA_DIR)
                            .toFile().getParentFile(),
                    "journeymode");
            File playerFile = new File(playerDataDir, player.getUUID().toString() + ".json");

            if (playerFile.exists()) {
                String jsonData = new String(Files.readAllBytes(playerFile.toPath()));
                JourneyData data = JourneyData.fromJsonString(jsonData);
                PLAYER_DATA.put(player.getUUID(), data);
                LOGGER.info("Loaded Journey Mode data for player: {}", player.getName().getString());
            } else {
                // Create new data if file doesn't exist
                PLAYER_DATA.put(player.getUUID(), new JourneyData());
                LOGGER.info("Created new Journey Mode data for player: {}", player.getName().getString());
            }
        } catch (Exception e) {
            LOGGER.error("Failed to load Journey Mode data for player: {}", player.getName().getString(), e);
            PLAYER_DATA.put(player.getUUID(), new JourneyData());
        }
    }

    /**
     * Save player data to file
     */
    public static void savePlayerData(ServerPlayer player) {
        try {
            JourneyData data = PLAYER_DATA.get(player.getUUID());
            if (data == null)
                return;

            File playerDataDir = new File(
                    player.getServer().getWorldPath(LevelResource.PLAYER_DATA_DIR)
                            .toFile().getParentFile(),
                    "journeymode");
            if (!playerDataDir.exists()) {
                playerDataDir.mkdirs();
            }

            File playerFile = new File(playerDataDir, player.getUUID().toString() + ".json");
            String jsonData = data.toJsonString();
            Files.write(playerFile.toPath(), jsonData.getBytes());

            LOGGER.info("Saved Journey Mode data for player: {}", player.getName().getString());
        } catch (Exception e) {
            LOGGER.error("Failed to save Journey Mode data for player: {}", player.getName().getString(), e);
        }
    }
}
