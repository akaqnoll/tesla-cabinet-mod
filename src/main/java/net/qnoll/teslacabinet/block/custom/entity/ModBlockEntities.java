package net.qnoll.teslacabinet.block.custom.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraftforge.registries.RegistryObject;
import net.qnoll.teslacabinet.block.ModBlocks;

public class ModBlockEntities {
    public static final RegistryObject<BlockEntityType<JukeboxBlockEntity>> PHONOGRAPH_EDISON_BE =
            BLOCK_ENTITIES.register("custom_jukebox",
                    () -> BlockEntityType.Builder.of(PhonographEdisonBlockEntity::new,
                            ModBlocks.PHONOGRAPH_EDISON.get()).build(null));
}
