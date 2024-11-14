package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ChomperEntity;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID)
    private static class ForgeEvents {
        // 村民交易事件


        @Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ModEventBusEvents {
            // 给实体注册实体的属性
            @SubscribeEvent
            public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
                event.put(ModEntityTypes.SQUIRREL.get(), ChomperEntity.setAttributes());
            }
        }
    }

}
