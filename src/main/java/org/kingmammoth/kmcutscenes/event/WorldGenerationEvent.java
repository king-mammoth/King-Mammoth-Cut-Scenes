package org.kingmammoth.kmcutscenes.event;

import java.util.concurrent.atomic.AtomicBoolean;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.config.ModConfig;
import org.kingmammoth.kmcutscenes.video.VideoPlayer;
import org.kingmammoth.kmcutscenes.video.VideoThread;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class WorldGenerationEvent {

	public static boolean subscribed = false;
	public static Thread videoThread;
	public static VideoPlayer cutscene;
	public static VideoThread run;
	public static AtomicBoolean isDone = new AtomicBoolean(false);

	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Load event) {

		if (!subscribed) {

			KingMammothCutScenes.logger.info("Got World Generation Event");
			subscribed = true;
			// cutscene = new VideoPlayer();
			if (KingMammothCutScenes.playonceonly) {

				// if (!KingMammothCutScenes.playedvideo) {

				KingMammothCutScenes.logger.info("Playing video for the first time.");

				videoThread = new Thread(new VideoThread(cutscene, isDone));
				videoThread.start();

				ModConfig.writeConfig("internal", "playedvideo", 0);
				KingMammothCutScenes.logger.info("Finished playing video for the first time.");

				// }

			} else {

				KingMammothCutScenes.logger.info("Playing video.");

				videoThread = new Thread(new VideoThread(cutscene, isDone));
				videoThread.start();

				ModConfig.writeConfig("internal", "playedvideo", -1);
				KingMammothCutScenes.logger.info("Finished playing video.");

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

}