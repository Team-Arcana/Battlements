package net.teamarcana.battlements.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.teamarcana.battlements.entity.AbstractThrownWeapon;

public class ThrownWeaponRenderer<T extends AbstractThrownWeapon> extends EntityRenderer<T> {
    protected final ItemRenderer renderer;

    public ThrownWeaponRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.renderer = Minecraft.getInstance().getItemRenderer();
    }

    @Override
    public void render(T entity, float entityYaw, float partialTick, PoseStack pose, MultiBufferSource buffer, int light) {
        pose.pushPose();

        transform(entity, partialTick, pose);
        pose.translate(0.10d, -0.20d, 0.0d);
        ItemStack item = entity.getWeapon();
        if(item != null && !item.isEmpty()){
            BakedModel model = this.renderer.getModel(item, entity.level(), (LivingEntity)null, entity.getId());
            this.renderer.render(item, ItemDisplayContext.GROUND, false, pose, buffer, light, OverlayTexture.NO_OVERLAY, model);
        }
        pose.popPose();
        super.render(entity, entityYaw, partialTick, pose, buffer, light);
    }
    public void transform(T entity, float partialTick, PoseStack pose){
        pose.scale(2, 2, 2);
        pose.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, entity.yRotO, entity.getYRot() - 90)));
        pose.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTick, entity.xRotO, entity.getXRot())));
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
