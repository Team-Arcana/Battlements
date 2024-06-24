package net.teamarcana.battlements.init;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.trait.Trait;

public class BattleTraits {
    public static final DeferredRegister<Trait> WEAPON_TRAITS = DeferredRegister.create(Battlements.TRAIT_KEY, Battlements.MOD_ID);



    public static void register(IEventBus eventBus){
        WEAPON_TRAITS.register(eventBus);
    }
}
