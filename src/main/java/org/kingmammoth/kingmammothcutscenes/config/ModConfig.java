package org.kingmammoth.kingmammothcutscenes.config;

import java.io.File;
import java.io.IOException;

import org.kingmammoth.kingmammothcutscenes.KingMammothCutScenes;
import org.kingmammoth.kingmammothcutscenes.youtube.VideoSettings;
import org.kingmammoth.kingmammothcutscenes.youtube.json.ExampleVideoFile;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;

public class ModConfig {

	public static Configuration config;
	private static String file = "config/KingMammothCutScenes/kingmammothcutscenes.cfg";

	public static void init() {

		new File("config/KingMammothCutScenes").mkdir();

		config = new Configuration(new File(file));
		try {
			config.load();
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	/*
	 * Removes specific category from configuration file.
	 */
	public static void removeConfig(String category) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.hasCategory(category))
				config.removeCategory(new ConfigCategory(category));
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	/*
	 * Removes specific key in specific category from configuration file.
	 */
	public static void removeConfig(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key))
				config.getCategory(category).remove(key);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static int getInt(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, 0).getInt();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return 0;
	}

	public static double getDouble(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, 0D).getDouble();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return 0D;
	}

	public static float getFloat(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return (float) config.get(category, key, 0D).getDouble();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return 0f;
	}

	public static String getString(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, "").getString();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return "";
	}

	public static long getLong(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, 0L).getLong();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return 0L;
	}

	public static short getShort(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return (short) config.get(category, key, (short) 0).getInt();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return (short) 0;
	}

	public static byte getByte(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return (byte) config.get(category, key, (byte) 0).getInt();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return (byte) 0;
	}

	public static boolean getBoolean(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key))
				return config.get(category, key, false).getBoolean();
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return false;
	}

	public static void writeConfig(String category, String key, String value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			config.get(category, key, value).getString();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, int value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			config.get(category, key, value).getInt();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, boolean value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			config.get(category, key, value).getBoolean();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, long value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			config.get(category, key, value).getLong();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, double value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			config.get(category, key, value).getDouble();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, short value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			config.get(category, key, value).getInt();
			config.getCategory(category).get(key).set(Integer.valueOf(value));
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, byte value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			config.get(category, key, value).getInt();
			config.getCategory(category).get(key).set(Integer.valueOf(value));
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, float value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			config.get(category, key, value).getDouble();
			config.getCategory(category).get(key).set(Double.valueOf(value));
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static boolean hasCategory(String category) {
		config = new Configuration(new File(file));
		try {
			config.load();
			return config.hasCategory(category);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return false;
	}

	public static boolean hasKey(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (!config.hasCategory(category))
				return false;
			return config.getCategory(category).containsKey(key);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return false;
	}

	public static void setFile(String filename) {
		file = "config/" + filename;
	}

	public static File getFile() {
		return new File(file);
	}

	public static void initConfig() throws IOException {

		if (!ModConfig.getFile().exists()) {

			KingMammothCutScenes.logger
					.info("Config file for King Mammoth Cut Scenes doesn't exist. Creating one now!");

			writeConfig("internal", "playedvideo", -1);

			writeConfig("settings", "play-once-only", true);
			writeConfig("settings", "transperency", 0.85);
			writeConfig("settings", "showSkipButton", true);
			writeConfig("settings", "exitOnClose", false);
			writeConfig("settings", "followMinecraftScreenDrag", true);
			writeConfig("settings", "followMinecraftScreenSize", true);
			writeConfig("settings", "focusOnScreen", true);

		} else {

			KingMammothCutScenes.logger.info("Config file for King Mammoth Cut Scenes found. Loading in properties.");

		}

		KingMammothCutScenes.playonceonly = getBoolean("settings", "play-once-only");

		switch (getInt("internal", "playedvideo")) {

		case -1:
			KingMammothCutScenes.playedvideo = false;
			break;

		case 0:
			KingMammothCutScenes.playedvideo = true;
			break;

		default:
			KingMammothCutScenes.logger.info(
					"Internal value set to value other than -1 or 0. Please check the config to make sure it is set to one of those values.");
			KingMammothCutScenes.playedvideo = false;
			break;

		}

		float transperency = getFloat("settings", "transperency");
		boolean showSkipButton = getBoolean("settings", "showSkipButton");
		boolean exitOnClose = getBoolean("settings", "exitOnClose");
		boolean followMinecraftScreenDrag = getBoolean("settings", "followMinecraftScreenDrag");
		boolean followMinecraftScreenSize = getBoolean("settings", "followMinecraftScreenSize");
		boolean focusOnScreen = getBoolean("settings", "focusOnScreen");

		KingMammothCutScenes.settings = new VideoSettings(transperency, showSkipButton, exitOnClose,
				followMinecraftScreenDrag, followMinecraftScreenSize, focusOnScreen);

		if (!ExampleVideoFile.getFile().exists()) {

			KingMammothCutScenes.logger
					.info("Example JSON file for King Mammoth Cut Scenes doesn't exist. Creating one now!");
			ExampleVideoFile.init();

		}

		if (!StyleSheetManager.getFile().exists()) {

			KingMammothCutScenes.logger.info("CSS file for King Mammoth Cut Scenes doesn't exist. Creating one now!");
			StyleSheetManager.init();
			
		}

	}

}
