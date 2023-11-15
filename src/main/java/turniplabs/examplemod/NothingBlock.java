package turniplabs.examplemod;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockSlab;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.monster.EntityMonster;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;

import java.lang.reflect.InvocationTargetException;

public class NothingBlock extends BlockTileEntity {

	public static int ID = 1099;

	public NothingBlock(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	protected TileEntity getNewBlockEntity() {
		return new TileEntityNothing(null,0,0,0);
	}

	public static void setBlock(int x, int y, int z, EntityMonster entity, World world) {
		world.setBlock(x,y,z,NothingBlock.ID);
		world.setBlockTileEntity(x,y,z,new TileEntityNothing(entity,x,y,z));
	}

	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		TileEntityNothing tile = (TileEntityNothing) world.getBlockTileEntity(x,y,z);
		EntityMonster storedMob = (EntityMonster) tile.getStoredMob();
		try {
			EntityMonster cls = storedMob.getClass().getDeclaredConstructor(World.class).newInstance(player.world);
			player.world.entityJoinedWorld(cls);
			cls.setPos(x,y +1,z);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new RuntimeException(e);
		}

        return super.blockActivated(world, x, y, z, player);
	}


	@Override
	public boolean collidesWithEntity(Entity entity) {
		return true;
	}
}
