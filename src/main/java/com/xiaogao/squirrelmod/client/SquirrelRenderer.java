package com.xiaogao.squirrelmod.client;

import com.xiaogao.squirrelmod.SquirrelMod;
import com.xiaogao.squirrelmod.entity.custom.SquirrelEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;


public class SquirrelRenderer extends GeoEntityRenderer<SquirrelEntity> {
    public SquirrelRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SqueirrelModel());
        this.shadowRadius = 0.3f;
    }
    // 调整影子的半径
    @Override
    public ResourceLocation getTextureLocation(SquirrelEntity instance) {
        return new ResourceLocation(SquirrelMod.MOD_ID, "textures/entity/chomper_texture.png");
    }

    @Override
    public RenderType getRenderType(SquirrelEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        // 缩放大小
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);

    }
}