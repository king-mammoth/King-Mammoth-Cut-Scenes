package org.kingmammoth.kmcutscenes.youtube.json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.youtube.Parameters;
import org.kingmammoth.kmcutscenes.youtube.YoutubeVideoLink;

import com.google.gson.Gson;

public class GSONYoutubeLoader {

	public static YoutubeVideoLink getInstance() throws Exception {

		return new YoutubeVideoLink(KingMammothCutScenes.videolink,
				(new Gson().fromJson(readFile(JSONHandler.EventLoadWorld), Parameters.class)));

	}

	public static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, StandardCharsets.UTF_8);
	}

}
