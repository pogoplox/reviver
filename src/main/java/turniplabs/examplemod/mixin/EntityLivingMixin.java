package turniplabs.examplemod.mixin;


import com.mojang.nbt.CompoundTag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import turniplabs.examplemod.ExampleMod;

@Mixin(value = EntityLiving.class, remap = false)
public abstract class EntityLivingMixin extends Entity {

	public EntityLivingMixin(World world) {
		super(world);
	}

	@Inject(method = "onDeath", at = @At(value = "TAIL"))
	private void spawnRespawnBlock(Entity entity, CallbackInfo ci) {

		ExampleMod.LOGGER.debug("pepe");


	}
}
