package com.aryangpt007.journeymode.sound;

import com.aryangpt007.journeymode.JourneyMode;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT,
            JourneyMode.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> RESEARCH_SOUND = registerSound("research_sound");
    public static final DeferredHolder<SoundEvent, SoundEvent> PRE_RESEARCH_1 = registerSound("pre_research_1");
    public static final DeferredHolder<SoundEvent, SoundEvent> PRE_RESEARCH_2 = registerSound("pre_research_2");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> SoundEvent
                .createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(JourneyMode.MODID, name)));
    }
}
