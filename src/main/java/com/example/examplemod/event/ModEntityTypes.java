package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ChomperEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MOD_ID);

    // 使用Entity。Builder。of创建一个entity实例，第二个是实体的分类，
    public static final RegistryObject<EntityType<ChomperEntity>> SQUIRREL =
            ENTITY_TYPES.register("squirrel",
                    () -> EntityType.Builder.of(ChomperEntity::new, MobCategory.MONSTER)
                            .sized(0.4f,0.4f) //生成的大小width height
                            .build(new ResourceLocation(ExampleMod.MOD_ID,"squirrel").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}