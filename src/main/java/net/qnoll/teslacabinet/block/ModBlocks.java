package net.qnoll.teslacabinet.block;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.qnoll.teslacabinet.TeslaCabinet;
import net.qnoll.teslacabinet.block.custom.*;
import net.qnoll.teslacabinet.item.ModItems;
import org.jetbrains.annotations.Nullable;

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

    //phonographs
    public static final RegistryObject<Block> PHONOGRAPH_EDISON = registerBlock("phonograph_edison",
            () -> new PhonographEdisonBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));

    //microscopes
    public static final RegistryObject<Block> MICROSCOPE_SINGLE = registerBlock("microscope_single",
            () -> new MicroscopeSingleBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));

    //x-meters (with arrow)
    public static final RegistryObject<Block> THERMOCOUPLE = registerBlock("thermocouple",
            () -> new ThermocoupleBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    //decorative blocks:
    //glass:
    public static final RegistryObject<Block> CANARY_GLASS = registerBlock("canary_glass",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel(state -> 4))
            {
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                    pTooltip.add(Component.translatable("tooltip.teslacabinet.canary_glass.tooltip")
                            .withStyle(ChatFormatting.GRAY));
                    if (Screen.hasShiftDown()) {
                        pTooltip.add(Component.translatable("tooltip.teslacabinet.canary_glass.lore")
                                .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
                    } else {
                        pTooltip.add(Component.translatable("tooltip.teslacabinet.shift_hint")
                                .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
                    }

                    super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
                }
            });
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
