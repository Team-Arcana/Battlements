package net.teamarcana.battlements.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.teamarcana.battlements.api.archetype.Archetype;

import java.util.Set;

public class ParryingWeaponItem extends BaseWeaponItem{
    private boolean blockPriority = false;
    protected float maxBlockDMG;

    public static Set<ResourceKey<DamageType>> PROJECTILE_DAMAGE = Set.of(DamageTypes.ARROW, DamageTypes.TRIDENT, DamageTypes.FIREBALL, DamageTypes.WITHER_SKULL, DamageTypes.THROWN);
    public static Set<ResourceKey<DamageType>> FIRE_DAMAGE = Set.of(DamageTypes.IN_FIRE, DamageTypes.ON_FIRE, DamageTypes.LAVA, DamageTypes.HOT_FLOOR);
    public static Set<ResourceKey<DamageType>> EXPLOSION_DAMAGE = Set.of(DamageTypes.FIREWORKS, DamageTypes.EXPLOSION);
    public static Set<ResourceKey<DamageType>> MAGIC_DAMAGE = Set.of(DamageTypes.MAGIC, DamageTypes.INDIRECT_MAGIC, DamageTypes.THORNS);

    public ParryingWeaponItem(Tier tier, Archetype archetype, Properties properties) {
        super(tier, archetype, properties);
        this.maxBlockDMG = this.getTier().getAttackDamageBonus() * 3;
    }

    public ParryingWeaponItem(Tier tier, Archetype archetype, Properties properties, String customName) {
        super(tier, archetype, properties, customName);
        this.maxBlockDMG = this.getTier().getAttackDamageBonus() * 3;
    }

    // the meat and potatoes
    public float getMaxBlockDMG() { return maxBlockDMG; }

    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int slot, boolean isSelected) {
        if(entity instanceof LivingEntity livingEntity){
            this.blockPriority = !(livingEntity.getMainHandItem().getItem() instanceof ShieldItem) && !(livingEntity.getOffhandItem().getItem() instanceof ShieldItem);
        }
        super.inventoryTick(item, level, entity, slot, isSelected);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(blockPriority){
            ItemStack item = player.getItemInHand(hand);
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(item);
        }
        return super.use(level, player, hand);
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return (int) (500 / this.getArchetype().getSize());
    }

    @Override
    public UseAnim getUseAnimation(ItemStack item) {
        return blockPriority ? UseAnim.BLOCK : super.getUseAnimation(item);
    }

    public static boolean cantBeBlocked(DamageSource source){
        return PROJECTILE_DAMAGE.stream().anyMatch(source::is) || EXPLOSION_DAMAGE.stream().anyMatch(source::is) || MAGIC_DAMAGE.stream().anyMatch(source::is) || FIRE_DAMAGE.stream().anyMatch(source::is) || !source.isDirect() || source.is(DamageTypes.CACTUS);
    }

    public boolean isAdditionalDamageSource(DamageSource source){
        Set<ResourceKey<DamageType>> additionalDamageTypes = Set.of(DamageTypes.GENERIC, DamageTypes.MAGIC);
        return additionalDamageTypes.stream().noneMatch(source::is);
    }

    public static void onBlocked(LivingShieldBlockEvent event){
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getDamageSource();
        if(cantBeBlocked(source)){ event.setCanceled(true); }
    }
}
