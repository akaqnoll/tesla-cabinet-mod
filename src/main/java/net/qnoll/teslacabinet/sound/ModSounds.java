package net.qnoll.teslacabinet.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.qnoll.teslacabinet.TeslaCabinet;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, TeslaCabinet.MOD_ID);

    public static final RegistryObject<SoundEvent> CLICK1 = registerSoundEvents("click1");
    public static final RegistryObject<SoundEvent> CLICK2 = registerSoundEvents("click2");
    public static final RegistryObject<SoundEvent> CLICK3 = registerSoundEvents("click3");
    public static final RegistryObject<SoundEvent> CLICK4 = registerSoundEvents("click4");
    public static final RegistryObject<SoundEvent> CLICK5 = registerSoundEvents("click5");
    public static final RegistryObject<SoundEvent> CLICK6 = registerSoundEvents("click6");
    public static final RegistryObject<SoundEvent> CLICK7 = registerSoundEvents("click7");
    public static final RegistryObject<SoundEvent> CLICK8 = registerSoundEvents("click8");

    public static final RegistryObject<SoundEvent> TANGO_TREE_SOUND = registerSoundEvents("tango_tree_sound");

    // Optional helper array for random selection
    @SuppressWarnings("rawtypes")
    public static final RegistryObject<SoundEvent>[] CLICK_SOUNDS = new RegistryObject[] {
            CLICK1, CLICK2, CLICK3, CLICK4, CLICK5, CLICK6, CLICK7, CLICK8
    };

    //helper
    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name,
                () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TeslaCabinet.MOD_ID, name)));
    }

    // Call this once from your mod constructor to register the DeferredRegister with the mod event bus:
    public static void register(IEventBus modEventBus) {
        SOUND_EVENTS.register(modEventBus);
    }
}