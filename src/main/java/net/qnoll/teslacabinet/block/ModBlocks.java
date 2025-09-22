package net.qnoll.teslacabinet.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.qnoll.teslacabinet.TeslaCabinet;
import net.qnoll.teslacabinet.block.custom.*;
import net.qnoll.teslacabinet.item.ModItems;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, TeslaCabinet.MOD_ID);

    //blocks start

    //chemistry
    public static final RegistryObject<Block> ALEMBIC_COPPER = registerBlock("alembic_copper",
            () -> new AlembicCopperBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).noOcclusion()));

    //misc
    public static final RegistryObject<Block> STATIC_ELECTRICITY_DOME = registerBlock("static_electricity_dome",
            () -> new StaticElectricityDomeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> SCALES = registerBlock("scales",
            () -> new ScalesBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> WEIGHT_IRON = registerBlock("weight_iron",
            () -> new WeightsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> WEIGHT_GOLD = registerBlock("weight_gold",
            () -> new WeightsBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));

    //phonographs
    public static final RegistryObject<Block> PHONOGRAPH_EDISON = registerBlock("phonograph_edison",
            () -> new PhonographEdisonBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));

    //microscopes
    public static final RegistryObject<Block> MICROSCOPE_SINGLE = registerBlock("microscope_single",
            () -> new MicroscopeSingleBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> MICROSCOPE_BRASS = registerBlock("microscope_brass",
            () -> new MicroscopeBrassBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));

    //x-meters (with arrow)
    public static final RegistryObject<Block> THERMOCOUPLE = registerBlock("thermocouple",
            () -> new ThermocoupleBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> ORANGE_MULTIMETER = registerBlock("orange_multimeter",
            () -> new OrangeMultimneterBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    //decorative blocks:
    //misc
    public static final RegistryObject<Block> TUNGSTEN_LAMP = registerBlock("tungsten_lamp",
            () -> new TungstenLampBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> CANARY_DUST_BLOCK = BLOCKS.register("canary_dust_block",
            () -> new CanaryDustBlock(BlockBehaviour.Properties.copy(Blocks.SAND).lightLevel(state -> 1)));
    //glass:
    public static final RegistryObject<Block> CANARY_GLASS = registerBlock("canary_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel(state -> 4)));
    public static final RegistryObject<Block> CANARY_GLASS_PANE = registerBlock("canary_glass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).noOcclusion().lightLevel(state -> 4)));
    //glassware
    public static final RegistryObject<Block> CANARY_WINEGLASS = registerBlock("canary_wineglass",
            () -> new GlasswareBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel(state -> 3)));
    public static final RegistryObject<Block> CANARY_CUP = registerBlock("canary_cup",
            () -> new GlasswareBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel(state -> 3)));
    public static final RegistryObject<Block> CANARY_PLATE = registerBlock("canary_plate",
            () -> new GlasswareBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel(state -> 3)));
    public static final RegistryObject<Block> CANARY_GLASSWARE = registerBlock("canary_glassware",
            () -> new GlasswareBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel(state -> 3)));

    //shelves
    public static final RegistryObject<Block> ACACIA_SHELF_INDENTED = registerBlock("acacia_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> BAMBOO_SHELF_INDENTED = registerBlock("bamboo_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> BIRCH_SHELF_INDENTED = registerBlock("birch_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_SHELF_INDENTED = registerBlock("cherry_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_SHELF_INDENTED = registerBlock("crimson_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_SHELF_INDENTED = registerBlock("dark_oak_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_SHELF_INDENTED = registerBlock("jungle_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_SHELF_INDENTED = registerBlock("mangrove_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_SHELF_INDENTED = registerBlock("oak_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_SHELF_INDENTED = registerBlock("spruce_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_SHELF_INDENTED = registerBlock("warped_shelf_indented",
            () -> new ShelfIndentedBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

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
