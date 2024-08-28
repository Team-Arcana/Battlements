package net.teamarcana.battlements.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.entity.ThrownBoomerang;
import net.teamarcana.battlements.entity.ThrownJavelin;
import net.teamarcana.battlements.entity.AbstractThrownWeapon;

import java.util.function.Supplier;

public class BattleEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Battlements.MOD_ID);

    public static final Supplier<EntityType<AbstractThrownWeapon>> THROWN_WEAPON =
            ENTITY_TYPES.register("thrown_weapon", ()-> EntityType.Builder.<AbstractThrownWeapon>of(AbstractThrownWeapon::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("thrown_weapon"));
    public static final Supplier<EntityType<ThrownJavelin>> THROWN_JAVELIN =
            ENTITY_TYPES.register("javelin", ()-> EntityType.Builder.<ThrownJavelin>of(ThrownJavelin::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("javelin"));
    public static final Supplier<EntityType<ThrownBoomerang>> THROWN_BOOMERANG =
            ENTITY_TYPES.register("boomerang", ()-> EntityType.Builder.<ThrownBoomerang>of(ThrownBoomerang::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("boomerang"));

    private static EntityType registerEntity(EntityType.Builder builder, String entityName) {
        return builder.build(entityName);
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
