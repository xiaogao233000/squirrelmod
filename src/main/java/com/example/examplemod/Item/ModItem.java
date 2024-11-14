package com.example.examplemod.Item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.event.ModEntityTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    // 创建一个注册表，类型为Item表示物品，MOD_ID表示我们的mod的名称。
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);
    // 创建了一个物品，使用注册表对该物品进行注册，注册的name为zircon,使用lambda返回一个新的Item对象
    // 这个物品的tab可以使用游戏中的tab，也可以自己创建，并注册。
    // 将注册表加入到Forge总线上，只有这样才能把物品加入到游戏中，被TutorialMod进行调用。
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> CHOMPER_SPAWN_EGG = ITEMS.register("squirrel_spawn_egg",
            ()->new ForgeSpawnEggItem(ModEntityTypes.SQUIRREL,0x9c7435,0x7e5411,// 背景色和亮色
                    new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

}