package turniplabs.examplemod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.Texture;
import net.minecraft.client.render.entity.ArmoredZombieRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelZombie;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockSlab;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.monster.EntityArmoredZombie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.BlockHelper;
import turniplabs.halplibe.helper.EntityHelper;


public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static final Block nothing = new BlockBuilder(MOD_ID)
		.build(new NothingBlock("nothing",NothingBlock.ID, Block.tallgrassFern.blockMaterial));

	@Override
    public void onInitialize() {
        LOGGER.info("ExampleMod initialized.");

		EntityHelper.createTileEntity(TileEntityNothing.class, "TileEntityNothing");

		EntityHelper.createEntity(EntityZombieTest.class, new MobRenderer<EntityZombieTest>(new ModelZombie(), 0.5f), 60, "pepe");
    }
}
