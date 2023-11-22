package net.graeyamber.graeystuff.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nullable;

public class RedstoneGaugeBlock extends Block {
    public static final IntegerProperty INPUT_POWER = BlockStateProperties.POWER;
    public RedstoneGaugeBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(INPUT_POWER, 0));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        pContext.getLevel().scheduleTick(pContext.getClickedPos(), this, 4);
        return this.defaultBlockState();
    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        if (!pLevel.isClientSide) {
            if (pState.getValue(INPUT_POWER) != pLevel.getBestNeighborSignal(pPos)) {
                pLevel.scheduleTick(pPos, this, 4);
            }
        }
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int current = pState.getValue(INPUT_POWER);
        int best = pLevel.getBestNeighborSignal(pPos);
        if (current != best) {
            pLevel.setBlock(pPos, pState.setValue(INPUT_POWER,
                    (current > best) ? current - 1 : current + 1), 3);
            pLevel.scheduleTick(pPos, this, 4);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(INPUT_POWER);
    }
}