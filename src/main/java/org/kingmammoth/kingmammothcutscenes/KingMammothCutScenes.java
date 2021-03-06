package org.kingmammoth.kingmammothcutscenes;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.Logger;
import org.kingmammoth.kingmammothcutscenes.config.ModConfig;
import org.kingmammoth.kingmammothcutscenes.event.EventManager;
import org.kingmammoth.kingmammothcutscenes.gui.CommandTrigger;
import org.kingmammoth.kingmammothcutscenes.youtube.VideoLink;
import org.kingmammoth.kingmammothcutscenes.youtube.VideoSettings;
import org.kingmammoth.kingmammothcutscenes.youtube.json.GSONYoutubeLoader;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = KingMammothCutScenes.MODID, name = KingMammothCutScenes.NAME, version = KingMammothCutScenes.VERSION)
public class KingMammothCutScenes {

	public static VideoSettings settings;

	public static VideoLink current;

	public static ConcurrentHashMap<String, VideoLink> videos = new ConcurrentHashMap<>();

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
		EventManager.init(videos.values().toArray(new VideoLink[0]));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) throws Exception {

		System.out.println("========================================");
		System.out.println("transperency: " + settings.transperency);
		System.out.println("showSkipButton: " + settings.showSkipButton);
		System.out.println("exitOnClose: " + settings.exitOnClose);
		System.out.println("followMinecraftScreenDrag: " + settings.followMinecraftScreenDrag);
		System.out.println("followMinecraftScreenSize: " + settings.followMinecraftScreenSize);
		System.out.println("focusOnScreen: " + settings.focusOnScreen);
		System.out.println("========================================");

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

		event.registerServerCommand(new CommandTrigger());

	}

}
