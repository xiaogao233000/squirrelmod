package com.xiaogao.squirrelmod.Item;

import com.xiaogao.squirrelmod.SquirrelMod;
import com.xiaogao.squirrelmod.event.ModEntityTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SquirrelMod.MOD_ID);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> CHOMPER_SPAWN_EGG = ITEMS.register("squirrel_spawn_egg",
            ()->new ForgeSpawnEggItem(ModEntityTypes.SQUIRREL,0x9c7435,0x7e5411,// 背景色和亮色
                    new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

}
