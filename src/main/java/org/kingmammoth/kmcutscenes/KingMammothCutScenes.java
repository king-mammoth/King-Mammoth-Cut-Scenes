package org.kingmammoth.kmcutscenes;

import org.apache.logging.log4j.Logger;
import org.kingmammoth.kmcutscenes.config.ModConfig;
import org.kingmammoth.kmcutscenes.youtube.YoutubeVideoLink;
import org.kingmammoth.kmcutscenes.youtube.json.GSONYoutubeLoader;
import org.kingmammoth.kmcutscenes.youtube.json.JSONHandler;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = KingMammothCutScenes.MODID, name = KingMammothCutScenes.NAME, version = KingMammothCutScenes.VERSION)
public class KingMammothCutScenes {

	public static YoutubeVideoLink video;

	public static final String MODID = "kingmammothcutscenes";
	public static final String NAME = "King Mammoth Cut Scenes";
	public static final String VERSION = "1.0.0";

	public static boolean playonceonly;
	public static boolean playedvideo;

	public static String videolink;

	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) throws Exception {

		
		if (!ModConfig.getFile().exists()) {

			logger.info("Config file for King Mammoth Cut Scenes doesn't exist. Creating one now!");
			ModConfig.writeConfig("settings", "play-once-only", true);
			ModConfig.writeConfig("Settings", "video-link",
					"https://www.youtube.com/watch?v=BH9tRajQzOY&feature=emb_logo");
			ModConfig.writeConfig("internal", "playedvideo", -1);

		} else {

			logger.info("Config file for King Mammoth Cut Scenes found. Loading in properties.");

		}
		
		
		playonceonly = ModConfig.getBoolean("settings", "play-once-only");
		videolink = ModConfig.getString("settings", "video-link");

		int num = ModConfig.getInt("internal", "playedvideo");

		if (num == -1) {

			playedvideo = false;

		} else if (num == 0) {

			playedvideo = true;

		}

		
		if (!JSONHandler.getFile().exists()) {

			logger.info("JSON file for King Mammoth Cut Scenes Title doesn't exist. Creating one now!");
			JSONHandler.init();

		} else {

			logger.info("JSON file for King Mammoth Cut Scenes Title found. Loading in JSON.");

		}

		
		video = GSONYoutubeLoader.getInstance();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

}
