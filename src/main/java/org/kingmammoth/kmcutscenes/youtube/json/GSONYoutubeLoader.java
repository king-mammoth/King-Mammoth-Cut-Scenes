package org.kingmammoth.kmcutscenes.youtube.json;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.youtube.Parameters;
import org.kingmammoth.kmcutscenes.youtube.YoutubeVideoLink;

import com.google.gson.Gson;

public class GSONYoutubeLoader {

	public static void loadScenes() throws Exception {
		
		File[] dir = new File("config/KingMammothCutScenes").listFiles();

		for (int i = 0; i < dir.length; i++) {

			if (getFileExtension(dir[i]).equals(".json")) {

				Parameters p = new Gson().fromJson(readFile("config/KingMammothCutScenes/" + dir[i].getName()), Parameters.class);
				KingMammothCutScenes.videos.put(p.event[0], new YoutubeVideoLink(p));
				
			}

		}
		
		// return new YoutubeVideoLink(new Gson().fromJson(readFile(JSONHandler.EventLoadWorld), Parameters.class));

	}

	public static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, StandardCharsets.UTF_8);
	}

	private static String getFileExtension(File file) {
		String name = file.getName();
		int lastIndexOf = name.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return "";
		}
		return name.substring(lastIndexOf);
	}
}
