package org.kingmammoth.kmcutscenes;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.Logger;
import org.kingmammoth.kmcutscenes.config.ModConfig;
import org.kingmammoth.kmcutscenes.event.EventManager;
import org.kingmammoth.kmcutscenes.youtube.YoutubeVideoLink;
import org.kingmammoth.kmcutscenes.youtube.json.GSONYoutubeLoader;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = KingMammothCutScenes.MODID, name = KingMammothCutScenes.NAME, version = KingMammothCutScenes.VERSION)
public class KingMammothCutScenes {

	public static YoutubeVideoLink current = null;

	public static ConcurrentHashMap<String, YoutubeVideoLink> videos = new ConcurrentHashMap<>();

	public static final String MODID = "kingmammothcutscenes";
	public static final String NAME = "King Mammoth Cut Scenes";
	public static final String VERSION = "1.0.0";

	public static boolean playonceonly;
	public static boolean playedvideo;

	public static Logger logger;

	public static Object[] params;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws Exception {
		logger = event.getModLog();
		ModConfig.initConfig();
		GSONYoutubeLoader.loadScenes();
		EventManager.init(videos.values().toArray(new YoutubeVideoLink[0]));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) throws Exception {
		
		logger.info("====================================================");
		logger.info("IGNORE THIS MESSAGE. THIS IS ONLY FOR DEBUGGING");
		logger.info("-----------------------------------");
		logger.info("Loaded Videos:");
		logger.info("-----------------------------------");
		
		for (String key : videos.keySet()) {
			
			logger.info("Event: " + videos.get(key).parameters.event[0]);
			logger.info("Params: " + videos.get(key).parameters.event[1]);
			logger.info("-----------------------------------");
			
		}
		
		logger.info("====================================================");
		
		
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

//	@EventHandler
//	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
//		logger.warn("Invalid fingerprint detected! The file " + event.getSource().getName()
//				+ " may have been tampered with. This version will NOT be supported by the author!");
//	}

}
