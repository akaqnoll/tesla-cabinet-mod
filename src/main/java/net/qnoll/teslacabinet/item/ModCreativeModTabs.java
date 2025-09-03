package net.qnoll.teslacabinet.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.qnoll.teslacabinet.TeslaCabinet;
import net.qnoll.teslacabinet.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TeslaCabinet.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TESLACABINET_TAB = CREATIVE_MODE_TABS.register("teslacabinet_tab",
            () -> CreativeModeTab.builder()
                    //an icon for the creative tab (ITEM)
                    .icon(() -> new ItemStack(ModItems.PLACEHOLDER.get()))
                    .title(Component.translatable("creativetab.teslacabinet_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //### BLOCKS:
                        //x-meters (with arrow)
                        output.accept(ModBlocks.THERMOCOUPLE.get());
                        //Shelves:
                        output.accept(ModBlocks.ACACIA_SHELF_INDENTED.get());
                        output.accept(ModBlocks.BAMBOO_SHELF_INDENTED.get());
                        output.accept(ModBlocks.BIRCH_SHELF_INDENTED.get());
                        output.accept(ModBlocks.CHERRY_SHELF_INDENTED.get());
                        output.accept(ModBlocks.CRIMSON_SHELF_INDENTED.get());
                        output.accept(ModBlocks.DARK_OAK_SHELF_INDENTED.get());
                        output.accept(ModBlocks.JUNGLE_SHELF_INDENTED.get());
                        output.accept(ModBlocks.MANGROVE_SHELF_INDENTED.get());
                        output.accept(ModBlocks.OAK_SHELF_INDENTED.get());
                        output.accept(ModBlocks.SPRUCE_SHELF_INDENTED.get());
                        output.accept(ModBlocks.WARPED_SHELF_INDENTED.get());

                        //### ITEMS:
                        output.accept(ModItems.PLACEHOLDER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
