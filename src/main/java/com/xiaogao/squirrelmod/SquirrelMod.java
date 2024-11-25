package com.xiaogao.squirrelmod;

import com.xiaogao.squirrelmod.Item.ModItem;
import com.xiaogao.squirrelmod.client.SquirrelRenderer;
import com.xiaogao.squirrelmod.event.ModEntityTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SquirrelMod.MOD_ID)
public class SquirrelMod
{
    public static final String MOD_ID = "squirrelmod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public SquirrelMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ModItem.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        GeckoLib.initialize();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

        event.enqueueWork(() -> {
            //生物1的生成规则
            SpawnPlacements.register(ModEntityTypes.SQUIRREL.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMobSpawnRules);
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntityTypes.SQUIRREL.get(), SquirrelRenderer::new);


        }


    }
}