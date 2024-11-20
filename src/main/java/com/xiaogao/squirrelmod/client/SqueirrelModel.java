package com.xiaogao.squirrelmod.client;

import com.xiaogao.squirrelmod.SquirrelMod;
import com.xiaogao.squirrelmod.entity.custom.SquirrelEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SqueirrelModel extends AnimatedGeoModel<SquirrelEntity> {
    @Override
    public ResourceLocation getModelResource(SquirrelEntity object) {
        return new ResourceLocation(SquirrelMod.MOD_ID, "geo/chomper.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SquirrelEntity object) {
        return new ResourceLocation(SquirrelMod.MOD_ID, "textures/entity/chomper_texture.png");
    }


    @Override
    public ResourceLocation getAnimationResource(SquirrelEntity animatable) {
        return new ResourceLocation(SquirrelMod.MOD_ID,"animations/animation.chomper.walk.json");
    }



}
