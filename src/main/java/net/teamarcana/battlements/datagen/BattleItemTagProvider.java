package net.teamarcana.battlements.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.init.BattleItems;
import net.teamarcana.battlements.init.BattleTags;
import net.teamarcana.battlements.init.CommunityTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BattleItemTagProvider extends ItemTagsProvider {
    public BattleItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Battlements.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(CommunityTags.INGOTS_STEEL).add(BattleItems.STEEL_INGOT.get());
        tag(CommunityTags.NUGGETS_STEEL).add(BattleItems.STEEL_INGOT.get());
        tag(CommunityTags.NUGGETS_NETHERITE).add(BattleItems.NETHERITE_NUGGET.get());
        tag(CommunityTags.NUGGETS_DIAMOND).add(BattleItems.DIAMOND_SHARD.get());

        tag(BattleTags.Items.BLADED_MELEE).addTag(CommunityTags.WEAPONS_DAGGER).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_KATANA).addTag(CommunityTags.WEAPONS_RAPIER).addTag(CommunityTags.WEAPONS_SICKLE).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_SPEAR).addTag(CommunityTags.WEAPONS_GLAIVE).addTag(CommunityTags.WEAPONS_SCYTHE).addTag(ItemTags.SWORDS);
        tag(BattleTags.Items.BLADED_THROWING).addTag(CommunityTags.WEAPONS_JAVELIN);
        tag(BattleTags.Items.BLUNT_MELEE).addTag(CommunityTags.WEAPONS_CLUB).addTag(CommunityTags.WEAPONS_HAMMER).addTag(CommunityTags.WEAPONS_ANCHOR).addTag(CommunityTags.WEAPONS_QUARTERSTAFF).add(Items.MACE);
        tag(BattleTags.Items.BLUNT_THROWING).addTag(CommunityTags.WEAPONS_BOOMERANG);

        // enchantment tag stuffs
        tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(CommunityTags.WEAPONS_DAGGER).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_KATANA).addTag(CommunityTags.WEAPONS_RAPIER).addTag(CommunityTags.WEAPONS_SICKLE).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_SPEAR).addTag(CommunityTags.WEAPONS_GLAIVE).addTag(CommunityTags.WEAPONS_SCYTHE).addTag(CommunityTags.WEAPONS_CLUB).addTag(CommunityTags.WEAPONS_HAMMER).addTag(CommunityTags.WEAPONS_ANCHOR).addTag(CommunityTags.WEAPONS_QUARTERSTAFF).addTag(CommunityTags.WEAPONS_BOOMERANG).addTag(CommunityTags.WEAPONS_JAVELIN);
        tag(ItemTags.WEAPON_ENCHANTABLE).addTag(CommunityTags.WEAPONS_DAGGER).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_KATANA).addTag(CommunityTags.WEAPONS_RAPIER).addTag(CommunityTags.WEAPONS_SICKLE).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_SPEAR).addTag(CommunityTags.WEAPONS_GLAIVE).addTag(CommunityTags.WEAPONS_SCYTHE).addTag(CommunityTags.WEAPONS_CLUB).addTag(CommunityTags.WEAPONS_HAMMER).addTag(CommunityTags.WEAPONS_ANCHOR).addTag(CommunityTags.WEAPONS_QUARTERSTAFF).addTag(CommunityTags.WEAPONS_BOOMERANG).addTag(CommunityTags.WEAPONS_JAVELIN);

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(BattleTags.Items.BLADED_MELEE).addTag(CommunityTags.WEAPONS_JAVELIN);

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(CommunityTags.WEAPONS_HAMMER).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_CLAW);
        tag(ItemTags.MINING_ENCHANTABLE).addTag(CommunityTags.WEAPONS_HAMMER).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_CLAW);
        tag(CommunityTags.ENCHANTABLE_BLUNT).addTag(BattleTags.Items.BLUNT_MELEE);

        tag(CommunityTags.KNOCKBACK_ENCHANTABLE).addTag(ItemTags.SWORD_ENCHANTABLE).addTag(BattleTags.Items.BLUNT_MELEE).addTag(CommunityTags.WEAPONS_JAVELIN);
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).addTag(BattleTags.Items.BLADED_MELEE).addTag(BattleTags.Items.BLUNT_MELEE).addTag(CommunityTags.WEAPONS_BOOMERANG).addTag(CommunityTags.WEAPONS_JAVELIN);
        tag(BattleTags.Items.FROSTBITE_ENCHANTABLE).addTag(ItemTags.FIRE_ASPECT_ENCHANTABLE);
        tag(CommunityTags.SWEEPING_ENCHANTABLE).addTag(ItemTags.SWORD_ENCHANTABLE).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_GLAIVE);
        tag(CommunityTags.LOOTING_ENCHANTABLE).addTag(ItemTags.SWORD_ENCHANTABLE).addTag(BattleTags.Items.BLADED_MELEE).addTag(BattleTags.Items.BLUNT_MELEE).addTag(CommunityTags.WEAPONS_BOOMERANG).addTag(CommunityTags.WEAPONS_JAVELIN);

        tag(ItemTags.SWORDS).add(BattleItems.STEEL_SWORD.get());
        tag(ItemTags.PICKAXES).add(BattleItems.STEEL_PICKAXE.get());
        tag(ItemTags.AXES).add(BattleItems.STEEL_AXE.get());
        tag(ItemTags.SHOVELS).add(BattleItems.STEEL_SHOVEL.get());
        tag(ItemTags.HOES).add(BattleItems.STEEL_HOE.get());

        tag(ItemTags.SWORD_ENCHANTABLE).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_KATANA).addTag(CommunityTags.WEAPONS_CUTLASS);

        // Weapon Tag Stuffs
        tag(CommunityTags.WEAPONS_BATTLEAXE).add(
                BattleItems.STONE_BATTLEAXE.get(),
                BattleItems.GOLDEN_BATTLEAXE.get(),
                BattleItems.IRON_BATTLEAXE.get(),
                BattleItems.STEEL_BATTLEAXE.get(),
                BattleItems.DIAMOND_BATTLEAXE.get(),
                BattleItems.NETHERITE_BATTLEAXE.get()
        );
        /*
        tag(CommunityTags.WEAPONS_DAGGER).add(
        );
        tag(CommunityTags.WEAPONS_GREATSWORD).add(
        );
        tag(CommunityTags.WEAPONS_KATANA).add(
        );
        tag(CommunityTags.WEAPONS_RAPIER).add(
        );
        tag(CommunityTags.WEAPONS_CUTLASS).add(
        );
        tag(CommunityTags.WEAPONS_SICKLE).add(
        );
        tag(CommunityTags.WEAPONS_CLAW).add(
        );
        tag(CommunityTags.WEAPONS_CLUB).add(
        );
        tag(CommunityTags.WEAPONS_HAMMER).add(
        );
        tag(CommunityTags.WEAPONS_ANCHOR).add(
        );
        tag(CommunityTags.WEAPONS_SPEAR).add(
        );
        tag(CommunityTags.WEAPONS_QUARTERSTAFF).add(
        );
        tag(CommunityTags.WEAPONS_GLAIVE).add(
        );
        tag(CommunityTags.WEAPONS_SCYTHE).add(
        );
        tag(CommunityTags.WEAPONS_JAVELIN).add(
        );
        tag(CommunityTags.WEAPONS_BOOMERANG).add(
        );
         */
    }
}
