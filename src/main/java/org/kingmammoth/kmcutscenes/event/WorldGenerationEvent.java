package org.kingmammoth.kmcutscenes.event;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.config.ModConfig;
import org.kingmammoth.kmcutscenes.video.VideoPlayer;
import org.kingmammoth.kmcutscenes.video.VideoThread;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class WorldGenerationEvent {

	public static boolean subscribed = false;
	public static Thread videoThread;
	public static VideoPlayer cutscene;
	public static VideoThread run;

	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Load event) {

		if (!subscribed) {

			KingMammothCutScenes.logger.info("Got World Generation Event");
			subscribed = true;

			if (KingMammothCutScenes.playonceonly) {

				if (!KingMammothCutScenes.playedvideo) {

					KingMammothCutScenes.logger.info("Playing video for the first time.");

					videoThread = new Thread(new VideoThread(cutscene));
					videoThread.start();

					ModConfig.writeConfig("internal", "playedvideo", 0);
					KingMammothCutScenes.logger.info("Finished playing video for the first time.");

				}

			} else {

				KingMammothCutScenes.logger.info("Playing video.");
				
				videoThread = new Thread(new VideoThread(cutscene));
				videoThread.start();

				ModConfig.writeConfig("internal", "playedvideo", -1);
				KingMammothCutScenes.logger.info("Finished playing video.");

			}

		}

	}

}
