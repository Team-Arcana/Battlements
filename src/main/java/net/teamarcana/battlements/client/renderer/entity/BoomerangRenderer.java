package net.teamarcana.battlements.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.teamarcana.battlements.entity.AbstractThrownWeapon;
import org.joml.Vector3f;

public class BoomerangRenderer<T extends AbstractThrownWeapon> extends ThrownWeaponRenderer<T>{
    public BoomerangRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void transform(T entity, float partialTick, PoseStack pose) {
        float boomerangRotation = entity.getAirTicks() != 0 && (!entity.isUnderWater()) ? (entity.getAirTicks() + partialTick)*40%360: 0;
        if(entity.getAirTicks() != 0){ entity.setNoGravity(true); }
        float tick = boomerangRotation == 0 ? 0 : partialTick;

        pose.scale(2, 2, 2);
        pose.mulPose(Axis.YP.rotationDegrees(Mth.lerp(tick, entity.yRotO, entity.getYRot()) - 90));
        pose.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(tick, entity.xRotO, entity.getXRot()) - 135));

        Axis rot = Axis.of(new Vector3f(1, 1, 0).normalize());
        pose.mulPose(rot.rotationDegrees(180));

        rot = Axis.of(new Vector3f(1, -1, 0).normalize());
        pose.mulPose(rot.rotationDegrees(90));

        pose.mulPose(Axis.ZP.rotationDegrees(boomerangRotation));
        pose.translate(0.075f, 0.25f, 0);
    }
}
