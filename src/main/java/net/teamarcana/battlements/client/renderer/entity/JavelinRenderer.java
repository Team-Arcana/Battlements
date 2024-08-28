package net.teamarcana.battlements.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.teamarcana.battlements.entity.AbstractThrownWeapon;

public class JavelinRenderer<T extends AbstractThrownWeapon> extends ThrownWeaponRenderer<T>{
    public JavelinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void transform(T entity, float partialTick, PoseStack pose) {
        pose.scale(1.5f, 1.5f, 1.5f);
        pose.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, entity.yRotO, entity.getYRot()) - 90));
        pose.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTick, entity.xRotO, entity.getXRot()) - 45));
        pose.translate(-0.45f, -0.35f, 0.0f);
    }
}
