package net.teamarcana.battlements.util;

import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.teamarcana.battlements.Battlements;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TooltipUtil {
    private static final Style ICON = Style.EMPTY.withFont(Battlements.FONT_ICONS);
    private static final Style DEFAULT = Style.EMPTY.withFont(Style.DEFAULT_FONT);

    public static final int ICON_SPACE = 1;
    public static final DecimalFormat tenths = new DecimalFormat("#.##");
    private static final DecimalFormat hundredFormat = new DecimalFormat("###");

    // icons
    public static MutableComponent addIconWithSpacing(String name, int i){
        return addIcon(name).append(spacing(i));
    }

    public static MutableComponent addIcon(String name){
        return I18n.exists(String.format("battlements.icon.%s", name)) ?
                Component.translatable(String.format("battlements.icon.%s", name)).withStyle(ICON) :
                Component.empty();
    }

    public static MutableComponent spacing(int i){
        MutableComponent space = Component.empty();
        for(int j = 0; j < i; j++){
            space.append(" ").withStyle(DEFAULT);
        }
        return space;
    }

    // todo: edit this but make a mixin
    // make the item tooltips use the icons
    public static void itemAttributeTooltip(ItemStack item, Player player, List<Component> tooltip, boolean isShiftPressed){
        Consumer<Component> consumer = tooltip::add;
        EquipmentSlot slot = player.getEquipmentSlotForItem(item);
        MutableComponent whenIn = Component.translatable(String.format("item.modifiers.%s", slot.getName()));
        Multimap<Holder<Attribute>, AttributeModifier> attributes = item.getAttributeModifiers(slot);
        MutableComponent durabilityComponent = Component.empty();

        if(item.getAttributeModifiers(slot).isEmpty() || item.getAttributeModifiers(slot) == null){
            return;
        }

        // getting the enchantments
        List<Component> enchantments = List.of();
        for(int i = 0; i < tooltip.size(); i++){
            MutableComponent component = tooltip.get(i).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
            String s = component.getVisualOrderText().toString();
            String string = component.toString();
            if(string.contains("key='enchantment")){
                //enchantments.add(mutableComponent.withStyle(ChatFormatting.LIGHT_PURPLE));
            }
        }

        tooltip.forEach(component -> {
            String string = component.toString();
            if(string.contains("key='enchantment") || string.contains("key='attribute") || string.contains("key='attribute.modifier")){
                tooltip.remove(component);
            }
        });

        // thing to mention holding for the full stat details
        MutableComponent holdForDetails = Component.translatable("tooltip.battlements.hold_for_details1").withStyle(ChatFormatting.BLUE)
                .append(Component.literal("SHIFT").withStyle(ChatFormatting.GOLD))
                .append(Component.translatable("tooltip.battlements.hold_for_details2").withStyle(ChatFormatting.BLUE));

        // Durability
        if(item.isDamageableItem()){
            int currDurability = item.getMaxDamage() - item.getDamageValue();
            double durabilityPercentage = (double) currDurability / (double) item.getMaxDamage();
            Color durabilityTooltipColor = new Color((int) (128 + (128 * 0.5 * (1.0 - durabilityPercentage))), (int) (255 * durabilityPercentage), 0);
            if(isShiftPressed){ durabilityComponent.append(Component.translatable("tooltip.battlements.durability")).append(Component.literal(String.valueOf(currDurability)).withStyle(ChatFormatting.GREEN).append(Component.literal("/").withStyle(Style.EMPTY).withColor(0xFFFFFF)).append(Component.literal(String.valueOf(item.getMaxDamage())).withStyle(ChatFormatting.GRAY)));}
            else{ durabilityComponent.append(spacing(1)).append(addIconWithSpacing("durability", 1).withStyle(ICON).withColor(0xFFFFFF)).append(Component.literal(String.valueOf(durabilityPercentage * 100) + "%")).withColor(durabilityTooltipColor.getRGB()); }
        }

        // getting the other attributes
        for(Map.Entry<Holder<Attribute>, AttributeModifier> entry : attributes.entries()){
            Attribute attribute = entry.getKey().value();
            AttributeModifier modifier = entry.getValue();
            AttributeModifier.Operation modifierOperation = modifier.operation();
            String name = attribute.getDescriptionId();
            MutableComponent component = Component.empty().withStyle(Style.EMPTY);
            if(modifier.amount() == 0){ continue; }
            component.append(addAttributeToTooltip(item, player, attribute, modifier, modifierOperation, name, isShiftPressed));
            tooltip.add(component);
        }
        if(!enchantments.isEmpty()){
            tooltip.add(Component.translatable("tooltip.battlements.enchantments").withStyle(ChatFormatting.GRAY));
            tooltip.addAll(enchantments);
        }
        tooltip.add(durabilityComponent);
        if(!isShiftPressed){
            tooltip.add(holdForDetails);
        }
    }

    public static MutableComponent addAttributeToTooltip(ItemStack item, Player player, Attribute attribute, AttributeModifier modifier, AttributeModifier.Operation operation, String name, boolean isShiftPressed){
        MutableComponent attributeTooltip = Component.empty();
        // the name
        if(!isShiftPressed){
            attributeTooltip.append(spacing(1)).append(addIcon(name));
        }

        // adding attack damage and speed
        if(modifier.is(Item.BASE_ATTACK_DAMAGE_ID)){
            attributeTooltip.append(spacing(1)).append(addTooltipNumber(player.getAttributeBaseValue(Attributes.ATTACK_DAMAGE) + modifier.amount(), 5592575));
        } else if(modifier.is(Item.BASE_ATTACK_SPEED_ID)){
            attributeTooltip.append(spacing(1)).append(addTooltipNumber(player.getAttributeBaseValue(Attributes.ATTACK_SPEED) + modifier.amount(), 5592575));
        }

        // anything else
        else{
            attributeTooltip.append(spacing(1)).append(addTooltipNumber(modifier.amount(), 5592575));
        }
        if(isShiftPressed){
            attributeTooltip.append(Component.translatable(name).withStyle(ChatFormatting.GRAY));
        }
        return attributeTooltip;
    }

    public static MutableComponent addTooltipNumber(double number, int color){
        MutableComponent component = Component.empty().withStyle(DEFAULT);
        String num = tenths.format(number);
        if(num.charAt(0) == '1'){ component.append(spacing(-1)); }
        for(int i = 0; i < num.length() ; i++) {
            component.append(String.valueOf(num.charAt(i)));
            if (i != num.length()-1) {
                if (num.charAt(i+1) == '.') {
                    component.append(spacing(-2));
                } else if (num.charAt(i+1) == '1') {
                    component.append(spacing(-1));
                }
                component.append(spacing(-1));
            }
        }
        component.append(spacing(1));
        return (number < 0 ? component.withStyle(ChatFormatting.RED) : component.withColor(color));
    }


    public static MutableComponent addAttribute(Attribute attribute, AttributeModifier modifier, AttributeModifier.Operation operation, String name, boolean isShiftPressed){
        MutableComponent c = Component.empty();
        // give full details if shift is pressed
        if(isShiftPressed){
            c.append(spacing(1)).append(Component.translatable(name)).append(Component.literal(": ")).withStyle(DEFAULT);
        }else{
            c.append(addIcon(name));
        }
        if(operation == AttributeModifier.Operation.ADD_VALUE){
            if(modifier.amount() > 0){
                c.append(Component.literal("+ ").withStyle(ChatFormatting.GREEN).append(Component.literal(String.valueOf(modifier.amount()))).withStyle(DEFAULT).withStyle(ChatFormatting.BLUE));
            } else {
                c.append(Component.literal("- ").withStyle(ChatFormatting.RED).append(Component.literal(String.valueOf(modifier.amount()))).withStyle(DEFAULT).withStyle(ChatFormatting.BLUE));
            }
        } else if (operation == AttributeModifier.Operation.ADD_MULTIPLIED_BASE || operation == AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL) {
            c.append(Component.literal("x ").withStyle(DEFAULT).withStyle(ChatFormatting.BLUE));
            if(modifier.amount() > 0){
                c.append(Component.literal(String.valueOf(modifier.amount()))).withStyle(DEFAULT).withStyle(ChatFormatting.BLUE);
            } else {
                c.append(Component.literal("- ").append(Component.literal(String.valueOf(modifier.amount())))).withStyle(DEFAULT).withStyle(ChatFormatting.RED);
            }
        }
        else{
            c.append(Component.literal(String.valueOf(modifier.amount()))).withStyle(ChatFormatting.BLUE);
        }
        return c;
    }
}
