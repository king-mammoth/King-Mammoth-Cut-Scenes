package org.kingmammoth.kmcutscenes.event;

import java.util.concurrent.atomic.AtomicBoolean;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.config.ModConfig;
import org.kingmammoth.kmcutscenes.video.VideoPlayer;
import org.kingmammoth.kmcutscenes.video.VideoThread;
import org.kingmammoth.kmcutscenes.youtube.Parameters;
import org.kingmammoth.kmcutscenes.youtube.YoutubeVideoLink;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class EventHandler {

	public static boolean subscribed = false;

	public static Thread videoThread;
	public static VideoPlayer cutscene;
	public static VideoThread run;
	public static AtomicBoolean isDone = new AtomicBoolean(false);

	public static void play() {
		
		if (!subscribed) {

			KingMammothCutScenes.logger.info("Got World Generation Event");

			subscribed = true;

			if (KingMammothCutScenes.playonceonly) {

				KingMammothCutScenes.logger.info("Playing video for the first time.");

				videoThread = new Thread(new VideoThread(cutscene, isDone));
				videoThread.start();

				ModConfig.writeConfig("internal", "playedvideo", 0);

			} else {

				KingMammothCutScenes.logger.info("Playing video.");

				videoThread = new Thread(new VideoThread(cutscene, isDone));
				videoThread.start();

				ModConfig.writeConfig("internal", "playedvideo", -1);

			}

		}

	}

	@SubscribeEvent
	public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) throws Exception {
		isDone.set(true);
		videoThread.interrupt();

	}

	@SubscribeEvent
	public static void onWorldUnload(WorldEvent.Unload event) {
		subscribed = false;
		isDone.lazySet(false);
		KingMammothCutScenes.logger.info("Unloading world");
	}

	
	public static boolean splashscreen;
	@SubscribeEvent
	public void preInit(FMLPreInitializationEvent event) {
		
		if (splashscreen && KingMammothCutScenes.current == null) {
			
			KingMammothCutScenes.current = KingMammothCutScenes.videos.get("splashscreen");
			play();
			
		}
		
	}
	
	public static boolean mainmenu;
	public static boolean createworld;
	
	
	public static boolean loadworld;
	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Load event) {

		if (loadworld && KingMammothCutScenes.current == null) {
			
			KingMammothCutScenes.current = KingMammothCutScenes.videos.get("loadworld");
			play();

		}

	}

	public static boolean exitworld;
	@SubscribeEvent
	public static void onWorldExit(PlayerEvent.PlayerLoggedOutEvent event) {

		if (exitworld && KingMammothCutScenes.current == null) {
			
			KingMammothCutScenes.current = KingMammothCutScenes.videos.get("exitworld");
			play();

		}

	}

	public static boolean obtainitem;
	public static String item = "";
	@SubscribeEvent
	public static void onItemCraft(PlayerEvent.ItemCraftedEvent event) {
		
		if (obtainitem && KingMammothCutScenes.current == null) {
			
			if (event.crafting.getItem().getUnlocalizedName().equals(item)) {
				
				KingMammothCutScenes.current = KingMammothCutScenes.videos.get("obtainitem");
				play();
				
			}
			
		}
		
	}
	@SubscribeEvent
	public static void onItemSmelt(PlayerEvent.ItemSmeltedEvent event) {
		
		if (obtainitem && KingMammothCutScenes.current == null) {
			
			if (event.smelting.getItem().getUnlocalizedName().equals(item)) {
				
				KingMammothCutScenes.current = KingMammothCutScenes.videos.get("obtainitem");
				play();
				
			}
			
		}
		
	}
	@SubscribeEvent
	public static void onItemPickup(PlayerEvent.ItemPickupEvent event) {
		
		if (obtainitem && KingMammothCutScenes.current == null) {
			
			if (event.getStack().getItem().getUnlocalizedName().equals(item)) {
				
				KingMammothCutScenes.current = KingMammothCutScenes.videos.get("obtainitem");
				play();
				
			}
			
		}
		
	}

	public static boolean killmob;
	public static String mob = "";
	@SubscribeEvent
	public static void onEntityKill(LivingDeathEvent event) {

		if (killmob && KingMammothCutScenes.current == null) {

			if (event.getSource().getTrueSource() instanceof EntityPlayer) {

				if (event.getEntity().getName().equals(mob)) {
					
					KingMammothCutScenes.current = KingMammothCutScenes.videos.get("killmob");
					play();

				}

			}

		}

	}

	public static boolean location;
	public static int loc = 0;
	@SubscribeEvent
	public static void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {

		if (location && KingMammothCutScenes.current == null) {

			if (event.toDim == loc) {
				
				KingMammothCutScenes.current = KingMammothCutScenes.videos.get("location");
				play();

			}

		}

	}

	public static void subscribe(YoutubeVideoLink[] links) throws Exception {

		for (int i = 0; i < links.length; i++) {

			Parameters p = links[i].parameters;

			switch (p.event[0]) {

			case "splashscreen":
				splashscreen = true;
				break;

			case "mainmenu":
				mainmenu = true;
				break;

			case "createworld":
				createworld = true;
				break;

			case "loadworld":
				loadworld = true;
				break;

			case "exitworld":

				exitworld = true;
				break;

			case "obtainitem":

				if (p.event[1].isEmpty()) {

					throw new Exception("Second argument for obtainitem not defined!");

				} else {

					obtainitem = true;
					item = p.event[2];
					break;

				}

			case "killmob":

				if (p.event[1].isEmpty()) {

					throw new Exception("Second argument for obtainitem not killmob!");

				} else {

					killmob = true;
					mob = p.event[2];
					break;

				}

			case "location":

				if (p.event[1].isEmpty()) {

					throw new Exception("Second argument for location not defined!");

				} else {

					location = true;
					loc = Integer.parseInt(p.event[3]);
					break;

				}

			default:
				throw new Exception("Error in Event. Not defined!");

			}

		}

	}

}