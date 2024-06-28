package net.teamarcana.battlements.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.trait.Trait;
import net.teamarcana.battlements.init.BattleTags;
import net.teamarcana.battlements.init.BattleTraits;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TraitTagProvider extends IntrinsicHolderTagsProvider<Trait> {
    public TraitTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, Battlements.TRAIT_REGISTRY_KEY, pLookupProvider,
                (trait) -> Battlements.TRAIT_REGISTRY.getResourceKey(trait).orElseThrow()
                , modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //tag(BattleTags.Traits.DAGGER).add();
        //tag(BattleTags.Traits.LONGSWORD).add();
        //tag(BattleTags.Traits.GREATSWORD).add();
        tag(BattleTags.Traits.KATANA).add(BattleTraits.PARRYING.get());
        tag(BattleTags.Traits.RAPIER).add(BattleTraits.PARRYING.get());
        //tag(BattleTags.Traits.SABER).add();
        //tag(BattleTags.Traits.CUTLASS).add();
        tag(BattleTags.Traits.SICKLE).add(BattleTraits.VERSATILE_HOE.get());
        tag(BattleTags.Traits.CLAW).add(BattleTraits.VERSATILE_SHOVEL.get());
        //tag(BattleTags.Traits.CLUB).add();
        tag(BattleTags.Traits.GREATCLUB).add(BattleTraits.PARRYING.get());
        //tag(BattleTags.Traits.HAMMER).add();
        //tag(BattleTags.Traits.WARHAMMER).add();
        tag(BattleTags.Traits.MAUL).add(BattleTraits.PARRYING.get());
        //tag(BattleTags.Traits.ANCHOR).add();
        tag(BattleTags.Traits.WARPICK).add(BattleTraits.VERSATILE_PICKAXE.get());
        tag(BattleTags.Traits.BATTLEAXE).add(BattleTraits.VERSATILE_AXE.get());
        tag(BattleTags.Traits.GREATAXE).add(BattleTraits.VERSATILE_AXE.get());
        //tag(BattleTags.Traits.HALBERD).add();
        //tag(BattleTags.Traits.SPEAR).add();
        tag(BattleTags.Traits.PIKE).add(BattleTraits.PARRYING.get());
        tag(BattleTags.Traits.QUARTERSTAFF).add(BattleTraits.PARRYING.get());
        //tag(BattleTags.Traits.PITCHFORK).add();
        tag(BattleTags.Traits.GLAIVE).add(BattleTraits.PARRYING.get());
        //tag(BattleTags.Traits.SCYTHE).add();
        tag(BattleTags.Traits.JAVELIN).add(BattleTraits.THROWABLE.get());
        tag(BattleTags.Traits.BOOMERANG).add(BattleTraits.THROWABLE.get());
        tag(BattleTags.Traits.KUNAI).add(BattleTraits.THROWABLE.get());
        tag(BattleTags.Traits.TOMAHAWK).add(BattleTraits.THROWABLE.get());
        tag(BattleTags.Traits.THROWING_KNIFE).add(BattleTraits.THROWABLE.get());
    }
}
