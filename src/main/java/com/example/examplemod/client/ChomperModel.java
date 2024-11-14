package com.example.examplemod.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ChomperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChomperModel extends AnimatedGeoModel<ChomperEntity> {
    @Override
    public ResourceLocation getModelResource(ChomperEntity object) {
        return new ResourceLocation(ExampleMod.MOD_ID, "geo/chomper.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChomperEntity object) {
        return new ResourceLocation(ExampleMod.MOD_ID, "textures/entity/chomper_texture.png");
    }


    @Override
    public ResourceLocation getAnimationResource(ChomperEntity animatable) {
        return new ResourceLocation(ExampleMod.MOD_ID,"animations/animation.chomper.walk.json");
    }



}
