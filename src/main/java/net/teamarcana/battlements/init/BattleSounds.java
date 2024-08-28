package net.teamarcana.battlements.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;

import java.util.function.Supplier;

public class BattleSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, Battlements.MOD_ID);

    // Sound Effects
    public static final Supplier<SoundEvent> BOOMERANG_THROW = registerSoundEvent("item.boomerang.throw");
    public static final Supplier<SoundEvent> BOOMERANG_FLY = registerSoundEvent("item.boomerang.fly");
    public static final Supplier<SoundEvent> BOOMERANG_HIT_BLOCK = registerSoundEvent("item.boomerang.hit.block");
    public static final Supplier<SoundEvent> BOOMERANG_HIT_ENTITY = registerSoundEvent("item.boomerang.hit.entity");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
