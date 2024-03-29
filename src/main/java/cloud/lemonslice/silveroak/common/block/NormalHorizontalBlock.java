package cloud.lemonslice.silveroak.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;

public class NormalHorizontalBlock extends HorizontalBlock
{
    public NormalHorizontalBlock(Properties properties)
    {
        super(properties);
    }

    @Deprecated
    // Please use DeferredRegister rather than RegistryModule
    public NormalHorizontalBlock(Properties properties, String name)
    {
        super(properties);
        this.setRegistryName(name);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        if (context.getPlayer() != null)
        {
            return getDefaultState().with(HORIZONTAL_FACING, context.getPlayer().getHorizontalFacing().getOpposite());
        }
        return getDefaultState();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(HORIZONTAL_FACING);
    }
}
