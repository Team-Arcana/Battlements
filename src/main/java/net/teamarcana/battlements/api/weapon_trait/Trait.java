package net.teamarcana.battlements.api.weapon_trait;

import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.ToolAction;
import net.minecraft.network.chat.Component;
import net.teamarcana.battlements.api.weapon_trait.callback.IActionCallback;
import net.teamarcana.battlements.api.weapon_trait.callback.IMeleeCallback;
import net.teamarcana.battlements.api.weapon_trait.callback.IThrowingCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * The Base weapon trait class. Extend this to make your own trait
 */
public class Trait {
    protected String type;
    protected String modId;
    protected Quality quality;
    protected int level = 0;
    protected float weight = 0.0f;
    protected boolean isMelee = false, isThrowing = false, isAction = false;

    public static final ChatFormatting[] FORMAT_DESCRIPTION = {ChatFormatting.GRAY, ChatFormatting.ITALIC};
    protected MutableComponent types;

    public Trait(String type, String modId, Quality quality){
        this.type = type; this.modId = modId; this.quality = quality;
    }

    /**
     * Trait qualities
     */
    public enum Quality{
        GOOD(ChatFormatting.GREEN),
        NEUTRAL(ChatFormatting.YELLOW),
        BAD(ChatFormatting.RED);

        private ChatFormatting format;
        private Quality(ChatFormatting format){ this.format = format; }
        public ChatFormatting getFormat(){ return format; }
    }

    // setters and getters
    public String getType() { return type; }

    public Trait setLevel(int level){
        this.level = level;
        return this;
    }
    public int getLevel(){ return level; }

    public Quality getQuality(){ return quality; }

    public Trait setWeight(float weight){
        this.weight = weight;
        return this;
    }
    public float getWeight(){ return weight; }

    public Trait setMelee(boolean melee){
        this.isMelee = melee;
        return this;
    }
    public boolean isMelee(){ return isMelee; }
    public Trait setThrowing(boolean throwing){
        this.isThrowing = throwing;
        return this;
    }
    public boolean isThrowing(){ return isThrowing; }
    public Trait setAction(boolean action){
        this.isAction = action;
        return this;
    }
    public boolean isAction(){ return isAction; }

    public Trait setUniversal(boolean bool){
        this.isMelee = bool; this.isThrowing = bool; this.isAction = bool;
        return this;
    }
    public boolean isUniversal(){ return isMelee && isThrowing && isAction; }

    // other methods
    public boolean isCompatibleWithEnchantment(Enchantment enchantment){ return false; }
    public boolean isIncompatibleWithEnchantment(Enchantment enchantment){ return false; }
    public boolean canPerformToolAction(ToolAction action){ return false; }

    // adds the description and such
    public final void addTooltip(ItemStack item, List<Component> tooltip, boolean isShiftPressed){
        // the title
        MutableComponent title = Component.literal("- ").withStyle(quality.getFormat());
        if(level == 0){ tooltip.add(title.append(Component.translatable(String.format("tooltip.%s.weapontrait.%s"), modId, type))); }
        else { tooltip.add(title.append(Component.translatable(String.format("tooltip.%s.weapontrait.%s"), modId, type))
                .append(Component.literal(" ")).append(Component.translatable(String.format("enchantment.level.%s", Integer.toString(level))))); }

        // The Description
        if(isShiftPressed && I18n.exists(String.format("tooltip.%s.weapontrait.%s.desc"))){
            if(types == null){

                // setting up
                List<MutableComponent> typeList = new ArrayList<>();
                if(isAction)
                    typeList.add(Component.translatable(String.format("tooltip.%s.trait.type.action", modId)));
                if(isMelee)
                    typeList.add(Component.translatable(String.format("tooltip.%s.trait.type.melee", modId)));
                if(isThrowing)
                    typeList.add(Component.translatable(String.format("tooltip.%s.trait.type.throwing", modId)));

                types = Component.literal("  [").append(ComponentUtils.formatList(typeList, Component.literal(", "), Function.identity())).append(Component.literal("]")).withStyle(ChatFormatting.ITALIC, ChatFormatting.DARK_GRAY);

            } else{
                tooltip.add(types);
            }
            tooltip.add(Component.literal("  ").append(Component.translatable(String.format("tooltip.%s.trait.%s.desc", modId, type)).withStyle(FORMAT_DESCRIPTION)));
        }
    }

    // stuff for callbacks
    public Optional<IMeleeCallback> getMeleeCallback(){ return Optional.empty(); }
    public Optional<IThrowingCallback> getThrowingCallback(){ return Optional.empty(); }
    public Optional<IActionCallback> getActionCallback(){ return Optional.empty(); }
}
