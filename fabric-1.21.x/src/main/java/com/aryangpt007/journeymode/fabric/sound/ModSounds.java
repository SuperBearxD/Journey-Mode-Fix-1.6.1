package com.aryangpt007.journeymode.fabric.sound;

import com.aryangpt007.journeymode.fabric.JourneyModeFabric;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static final SoundEvent RESEARCH_SOUND = registerSoundEvent("research_sound");
    public static final SoundEvent PRE_RESEARCH_1 = registerSoundEvent("pre_research_1");
    public static final SoundEvent PRE_RESEARCH_2 = registerSoundEvent("pre_research_2");

    private static SoundEvent registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(JourneyModeFabric.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
        JourneyModeFabric.LOGGER.info("Registering ModSounds for " + JourneyModeFabric.MOD_ID);
    }
}
