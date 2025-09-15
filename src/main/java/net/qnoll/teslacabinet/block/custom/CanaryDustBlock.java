package net.qnoll.teslacabinet.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.qnoll.teslacabinet.block.entity.custom.CanaryDustBlockEntity;
import org.jetbrains.annotations.Nullable;

public class CanaryDustBlock extends FallingBlock implements EntityBlock {
    public CanaryDustBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CanaryDustBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide) {
            return (lvl, pos, st, be) -> {
                if (be instanceof CanaryDustBlockEntity entity) {
                    entity.tickClient();
                }
            };
        } else {
            return (lvl, pos, st, be) -> {
                if (be instanceof CanaryDustBlockEntity entity) {
                    entity.tickServer();
                }
            };
        }

    }
}
