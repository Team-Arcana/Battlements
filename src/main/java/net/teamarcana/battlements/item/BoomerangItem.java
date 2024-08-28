package net.teamarcana.battlements.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.teamarcana.battlements.entity.ThrownBoomerang;
import net.teamarcana.battlements.entity.AbstractThrownWeapon;
import net.teamarcana.battlements.init.BattleArchetypes;
import net.teamarcana.battlements.init.BattleEntities;

public class BoomerangItem extends ThrowingWeaponItem{

    public BoomerangItem(Tier tier, Properties properties) {
        super(tier, BattleArchetypes.BOOMERANG, properties);
    }

    public BoomerangItem(Tier tier, Properties properties, String customName) {
        super(tier, BattleArchetypes.BOOMERANG, properties, customName);
    }

    @Override
    public AbstractThrownWeapon createThrownWeapon(Level level, Player player, ItemStack item, int charge) {
        ThrownBoomerang boomerang = (ThrownBoomerang) new ThrownBoomerang(BattleEntities.THROWN_BOOMERANG.get(), level, player, item).setWeapon(item);

        boomerang.setReturnDistance((charge / 5.0d) * (ThrownBoomerang.distanceToReturn - 3.0d)
                + 3.0d);

        return boomerang;
    }
}
