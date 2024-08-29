package net.teamarcana.battlements.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.teamarcana.battlements.entity.ThrownJavelin;
import net.teamarcana.battlements.entity.AbstractThrownWeapon;
import net.teamarcana.battlements.init.BattleArchetypes;
import net.teamarcana.battlements.init.BattleEntities;

public class JavelinItem extends ThrowingWeaponItem{
    public JavelinItem(Tier tier, Properties properties) {
        super(tier, BattleArchetypes.JAVELIN, properties);
    }
    public JavelinItem(Tier tier, Properties properties, String customName) {
        super(tier, BattleArchetypes.JAVELIN, properties, customName);
    }

    @Override
    public AbstractThrownWeapon createThrownWeapon(Level level, Player player, ItemStack item, int charge) {
        return new ThrownJavelin(BattleEntities.THROWN_JAVELIN.get(), level, player, item).setWeapon(item).setWeapon(item).setBaseDamage(getAttackDamage());
    }
}
