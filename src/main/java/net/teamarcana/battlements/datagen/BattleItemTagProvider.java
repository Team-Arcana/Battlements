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
        // IMPORTANT TAG FOR TOOLTIP MODIFICATION
        tag(BattleTags.Items.EQUIPPABLE)
                .addTag(Tags.Items.ARMORS)
                .addTag(Tags.Items.TOOLS)
                .addTag(Tags.Items.TOOLS_BOWS)
                .addTag(Tags.Items.TOOLS_CROSSBOWS)
                .addTag(Tags.Items.TOOLS_BRUSHES)
                .addTag(Tags.Items.TOOLS_SHEARS)
                .addTag(Tags.Items.TOOLS_SHIELDS)
                .addTag(Tags.Items.TOOLS_FISHING_RODS)
        ;

        // other

        tag(CommunityTags.INGOTS_STEEL).add(BattleItems.STEEL_INGOT.get());
        tag(CommunityTags.NUGGETS_STEEL).add(BattleItems.STEEL_INGOT.get());
        tag(CommunityTags.INGOTS_ENDERIUM).add(BattleItems.ENDERIUM_INGOT.get());
        tag(CommunityTags.NUGGETS_ENDERIUM).add(BattleItems.ENDERIUM_NUGGET.get());
        tag(CommunityTags.NUGGETS_NETHERITE).add(BattleItems.NETHERITE_NUGGET.get());
        tag(CommunityTags.NUGGETS_DIAMOND).add(BattleItems.DIAMOND_SHARD.get());

        tag(BattleTags.Items.BLADED_MELEE).addTag(CommunityTags.WEAPONS_DAGGER).addTag(CommunityTags.WEAPONS_LONGSWORD).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_KATANA).addTag(CommunityTags.WEAPONS_RAPIER).addTag(CommunityTags.WEAPONS_SABER).addTag(CommunityTags.WEAPONS_SICKLE).addTag(CommunityTags.WEAPONS_WARPICK).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_GREATAXE).addTag(CommunityTags.WEAPONS_SPEAR).addTag(CommunityTags.WEAPONS_PIKE).addTag(CommunityTags.WEAPONS_GLAIVE).addTag(CommunityTags.WEAPONS_SCYTHE).addTag(CommunityTags.WEAPONS_PITCHFORK).addTag(CommunityTags.WEAPONS_HALBERD).addTag(ItemTags.SWORDS);
        tag(BattleTags.Items.BLADED_THROWING).addTag(CommunityTags.WEAPONS_JAVELIN).addTag(CommunityTags.WEAPONS_KUNAI).addTag(CommunityTags.WEAPONS_THROWING_KNIFE).addTag(CommunityTags.WEAPONS_TOMAHAWK);
        tag(BattleTags.Items.BLUNT_MELEE).addTag(CommunityTags.WEAPONS_CLUB).addTag(CommunityTags.WEAPONS_GREATCLUB).addTag(CommunityTags.WEAPONS_HAMMER).addTag(CommunityTags.WEAPONS_WARHAMMER).addTag(CommunityTags.WEAPONS_MAUL).addTag(CommunityTags.WEAPONS_ANCHOR).addTag(CommunityTags.WEAPONS_QUARTERSTAFF).add(Items.MACE);
        tag(BattleTags.Items.BLUNT_THROWING).addTag(CommunityTags.WEAPONS_BOOMERANG);

        // enchantment tag stuffs
        tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(CommunityTags.WEAPONS_DAGGER).addTag(CommunityTags.WEAPONS_LONGSWORD).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_KATANA).addTag(CommunityTags.WEAPONS_RAPIER).addTag(CommunityTags.WEAPONS_SABER).addTag(CommunityTags.WEAPONS_SICKLE).addTag(CommunityTags.WEAPONS_WARPICK).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_GREATAXE).addTag(CommunityTags.WEAPONS_SPEAR).addTag(CommunityTags.WEAPONS_PIKE).addTag(CommunityTags.WEAPONS_GLAIVE).addTag(CommunityTags.WEAPONS_SCYTHE).addTag(CommunityTags.WEAPONS_PITCHFORK).addTag(CommunityTags.WEAPONS_CLUB).addTag(CommunityTags.WEAPONS_GREATCLUB).addTag(CommunityTags.WEAPONS_HAMMER).addTag(CommunityTags.WEAPONS_WARHAMMER).addTag(CommunityTags.WEAPONS_MAUL).addTag(CommunityTags.WEAPONS_ANCHOR).addTag(CommunityTags.WEAPONS_QUARTERSTAFF).addTag(CommunityTags.WEAPONS_BOOMERANG).addTag(CommunityTags.WEAPONS_HALBERD).addTag(CommunityTags.WEAPONS_JAVELIN);
        tag(ItemTags.WEAPON_ENCHANTABLE).addTag(CommunityTags.WEAPONS_DAGGER).addTag(CommunityTags.WEAPONS_LONGSWORD).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_KATANA).addTag(CommunityTags.WEAPONS_RAPIER).addTag(CommunityTags.WEAPONS_SABER).addTag(CommunityTags.WEAPONS_SICKLE).addTag(CommunityTags.WEAPONS_WARPICK).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_GREATAXE).addTag(CommunityTags.WEAPONS_SPEAR).addTag(CommunityTags.WEAPONS_PIKE).addTag(CommunityTags.WEAPONS_GLAIVE).addTag(CommunityTags.WEAPONS_SCYTHE).addTag(CommunityTags.WEAPONS_PITCHFORK).addTag(CommunityTags.WEAPONS_CLUB).addTag(CommunityTags.WEAPONS_GREATCLUB).addTag(CommunityTags.WEAPONS_HAMMER).addTag(CommunityTags.WEAPONS_WARHAMMER).addTag(CommunityTags.WEAPONS_MAUL).addTag(CommunityTags.WEAPONS_ANCHOR).addTag(CommunityTags.WEAPONS_QUARTERSTAFF).addTag(CommunityTags.WEAPONS_BOOMERANG).addTag(CommunityTags.WEAPONS_JAVELIN);

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(BattleTags.Items.BLADED_MELEE).addTag(CommunityTags.WEAPONS_JAVELIN);

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(CommunityTags.WEAPONS_WARPICK).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_GREATAXE).addTag(CommunityTags.WEAPONS_CLAW);
        tag(ItemTags.MINING_ENCHANTABLE).addTag(CommunityTags.WEAPONS_WARPICK).addTag(CommunityTags.WEAPONS_BATTLEAXE).addTag(CommunityTags.WEAPONS_GREATAXE).addTag(CommunityTags.WEAPONS_CLAW);
        tag(CommunityTags.ENCHANTABLE_BLUNT).addTag(BattleTags.Items.BLUNT_MELEE);

        tag(CommunityTags.KNOCKBACK_ENCHANTABLE).addTag(ItemTags.SWORD_ENCHANTABLE).addTag(BattleTags.Items.BLUNT_MELEE).addTag(CommunityTags.WEAPONS_JAVELIN);
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).addTag(BattleTags.Items.BLADED_MELEE).addTag(BattleTags.Items.BLUNT_MELEE).addTag(CommunityTags.WEAPONS_BOOMERANG).addTag(CommunityTags.WEAPONS_JAVELIN);
        tag(BattleTags.Items.FROSTBITE_ENCHANTABLE).addTag(ItemTags.FIRE_ASPECT_ENCHANTABLE);
        tag(CommunityTags.SWEEPING_ENCHANTABLE).addTag(ItemTags.SWORD_ENCHANTABLE).addTag(CommunityTags.WEAPONS_LONGSWORD).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_SABER).addTag(CommunityTags.WEAPONS_GLAIVE);
        tag(CommunityTags.LOOTING_ENCHANTABLE).addTag(ItemTags.SWORD_ENCHANTABLE).addTag(BattleTags.Items.BLADED_MELEE).addTag(BattleTags.Items.BLUNT_MELEE).addTag(CommunityTags.WEAPONS_BOOMERANG).addTag(CommunityTags.WEAPONS_JAVELIN);

        tag(ItemTags.SWORDS).add(BattleItems.STEEL_SWORD.get(), BattleItems.ENDERIUM_SWORD.get());
        tag(ItemTags.PICKAXES).add(BattleItems.STEEL_PICKAXE.get(), BattleItems.ENDERIUM_PICKAXE.get());
        tag(ItemTags.AXES).add(BattleItems.STEEL_AXE.get(), BattleItems.ENDERIUM_AXE.get());
        tag(ItemTags.SHOVELS).add(BattleItems.STEEL_SHOVEL.get(), BattleItems.ENDERIUM_SHOVEL.get());
        tag(ItemTags.HOES).add(BattleItems.STEEL_HOE.get(), BattleItems.ENDERIUM_HOE.get());

        tag(ItemTags.SWORD_ENCHANTABLE).addTag(CommunityTags.WEAPONS_LONGSWORD).addTag(CommunityTags.WEAPONS_GREATSWORD).addTag(CommunityTags.WEAPONS_KATANA).addTag(CommunityTags.WEAPONS_SABER).addTag(CommunityTags.WEAPONS_CUTLASS);

        // Weapon Tag Stuffs
        tag(CommunityTags.WEAPONS_DAGGER).add(
                BattleItems.WOODEN_DAGGER.get(),
                BattleItems.STONE_DAGGER.get(),
                BattleItems.GOLDEN_DAGGER.get(),
                BattleItems.IRON_DAGGER.get(),
                BattleItems.STEEL_DAGGER.get(),
                BattleItems.DIAMOND_DAGGER.get(),
                BattleItems.NETHERITE_DAGGER.get(),
                BattleItems.ENDERIUM_DAGGER.get()
        );
        tag(CommunityTags.WEAPONS_LONGSWORD).add(
                BattleItems.WOODEN_LONGSWORD.get(),
                BattleItems.STONE_LONGSWORD.get(),
                BattleItems.GOLDEN_LONGSWORD.get(),
                BattleItems.IRON_LONGSWORD.get(),
                BattleItems.STEEL_LONGSWORD.get(),
                BattleItems.DIAMOND_LONGSWORD.get(),
                BattleItems.NETHERITE_LONGSWORD.get(),
                BattleItems.ENDERIUM_LONGSWORD.get()
        );
        tag(CommunityTags.WEAPONS_GREATSWORD).add(
                BattleItems.WOODEN_GREATSWORD.get(),
                BattleItems.STONE_GREATSWORD.get(),
                BattleItems.GOLDEN_GREATSWORD.get(),
                BattleItems.IRON_GREATSWORD.get(),
                BattleItems.STEEL_GREATSWORD.get(),
                BattleItems.DIAMOND_GREATSWORD.get(),
                BattleItems.NETHERITE_GREATSWORD.get(),
                BattleItems.ENDERIUM_GREATSWORD.get()
        );
        tag(CommunityTags.WEAPONS_KATANA).add(
                BattleItems.WOODEN_KATANA.get(),
                BattleItems.STONE_KATANA.get(),
                BattleItems.GOLDEN_KATANA.get(),
                BattleItems.IRON_KATANA.get(),
                BattleItems.STEEL_KATANA.get(),
                BattleItems.DIAMOND_KATANA.get(),
                BattleItems.NETHERITE_KATANA.get(),
                BattleItems.ENDERIUM_KATANA.get()
        );
        tag(CommunityTags.WEAPONS_RAPIER).add(
                BattleItems.WOODEN_RAPIER.get(),
                BattleItems.STONE_RAPIER.get(),
                BattleItems.GOLDEN_RAPIER.get(),
                BattleItems.IRON_RAPIER.get(),
                BattleItems.STEEL_RAPIER.get(),
                BattleItems.DIAMOND_RAPIER.get(),
                BattleItems.NETHERITE_RAPIER.get(),
                BattleItems.ENDERIUM_RAPIER.get()
        );
        tag(CommunityTags.WEAPONS_SABER).add(
                BattleItems.WOODEN_SABER.get(),
                BattleItems.STONE_SABER.get(),
                BattleItems.GOLDEN_SABER.get(),
                BattleItems.IRON_SABER.get(),
                BattleItems.STEEL_SABER.get(),
                BattleItems.DIAMOND_SABER.get(),
                BattleItems.NETHERITE_SABER.get(),
                BattleItems.ENDERIUM_SABER.get()
        );
        tag(CommunityTags.WEAPONS_CUTLASS).add(
                BattleItems.WOODEN_CUTLASS.get(),
                BattleItems.STONE_CUTLASS.get(),
                BattleItems.GOLDEN_CUTLASS.get(),
                BattleItems.IRON_CUTLASS.get(),
                BattleItems.STEEL_CUTLASS.get(),
                BattleItems.DIAMOND_CUTLASS.get(),
                BattleItems.NETHERITE_CUTLASS.get(),
                BattleItems.ENDERIUM_CUTLASS.get()
        );
        tag(CommunityTags.WEAPONS_SICKLE).add(
                BattleItems.WOODEN_SICKLE.get(),
                BattleItems.STONE_SICKLE.get(),
                BattleItems.GOLDEN_SICKLE.get(),
                BattleItems.IRON_SICKLE.get(),
                BattleItems.STEEL_SICKLE.get(),
                BattleItems.DIAMOND_SICKLE.get(),
                BattleItems.NETHERITE_SICKLE.get(),
                BattleItems.ENDERIUM_SICKLE.get()
        );
        tag(CommunityTags.WEAPONS_CLAW).add(
                BattleItems.WOODEN_CLAW.get(),
                BattleItems.STONE_CLAW.get(),
                BattleItems.GOLDEN_CLAW.get(),
                BattleItems.IRON_CLAW.get(),
                BattleItems.STEEL_CLAW.get(),
                BattleItems.DIAMOND_CLAW.get(),
                BattleItems.NETHERITE_CLAW.get(),
                BattleItems.ENDERIUM_CLAW.get()
        );
        tag(CommunityTags.WEAPONS_CLUB).add(
                BattleItems.WOODEN_CLUB.get(),
                BattleItems.STONE_CLUB.get(),
                BattleItems.GOLDEN_CLUB.get(),
                BattleItems.IRON_CLUB.get(),
                BattleItems.STEEL_CLUB.get(),
                BattleItems.DIAMOND_CLUB.get(),
                BattleItems.NETHERITE_CLUB.get(),
                BattleItems.ENDERIUM_CLUB.get()
        );
        tag(CommunityTags.WEAPONS_GREATCLUB).add(
                BattleItems.WOODEN_GREATCLUB.get(),
                BattleItems.STONE_GREATCLUB.get(),
                BattleItems.GOLDEN_GREATCLUB.get(),
                BattleItems.IRON_GREATCLUB.get(),
                BattleItems.STEEL_GREATCLUB.get(),
                BattleItems.DIAMOND_GREATCLUB.get(),
                BattleItems.NETHERITE_GREATCLUB.get(),
                BattleItems.ENDERIUM_GREATCLUB.get()
        );
        tag(CommunityTags.WEAPONS_HAMMER).add(
                BattleItems.WOODEN_HAMMER.get(),
                BattleItems.STONE_HAMMER.get(),
                BattleItems.GOLDEN_HAMMER.get(),
                BattleItems.IRON_HAMMER.get(),
                BattleItems.STEEL_HAMMER.get(),
                BattleItems.DIAMOND_HAMMER.get(),
                BattleItems.NETHERITE_HAMMER.get(),
                BattleItems.ENDERIUM_HAMMER.get()
        );
        tag(CommunityTags.WEAPONS_WARHAMMER).add(
                BattleItems.WOODEN_WARHAMMER.get(),
                BattleItems.STONE_WARHAMMER.get(),
                BattleItems.GOLDEN_WARHAMMER.get(),
                BattleItems.IRON_WARHAMMER.get(),
                BattleItems.STEEL_WARHAMMER.get(),
                BattleItems.DIAMOND_WARHAMMER.get(),
                BattleItems.NETHERITE_WARHAMMER.get(),
                BattleItems.ENDERIUM_WARHAMMER.get()
        );
        tag(CommunityTags.WEAPONS_MAUL).add(
                BattleItems.WOODEN_MAUL.get(),
                BattleItems.STONE_MAUL.get(),
                BattleItems.GOLDEN_MAUL.get(),
                BattleItems.IRON_MAUL.get(),
                BattleItems.STEEL_MAUL.get(),
                BattleItems.DIAMOND_MAUL.get(),
                BattleItems.NETHERITE_MAUL.get(),
                BattleItems.ENDERIUM_MAUL.get()
        );
        tag(CommunityTags.WEAPONS_ANCHOR).add(
                BattleItems.WOODEN_ANCHOR.get(),
                BattleItems.STONE_ANCHOR.get(),
                BattleItems.GOLDEN_ANCHOR.get(),
                BattleItems.IRON_ANCHOR.get(),
                BattleItems.STEEL_ANCHOR.get(),
                BattleItems.DIAMOND_ANCHOR.get(),
                BattleItems.NETHERITE_ANCHOR.get(),
                BattleItems.ENDERIUM_ANCHOR.get()
        );
        tag(CommunityTags.WEAPONS_WARPICK).add(
                BattleItems.WOODEN_WARPICK.get(),
                BattleItems.STONE_WARPICK.get(),
                BattleItems.GOLDEN_WARPICK.get(),
                BattleItems.IRON_WARPICK.get(),
                BattleItems.STEEL_WARPICK.get(),
                BattleItems.DIAMOND_WARPICK.get(),
                BattleItems.NETHERITE_WARPICK.get(),
                BattleItems.ENDERIUM_WARPICK.get()
        );
        tag(CommunityTags.WEAPONS_BATTLEAXE).add(
                BattleItems.WOODEN_BATTLEAXE.get(),
                BattleItems.STONE_BATTLEAXE.get(),
                BattleItems.GOLDEN_BATTLEAXE.get(),
                BattleItems.IRON_BATTLEAXE.get(),
                BattleItems.STEEL_BATTLEAXE.get(),
                BattleItems.DIAMOND_BATTLEAXE.get(),
                BattleItems.NETHERITE_BATTLEAXE.get(),
                BattleItems.ENDERIUM_BATTLEAXE.get()
        );
        tag(CommunityTags.WEAPONS_GREATAXE).add(
                BattleItems.WOODEN_GREATAXE.get(),
                BattleItems.STONE_GREATAXE.get(),
                BattleItems.GOLDEN_GREATAXE.get(),
                BattleItems.IRON_GREATAXE.get(),
                BattleItems.STEEL_GREATAXE.get(),
                BattleItems.DIAMOND_GREATAXE.get(),
                BattleItems.NETHERITE_GREATAXE.get(),
                BattleItems.ENDERIUM_GREATAXE.get()
        );
        tag(CommunityTags.WEAPONS_HALBERD).add(
                BattleItems.WOODEN_HALBERD.get(),
                BattleItems.STONE_HALBERD.get(),
                BattleItems.GOLDEN_HALBERD.get(),
                BattleItems.IRON_HALBERD.get(),
                BattleItems.STEEL_HALBERD.get(),
                BattleItems.DIAMOND_HALBERD.get(),
                BattleItems.NETHERITE_HALBERD.get(),
                BattleItems.ENDERIUM_HALBERD.get()
        );
        tag(CommunityTags.WEAPONS_SPEAR).add(
                BattleItems.WOODEN_SPEAR.get(),
                BattleItems.STONE_SPEAR.get(),
                BattleItems.GOLDEN_SPEAR.get(),
                BattleItems.IRON_SPEAR.get(),
                BattleItems.STEEL_SPEAR.get(),
                BattleItems.DIAMOND_SPEAR.get(),
                BattleItems.NETHERITE_SPEAR.get(),
                BattleItems.ENDERIUM_SPEAR.get()
        );
        tag(CommunityTags.WEAPONS_PIKE).add(
                BattleItems.WOODEN_PIKE.get(),
                BattleItems.STONE_PIKE.get(),
                BattleItems.GOLDEN_PIKE.get(),
                BattleItems.IRON_PIKE.get(),
                BattleItems.STEEL_PIKE.get(),
                BattleItems.DIAMOND_PIKE.get(),
                BattleItems.NETHERITE_PIKE.get(),
                BattleItems.ENDERIUM_PIKE.get()
        );
        tag(CommunityTags.WEAPONS_QUARTERSTAFF).add(
                BattleItems.WOODEN_QUARTERSTAFF.get(),
                BattleItems.STONE_QUARTERSTAFF.get(),
                BattleItems.GOLDEN_QUARTERSTAFF.get(),
                BattleItems.IRON_QUARTERSTAFF.get(),
                BattleItems.STEEL_QUARTERSTAFF.get(),
                BattleItems.DIAMOND_QUARTERSTAFF.get(),
                BattleItems.NETHERITE_QUARTERSTAFF.get(),
                BattleItems.ENDERIUM_QUARTERSTAFF.get()
        );
        tag(CommunityTags.WEAPONS_GLAIVE).add(
                BattleItems.WOODEN_GLAIVE.get(),
                BattleItems.STONE_GLAIVE.get(),
                BattleItems.GOLDEN_GLAIVE.get(),
                BattleItems.IRON_GLAIVE.get(),
                BattleItems.STEEL_GLAIVE.get(),
                BattleItems.DIAMOND_GLAIVE.get(),
                BattleItems.NETHERITE_GLAIVE.get(),
                BattleItems.ENDERIUM_GLAIVE.get()
        );
        tag(CommunityTags.WEAPONS_PITCHFORK).add(
                BattleItems.WOODEN_PITCHFORK.get(),
                BattleItems.STONE_PITCHFORK.get(),
                BattleItems.GOLDEN_PITCHFORK.get(),
                BattleItems.IRON_PITCHFORK.get(),
                BattleItems.STEEL_PITCHFORK.get(),
                BattleItems.DIAMOND_PITCHFORK.get(),
                BattleItems.NETHERITE_PITCHFORK.get(),
                BattleItems.ENDERIUM_PITCHFORK.get()
        );
        tag(CommunityTags.WEAPONS_SCYTHE).add(
                BattleItems.WOODEN_SCYTHE.get(),
                BattleItems.STONE_SCYTHE.get(),
                BattleItems.GOLDEN_SCYTHE.get(),
                BattleItems.IRON_SCYTHE.get(),
                BattleItems.STEEL_SCYTHE.get(),
                BattleItems.DIAMOND_SCYTHE.get(),
                BattleItems.NETHERITE_SCYTHE.get(),
                BattleItems.ENDERIUM_SCYTHE.get()
        );
        tag(CommunityTags.WEAPONS_JAVELIN).add(
                BattleItems.WOODEN_JAVELIN.get(),
                BattleItems.STONE_JAVELIN.get(),
                BattleItems.GOLDEN_JAVELIN.get(),
                BattleItems.IRON_JAVELIN.get(),
                BattleItems.STEEL_JAVELIN.get(),
                BattleItems.DIAMOND_JAVELIN.get(),
                BattleItems.NETHERITE_JAVELIN.get(),
                BattleItems.ENDERIUM_JAVELIN.get()
        );
        tag(CommunityTags.WEAPONS_BOOMERANG).add(
                BattleItems.WOODEN_BOOMERANG.get(),
                BattleItems.STONE_BOOMERANG.get(),
                BattleItems.GOLDEN_BOOMERANG.get(),
                BattleItems.IRON_BOOMERANG.get(),
                BattleItems.STEEL_BOOMERANG.get(),
                BattleItems.DIAMOND_BOOMERANG.get(),
                BattleItems.NETHERITE_BOOMERANG.get(),
                BattleItems.ENDERIUM_BOOMERANG.get()
        );
        tag(CommunityTags.WEAPONS_KUNAI).add(
                BattleItems.WOODEN_KUNAI.get(),
                BattleItems.STONE_KUNAI.get(),
                BattleItems.GOLDEN_KUNAI.get(),
                BattleItems.IRON_KUNAI.get(),
                BattleItems.STEEL_KUNAI.get(),
                BattleItems.DIAMOND_KUNAI.get(),
                BattleItems.NETHERITE_KUNAI.get(),
                BattleItems.ENDERIUM_KUNAI.get()
        );
        tag(CommunityTags.WEAPONS_THROWING_KNIFE).add(
                BattleItems.WOODEN_THROWING_KNIFE.get(),
                BattleItems.STONE_THROWING_KNIFE.get(),
                BattleItems.GOLDEN_THROWING_KNIFE.get(),
                BattleItems.IRON_THROWING_KNIFE.get(),
                BattleItems.STEEL_THROWING_KNIFE.get(),
                BattleItems.DIAMOND_THROWING_KNIFE.get(),
                BattleItems.NETHERITE_THROWING_KNIFE.get(),
                BattleItems.ENDERIUM_THROWING_KNIFE.get()
        );
        tag(CommunityTags.WEAPONS_TOMAHAWK).add(
                BattleItems.WOODEN_TOMAHAWK.get(),
                BattleItems.STONE_TOMAHAWK.get(),
                BattleItems.GOLDEN_TOMAHAWK.get(),
                BattleItems.IRON_TOMAHAWK.get(),
                BattleItems.STEEL_TOMAHAWK.get(),
                BattleItems.DIAMOND_TOMAHAWK.get(),
                BattleItems.NETHERITE_TOMAHAWK.get(),
                BattleItems.ENDERIUM_TOMAHAWK.get()
        );

    }
}
