package net.qnoll.teslacabinet.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.qnoll.teslacabinet.TeslaCabinet;
import net.qnoll.teslacabinet.block.custom.ShelfIndentedBlock;
import net.qnoll.teslacabinet.block.custom.ThermocoupleBlock;
import net.qnoll.teslacabinet.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, TeslaCabinet.MOD_ID);

    //blocks start

    //x-meters (with arrow)
    public static final RegistryObject<Block> THERMOCOUPLE = registerBlock("thermocouple",
            () -> new ThermocoupleBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    //shelves
    public static final RegistryObject<Block> SPRUCE_SHELF_INDENTED = registerBlock("spruce_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));

    //blocks end

    //helper methods
    private static <T extends Block> RegistryObject<T> registerBlock (String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
