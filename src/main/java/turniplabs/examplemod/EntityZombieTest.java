package turniplabs.examplemod;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.EntityZombie;
import net.minecraft.core.world.World;

public class EntityZombieTest extends EntityZombie {
	public EntityZombieTest(World world) {
		super(world);

	}

//	@Override
//	public String getEntityTexture() {
//		return "/mob/zotch.png";
//	}

	@Override
	public void onDeath(Entity entity) {
		//this.world.setBlock((int)this.x ,((int)this.y) ,(int)this.z,1);

		NothingBlock.setBlock((int)this.x ,((int)this.y) ,(int)this.z, this,this.world);
		super.onDeath(entity);



	}


}
