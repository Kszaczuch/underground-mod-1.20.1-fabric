package net.kszaczuch.undergroundmod.sound;

import net.kszaczuch.undergroundmod.UndergroundMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    private static SoundEvent registerSoundEvent(String name) {
        Identifier  id = new Identifier(UndergroundMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        UndergroundMod.LOGGER.info("Registering mod sounds for " + UndergroundMod.MOD_ID);
    }
}
