package net.teamarcana.battlements.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.init.BattleTags;

import java.util.concurrent.CompletableFuture;

public class BattleEnchantmentTagProvider extends EnchantmentTagsProvider {
    public BattleEnchantmentTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    public static ResourceLocation FROSTBITE = ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "frostbite");
    public static ResourceLocation LEECHING = ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "life_steal");
    public static ResourceLocation BLUNTNESS = ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "bluntness");

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(EnchantmentTags.NON_TREASURE).addOptional(FROSTBITE).addOptional(LEECHING).addOptional(BLUNTNESS);
        tag(BattleTags.Enchantments.EXCLUSIVE_ELEMENTAL).add(Enchantments.FIRE_ASPECT).addOptional(FROSTBITE);
    }
}
