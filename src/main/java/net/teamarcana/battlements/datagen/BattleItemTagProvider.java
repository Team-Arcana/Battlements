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
        tag(ItemTags.PICKAXES).add(BattleItems.STEEL_PICKAXE.get()).addTag(CommunityTags.WEAPONS_HAMMER);
        tag(ItemTags.AXES).add(BattleItems.STEEL_AXE.get()).addTag(CommunityTags.WEAPONS_BATTLEAXE);
        tag(ItemTags.SHOVELS).add(BattleItems.STEEL_SHOVEL.get()).addTag(CommunityTags.WEAPONS_CLAW);
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
        tag(CommunityTags.WEAPONS_DAGGER).add(
                BattleItems.FLINT_DAGGER.get(),
                BattleItems.BONE_DAGGER.get(),
                BattleItems.GOLDEN_DAGGER.get(),
                BattleItems.IRON_DAGGER.get(),
                BattleItems.STEEL_DAGGER.get(),
                BattleItems.DIAMOND_DAGGER.get(),
                BattleItems.NETHERITE_DAGGER.get()
        );
        tag(CommunityTags.WEAPONS_GREATSWORD).add(
                BattleItems.STONE_GREATSWORD.get(),
                BattleItems.GOLDEN_GREATSWORD.get(),
                BattleItems.IRON_GREATSWORD.get(),
                BattleItems.STEEL_GREATSWORD.get(),
                BattleItems.DIAMOND_GREATSWORD.get(),
                BattleItems.NETHERITE_GREATSWORD.get()
        );
        tag(CommunityTags.WEAPONS_KATANA).add(
                BattleItems.GOLDEN_KATANA.get(),
                BattleItems.IRON_KATANA.get(),
                BattleItems.STEEL_KATANA.get(),
                BattleItems.DIAMOND_KATANA.get(),
                BattleItems.NETHERITE_KATANA.get()
        );
        tag(CommunityTags.WEAPONS_RAPIER).add(
                BattleItems.GOLDEN_RAPIER.get(),
                BattleItems.IRON_RAPIER.get(),
                BattleItems.STEEL_RAPIER.get(),
                BattleItems.DIAMOND_RAPIER.get(),
                BattleItems.NETHERITE_RAPIER.get()
        );
        tag(CommunityTags.WEAPONS_CUTLASS).add(
                BattleItems.WOODEN_CUTLASS.get(),
                BattleItems.GOLDEN_CUTLASS.get(),
                BattleItems.IRON_CUTLASS.get(),
                BattleItems.STEEL_CUTLASS.get(),
                BattleItems.DIAMOND_CUTLASS.get(),
                BattleItems.NETHERITE_CUTLASS.get()
        );
        tag(CommunityTags.WEAPONS_SICKLE).add(
                BattleItems.GOLDEN_SICKLE.get(),
                BattleItems.IRON_SICKLE.get(),
                BattleItems.STEEL_SICKLE.get(),
                BattleItems.DIAMOND_SICKLE.get(),
                BattleItems.NETHERITE_SICKLE.get()
        );
        tag(CommunityTags.WEAPONS_CLAW).add(
                BattleItems.FLINT_CLAW.get(),
                BattleItems.GOLDEN_CLAW.get(),
                BattleItems.IRON_CLAW.get(),
                BattleItems.STEEL_CLAW.get(),
                BattleItems.DIAMOND_CLAW.get(),
                BattleItems.NETHERITE_CLAW.get()
        );
        tag(CommunityTags.WEAPONS_CLUB).add(
                BattleItems.WOODEN_CLUB.get(),
                BattleItems.BONE_CLUB.get()
        );
        tag(CommunityTags.WEAPONS_HAMMER).add(
                BattleItems.GOLDEN_HAMMER.get(),
                BattleItems.IRON_HAMMER.get(),
                BattleItems.STEEL_HAMMER.get(),
                BattleItems.DIAMOND_HAMMER.get(),
                BattleItems.NETHERITE_HAMMER.get()
        );
        tag(CommunityTags.WEAPONS_ANCHOR).add(
                BattleItems.GOLDEN_ANCHOR.get(),
                BattleItems.IRON_ANCHOR.get(),
                BattleItems.STEEL_ANCHOR.get(),
                BattleItems.DIAMOND_ANCHOR.get(),
                BattleItems.NETHERITE_ANCHOR.get()
        );
        tag(CommunityTags.WEAPONS_SPEAR).add(
                BattleItems.FLINT_SPEAR.get(),
                BattleItems.GOLDEN_SPEAR.get(),
                BattleItems.IRON_SPEAR.get(),
                BattleItems.STEEL_SPEAR.get(),
                BattleItems.DIAMOND_SPEAR.get(),
                BattleItems.NETHERITE_SPEAR.get()
        );
        tag(CommunityTags.WEAPONS_QUARTERSTAFF).add(
                BattleItems.WOODEN_QUARTERSTAFF.get(),
                BattleItems.GOLDEN_QUARTERSTAFF.get(),
                BattleItems.IRON_QUARTERSTAFF.get(),
                BattleItems.STEEL_QUARTERSTAFF.get(),
                BattleItems.DIAMOND_QUARTERSTAFF.get(),
                BattleItems.NETHERITE_QUARTERSTAFF.get()
        );
        tag(CommunityTags.WEAPONS_GLAIVE).add(
                BattleItems.STONE_GLAIVE.get(),
                BattleItems.GOLDEN_GLAIVE.get(),
                BattleItems.IRON_GLAIVE.get(),
                BattleItems.STEEL_GLAIVE.get(),
                BattleItems.DIAMOND_GLAIVE.get(),
                BattleItems.NETHERITE_GLAIVE.get()
        );
        tag(CommunityTags.WEAPONS_SCYTHE).add(
                BattleItems.WOODEN_SCYTHE.get(),
                BattleItems.GOLDEN_SCYTHE.get(),
                BattleItems.IRON_SCYTHE.get(),
                BattleItems.STEEL_SCYTHE.get(),
                BattleItems.DIAMOND_SCYTHE.get(),
                BattleItems.NETHERITE_SCYTHE.get()
        );
        tag(CommunityTags.WEAPONS_JAVELIN).add(
                BattleItems.FLINT_JAVELIN.get(),
                BattleItems.GOLDEN_JAVELIN.get(),
                BattleItems.IRON_JAVELIN.get(),
                BattleItems.STEEL_JAVELIN.get(),
                BattleItems.DIAMOND_JAVELIN.get(),
                BattleItems.NETHERITE_JAVELIN.get()
        );
        tag(CommunityTags.WEAPONS_BOOMERANG).add(
                BattleItems.WOODEN_BOOMERANG.get(),
                BattleItems.GOLDEN_BOOMERANG.get(),
                BattleItems.IRON_BOOMERANG.get(),
                BattleItems.STEEL_BOOMERANG.get(),
                BattleItems.DIAMOND_BOOMERANG.get(),
                BattleItems.NETHERITE_BOOMERANG.get()
        );

        tag(BattleTags.Items.LOYALTY_ENCHANTABLE).addTag(ItemTags.TRIDENT_ENCHANTABLE).addTag(CommunityTags.WEAPONS_JAVELIN);
    }
}
