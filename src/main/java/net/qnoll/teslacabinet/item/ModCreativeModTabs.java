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

                        //mod items order:
                        output.accept(ModItems.PLACEHOLDER.get());
                        output.accept(ModBlocks.TEST_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
