package yuma140902.yumalib_ee.event_handlers;

import java.util.Random;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import yuma140902.yumalib_ee.YTConstants;
import yuma140902.yumalib_ee.api.world.gen.biome.BiomeDecorators;
import yuma140902.yumalib_ee.config.YLConfigCore;
import yuma140902.yumalib_ee.loot.MobDropHandler;

public class YLCommonEventHandler {
private YLCommonEventHandler() {}
	
	public static final YLCommonEventHandler INSTANCE = new YLCommonEventHandler();
	
	
	@SubscribeEvent
	public void onBiomeDecoration(DecorateBiomeEvent.Pre event) {
		World world = event.world;
		int chunkX = event.chunkX;
		int chunkZ = event.chunkZ;
		Random random = event.rand;
		
		if(world == null || random == null) {
			return;
		}
		BiomeDecorators.decorate(world, chunkX, chunkZ, random);
	}
	
	@SubscribeEvent
	public void onLivingDrop(LivingDropsEvent event) {
		MobDropHandler.INSTANCE.onLivingDrop(event);
	}
	
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(YTConstants.MOD_ID.equals(event.modID))
			YLConfigCore.syncConfig();
	}
}