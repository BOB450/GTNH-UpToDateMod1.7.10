package yuma140902.yumalib.api.util;

import yuma140902.yumalib.api.McConst;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

@Deprecated
public class WorldUtils {
    public static Block getBlock(World world, BlockPos pos) {
        return world.getBlock(pos.x(), pos.y(), pos.z());
    }

    public static boolean isAir(World world, BlockPos pos) {
        return world.isAirBlock(pos.x(), pos.y(), pos.z());
    }

    public static int getMeta(World world, BlockPos pos) {
        return world.getBlockMetadata(pos.x(), pos.y(), pos.z());
    }

    public static void setMeta(World world, int x, int y, int z, int meta, SetBlockFlag flag) {
        world.setBlockMetadataWithNotify(x, y, z, meta, flag.toInt());
    }

    public static void setMeta(World world, int x, int y, int z, int meta) {
        setMeta(world, x, y, z, meta, SetBlockFlag.NORMAL());
    }

    // デフォルトの{@link World#isSideSolid()}だと下置きハーフブロックの下面の判定などができなかったため作成
    public static boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection direction, boolean dflt) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        // 下置きハーフブロック
        if (direction == ForgeDirection.DOWN && block instanceof BlockSlab) {
            return (McConst.Meta$.MODULE$.IS_SLAB_UPPER() & meta) != McConst.Meta$.MODULE$.IS_SLAB_UPPER();
        }
        // 階段
        else if (direction == ForgeDirection.DOWN && block instanceof BlockStairs) {
            return (McConst.Meta$.MODULE$.IS_STAIRS_UPSIDE_DOWN() & meta) != McConst.Meta$.MODULE$.IS_STAIRS_UPSIDE_DOWN();
        }
        return world.isSideSolid(x, y, z, direction, dflt);
    }

    /**
     * ブロックが当たり判定を持たないかどうかを判定する
     *
     * @param world
     * @param pos
     * @return 当たり判定を持たないならtrue、持つならfalse
     */
    public static boolean noCollisionBox(World world, BlockPos pos) {
        Block block = WorldUtils.getBlock(world, pos);
        return block.getCollisionBoundingBoxFromPool(world, pos.x(), pos.y(), pos.z()) == null;
    }

}
