package org.kingmammoth.kmcutscenes.event;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.config.ModConfig;
import org.kingmammoth.kmcutscenes.video.VideoPlayer;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class WorldGenerationEvent {

	private static boolean subscribed = false;

	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Load event) {

		if (!subscribed) {

			KingMammothCutScenes.logger.info("Got World Generation Event");
			subscribed = true;

			if (KingMammothCutScenes.playonceonly) {

				if (!KingMammothCutScenes.playedvideo) {

					KingMammothCutScenes.logger.info("Playing video for the first time.");

					Thread t = new Thread(() -> {
						playVideo();
					});
					t.start();

					ModConfig.writeConfig("internal", "playedvideo", 0);
					KingMammothCutScenes.logger.info("Finished playing video for the first time.");

				}

			} else {

				KingMammothCutScenes.logger.info("Playing video.");
				
				Thread t = new Thread(() -> {
					playVideo();
				});
				t.start();

				ModConfig.writeConfig("internal", "playedvideo", -1);
				KingMammothCutScenes.logger.info("Finished playing video.");

			}

		}

	}

	private static void playVideo() {
		


//		int width = Minecraft.getMinecraft().displayWidth;
//		int height = Minecraft.getMinecraft().displayHeight;

		VideoPlayer cutscene = new VideoPlayer();
		cutscene.launchApp();

	}

}
