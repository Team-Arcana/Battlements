package net.teamarcana.battlements.api.trait;

import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.ToolAction;
import net.minecraft.network.chat.Component;
import net.teamarcana.battlements.api.trait.callback.IActionCallback;
import net.teamarcana.battlements.api.trait.callback.IMeleeCallback;
import net.teamarcana.battlements.api.trait.callback.IRangedCallback;
import net.teamarcana.battlements.api.trait.callback.IThrowingCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * The Base weapon trait class. Extend this to make your own trait
 */
public class Trait {
    protected final String type;
    protected final String modId;
    protected final String quality;
    protected int level = 0;
    protected float magnitude = 0.0f;
    protected boolean isMelee = false, isRanged = false, isThrowing = false, isAction = false;
    protected ChatFormatting qualityFormat;
    protected MutableComponent types;

    public static final ChatFormatting[] FORMAT_DESCRIPTION = {ChatFormatting.GRAY, ChatFormatting.ITALIC};

    /**
     * The constructor for the Trait
     * @param type the name of the trait
     * @param modId the mod ID that the trait is registered from
     * @param quality the trait's quality. Can be "positive", "neutral", or "negative"
     */
    public Trait(String type, String modId, String quality){
        this.type = type; this.modId = modId; this.quality = quality;
        if(quality.equals("positive")){ qualityFormat = ChatFormatting.GREEN; }
        else if(quality.equals("negative")){ qualityFormat = ChatFormatting.RED; }
        else{ qualityFormat = ChatFormatting.YELLOW; }
    }

    public Trait setLevel(int level){ this.level = level; return this; }
    public int getLevel() { return level; }

    public Trait setMagnitude(float magnitude){ this.magnitude = magnitude; return this; }
    public float getMagnitude() { return magnitude; }

    public Trait setMelee(){ this.isMelee = true; return this; }
    public boolean isMelee() { return isMelee; }


    public Trait setRanged(){ this.isRanged = true; return this; }
    public boolean isRanged() { return isRanged; }


    public Trait setThrowing(){ this.isThrowing = true; return this; }
    public boolean isThrowing() { return isThrowing; }


    public Trait setAction(){ this.isAction = true; return this; }
    public boolean isAction() { return isAction; }

    public Trait setUniversal(){ setMelee(); setRanged(); setThrowing(); setAction(); return this; }
    public boolean isUniversal(){return isMelee && isRanged && isThrowing && isAction ;}

    public String getType() { return type; }

    // other methods
    public boolean isCompatibleWithEnchantment(Enchantment enchantment){ return false; }
    public boolean isIncompatibleWithEnchantment(Enchantment enchantment){ return false; }
    public boolean canPerformToolAction(ToolAction action){ return false; }

    // adds the description and such
    public final void addTooltip(ItemStack item, List<Component> tooltip, boolean isShiftPressed){
        // the title
        tooltip.add(addTooltipTitle());
        // The Description
        if(isShiftPressed && I18n.exists(String.format("tooltip.%s.weapontrait.%s.desc", modId, type))){
            if(types == null){

                // setting up
                List<MutableComponent> typeList = new ArrayList<>();
                if(isAction)
                    typeList.add(Component.translatable("tooltip.battlements.trait.type.action"));
                if(isMelee)
                    typeList.add(Component.translatable("tooltip.battlements.trait.type.melee"));
                if(isRanged)
                    typeList.add(Component.translatable("tooltip.battlements.trait.type.ranged"));
                if(isThrowing)
                    typeList.add(Component.translatable("tooltip.battlements.trait.type.throwing"));

                types = Component.literal("  [").append(ComponentUtils.formatList(typeList, Component.literal(", "), Function.identity())).append(Component.literal("]")).withStyle(ChatFormatting.ITALIC, ChatFormatting.DARK_GRAY);

            } else{
                tooltip.add(types);
            }
            addTooltipDescription(item, tooltip);
        }
    }

    public MutableComponent addTooltipTitle(){
        MutableComponent title = Component.literal("- ").withStyle(qualityFormat);
        if(level == 0){ title.append(Component.translatable(String.format("tooltip.%s.weapontrait.%s"), modId, type)); }
        else { title.append(Component.translatable(String.format("tooltip.%s.weapontrait.%s"), modId, type)
                .append(Component.literal(" ")).append(Component.translatable(String.format("enchantment.level.%s", Integer.toString(level))))); }
        return title;
    }
    public void addTooltipDescription(ItemStack item, List<Component> tooltip){
        tooltip.add(Component.literal("  ").append(Component.translatable(String.format("tooltip.%s.trait.%s.desc", modId, type)).withStyle(FORMAT_DESCRIPTION)));
    }

    // stuff for callbacks
    public Optional<IMeleeCallback> getMeleeCallback(){ return Optional.empty(); }
    public Optional<IRangedCallback> getRangedCallback(){ return Optional.empty(); }
    public Optional<IThrowingCallback> getThrowingCallback(){ return Optional.empty(); }
    public Optional<IActionCallback> getActionCallback(){ return Optional.empty(); }
}
