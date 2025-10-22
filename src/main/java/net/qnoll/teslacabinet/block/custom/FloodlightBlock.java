package net.qnoll.teslacabinet.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FloodlightBlock extends Block {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public FloodlightBlock(Properties pProperties) {
        super(pProperties.lightLevel(state -> state.getValue(POWERED) ? 15 : 0));
        this.registerDefaultState(this.defaultBlockState()
                .setValue(POWERED, false)
                .setValue(FACING, net.minecraft.core.Direction.NORTH));
    }

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        if (Screen.hasShiftDown()) {
            pTooltip.add(Component.translatable("tooltip.teslacabinet.floodlight.lore")
                    .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        } else {
            pTooltip.add(Component.translatable("tooltip.teslacabinet.shift_hint")
                    .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        }

        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    };

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction dir = context.getNearestLookingDirection().getOpposite();
        return this.defaultBlockState()
                .setValue(FACING, dir)
                .setValue(POWERED, context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos,
                                Block block, BlockPos fromPos, boolean moving) {
        if (!level.isClientSide) {
            boolean powered = level.hasNeighborSignal(pos);
            if (powered != state.getValue(POWERED)) {
                level.setBlock(pos, state.setValue(POWERED, powered), 2);
            }
        }
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentState, Direction direction) {
        return false; // Always render all faces
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(POWERED, FACING);
    }
}
