package net.qnoll.teslacabinet.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class VanDeGraaffBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public VanDeGraaffBlock(Properties pProperties) {
        super(pProperties);
    }

    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(2, 0, 0, 14, 4, 16),
            Block.box(4, 4, 2, 12, 16, 14)
    );
    private static final VoxelShape SHAPE_EAST  = rotateShape(SHAPE_NORTH, Rotation.CLOCKWISE_90);
    private static final VoxelShape SHAPE_SOUTH = rotateShape(SHAPE_NORTH, Rotation.CLOCKWISE_180);
    private static final VoxelShape SHAPE_WEST  = rotateShape(SHAPE_NORTH, Rotation.COUNTERCLOCKWISE_90);

    private static VoxelShape rotateShape (VoxelShape shape, Rotation rotation) {
        VoxelShape result = Shapes.empty();

        for (AABB box : shape.toAabbs()) {
            double minX = box.minX, minY = box.minY, minZ = box.minZ;
            double maxX = box.maxX, maxY = box.maxY, maxZ = box.maxZ;

            AABB rotated;
            switch (rotation) {
                case CLOCKWISE_90 -> rotated = new AABB(
                        1 - maxZ, minY, minX,
                        1 - minZ, maxY, maxX
                );
                case CLOCKWISE_180 -> rotated = new AABB(
                        1 - maxX, minY, 1 - maxZ,
                        1 - minX, maxY, 1 - minZ
                );
                case COUNTERCLOCKWISE_90 -> rotated = new AABB(
                        minZ, minY, 1 - maxX,
                        maxZ, maxY, 1 - minX
                );
                default -> rotated = box;
            }

            result = Shapes.or(result, Shapes.create(rotated));
        }

        return result;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case EAST  -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST  -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        if (Screen.hasShiftDown()) {
            pTooltip.add(Component.translatable("tooltip.teslacabinet.van_de_graaff_block.lore")
                    .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        } else {
            pTooltip.add(Component.translatable("tooltip.teslacabinet.shift_hint")
                    .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        }

        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    };

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
