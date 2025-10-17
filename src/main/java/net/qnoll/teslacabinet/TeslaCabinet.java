package net.qnoll.teslacabinet;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.qnoll.teslacabinet.block.ModBlocks;
import net.qnoll.teslacabinet.block.entity.ModBlockEntities;
import net.qnoll.teslacabinet.item.ModCreativeModTabs;
import net.qnoll.teslacabinet.item.ModItems;
import net.qnoll.teslacabinet.sound.ModSounds;
import org.slf4j.Logger;

//MDK VERSION 1-47.4.9
// The value here should match an entry in the META-INF/mods.toml file
@Mod(TeslaCabinet.MOD_ID)
public class TeslaCabinet {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "teslacabinet";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TeslaCabinet(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        //TODO: Add inventions and fix structure again!!!
        //TODO: Add photos to CurseForge and Modrinth
        //register with eventbus
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    //Add alpha to textures when transparent (glass, planes, etc.)
    private void clientSetup (final FMLClientSetupEvent event) {
        //chemistry
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ALEMBIC_COPPER.get(), RenderType.cutout());
        //misc
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TESLA_COIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TESLA_COIL_TABLETOP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.VAN_DE_GRAAFF_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.STATIC_ELECTRICITY_DOME.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SCALES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TUNGSTEN_LAMP.get(), RenderType.translucent());
        //phonographs
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PHONOGRAPH_EDISON.get(), RenderType.cutout());
        //microscopes
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MICROSCOPE_SINGLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MICROSCOPE_BRASS.get(), RenderType.cutout());
        //x-meters
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.THERMOCOUPLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_MULTIMETER.get(), RenderType.cutout());
        //deco
        //glass
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANARY_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANARY_GLASS_PANE.get(), RenderType.translucent());
        //glassware
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANARY_WINEGLASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANARY_CUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANARY_PLATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANARY_GLASSWARE.get(), RenderType.cutout());
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}

//TODO ROADMAP:
//  todo - Van De Graaff generator;
//todo - Big Tesla coil
//todo - Dynamo
//todo - wimshurst machine
//todo - telegraph
//todo - telephone
//todo - fluorescent ceiling lamp
//todo - projector lamp

//project structure:
//models/textures/ModBlocks sorting/any kind of sorting EXCEPT creative menu (TODO creative menu custom sorting, for now sorting as updates):
//MAIN BLOCKS: inventions/update_name
//LIGHT SOURCES (lamps, torches/etc.): light/update_name
//CHEMICAL: chemistry/update_name
//GLASSWARE: glassware/update_name
//BLOCKS: .
//PANES: panes/pane_name [panes/. for textures]
//WEIGHTS: weights/weight_name [weights/. for textures]
//METERS: meters/.