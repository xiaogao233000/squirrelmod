package com.xiaogao.squirrelmod.event;

import com.xiaogao.squirrelmod.SquirrelMod;
import com.xiaogao.squirrelmod.entity.custom.SquirrelEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = SquirrelMod.MOD_ID)
    private static class ForgeEvents {



        @Mod.EventBusSubscriber(modid = SquirrelMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ModEventBusEvents {


            @SubscribeEvent
            public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
                event.put(ModEntityTypes.SQUIRREL.get(), SquirrelEntity.setAttributes());
            }

        }
    }

}
