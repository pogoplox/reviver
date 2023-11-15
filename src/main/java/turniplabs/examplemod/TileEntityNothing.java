package turniplabs.examplemod;

import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.monster.EntityMonster;
import net.minecraft.core.world.World;

public class TileEntityNothing extends TileEntity {

	private World _world;
	private EntityMonster _entity;
	private int _x;
	private int _y;
	private int _z;

	public TileEntityNothing(EntityMonster entity, int x, int y, int z) {
		_entity = entity;
		_x = x;
		_y = y;
		_z = z;
		//_world = world;
	}

	public EntityMonster getStoredMob() {
		return _entity;
	}


	@Override
	public void updateEntity() {
		super.updateEntity();
		ExampleMod.LOGGER.debug("PIIIIJJAAAA");
	}
}
