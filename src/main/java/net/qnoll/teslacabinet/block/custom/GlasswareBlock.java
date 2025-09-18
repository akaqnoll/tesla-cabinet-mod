package net.qnoll.teslacabinet.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlasswareBlock extends Block {
    public static final IntegerProperty COUNT = IntegerProperty.create("count", 1, 4);

    private static final VoxelShape SHAPE_1 = Block.box(3, 0, 3, 13, 9, 13);
    private static final VoxelShape SHAPE_2 = Block.box(1, 0, 1, 15, 9, 15);
    private static final VoxelShape SHAPE_3 = Block.box(1, 0, 1, 15, 9, 15);
    private static final VoxelShape SHAPE_4 = Block.box(1, 0, 1, 15, 11, 15);

    public GlasswareBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(COUNT, 1));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return switch (state.getValue(COUNT)) {
            case 1 -> SHAPE_1;
            case 2 -> SHAPE_2;
            case 3 -> SHAPE_3;
            case 4 -> SHAPE_4;
            default -> SHAPE_1;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COUNT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(COUNT, 1);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);

        if (held.getItem() == this.asItem()) {
            int count = state.getValue(COUNT);
            if (count < 4) {
                level.setBlock(pos, state.setValue(COUNT, count + 1), 4);
                if (!player.isCreative()) {
                    held.shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }
}
