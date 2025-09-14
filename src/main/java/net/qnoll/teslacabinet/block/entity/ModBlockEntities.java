package net.qnoll.teslacabinet.block.entity;

import net.minecraftforge.eventbus.api.IEventBus;
import net.qnoll.teslacabinet.TeslaCabinet;
import net.qnoll.teslacabinet.block.ModBlocks;
import net.qnoll.teslacabinet.block.entity.custom.CanaryDustBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, TeslaCabinet.MOD_ID);

    //registering BlockEntities
    public static final RegistryObject<BlockEntityType<CanaryDustBlockEntity>> CANARY_DUST_BE =
            BLOCK_ENTITIES.register("canary_dust_block_entity",
                    () -> BlockEntityType.Builder.of(
                            CanaryDustBlockEntity::new,
                            ModBlocks.CANARY_DUST_BLOCK.get()
                    ).build(null));

    public static void register (IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}