package net.teamarcana.battlements.api.trait;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class VersatileTrait extends Trait{
    private final TagKey<Block> effectiveBlocks;
    private final String toolName;

    /**
     * The constructor for the Trait
     *
     * @param type    the name of the trait
     * @param modId   the mod ID that the trait is registered from
     * @param effectiveBlocks the block tag that this trait makes the weapon effective for
     * @param toolName the name of the tool
     */
    public VersatileTrait(String type, String modId, TagKey<Block> effectiveBlocks, String toolName) {
        super(type, modId, "positive");
        this.effectiveBlocks = effectiveBlocks;
        this.toolName = toolName;
    }

    public TagKey<Block> getEffectiveBlocks() { return effectiveBlocks; }

    @Override
    public MutableComponent addTooltipTitle() {
        MutableComponent title = Component.literal("- ").withStyle(qualityFormat);
        String type = effectiveBlocks != null && toolName != null && !toolName.isEmpty() ?
                String.format("tooltip.%s.trait.versatile_%s", modId, toolName)
                : String.format("tooltip.%s.trait.versatile_none", modId);
        return title.append(Component.translatable(type));
    }
}
