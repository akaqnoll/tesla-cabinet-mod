package net.qnoll.teslacabinet.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.qnoll.teslacabinet.TeslaCabinet;
import net.qnoll.teslacabinet.item.custom.CanaryDustItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TeslaCabinet.MOD_ID);

    public static final RegistryObject<Item> CANARY_DUST = ITEMS.register("canary_dust",
            ()-> new CanaryDustItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
