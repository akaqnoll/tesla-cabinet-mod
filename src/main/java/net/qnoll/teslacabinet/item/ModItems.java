package net.qnoll.teslacabinet.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.qnoll.teslacabinet.TeslaCabinet;
import net.qnoll.teslacabinet.block.ModBlocks;
import net.qnoll.teslacabinet.item.custom.CanaryDustBlockItem;
import net.qnoll.teslacabinet.item.custom.CanaryDustItem;
import net.qnoll.teslacabinet.item.custom.TangoItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TeslaCabinet.MOD_ID);

    public static final RegistryObject<Item> CANARY_DUST = ITEMS.register("canary_dust",
            ()-> new CanaryDustItem(new Item.Properties()));
    public static final RegistryObject<Item> TANGO = ITEMS.register("tango",
            () -> new TangoItem(new Item.Properties()));

    public static final RegistryObject<Item> CANARY_DUST_BLOCK_ITEM = ITEMS.register("canary_dust_block",
            () -> new CanaryDustBlockItem(ModBlocks.CANARY_DUST_BLOCK.get(),new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
