package org.kingmammoth.kmcutscenes.youtube.json;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.kingmammoth.kmcutscenes.youtube.Parameters;

import com.google.gson.Gson;

public class ExampleVideoFile {

	public static String EventLoadWorld = "config/KingmammothCutScenes/ExampleScene.json";

	public static void init() throws IOException {

		new File(EventLoadWorld).createNewFile();

		PrintWriter pw = new PrintWriter("config/KingmammothCutScenes/ExampleScene.json");
		pw.println(new Gson().toJson(getGeneratedObject()));
		pw.close();

	}

	public static File getFile() {

		return new File(EventLoadWorld);

	}

	public static Parameters getGeneratedObject() {

		String event[] = new String[] { "loadworld", "" };
		String url = "https://www.youtube.com/watch?v=MmB9b5njVbA";

		int width = -1;
		int height = -1;

		int autoplay = 1;
		int cc_load_policy = 0;
		int controls = 0;
		int disablekb = 1;
		int end = 0;
		int fs = 0;
		int iv_load_policy = 0;
		int loop = 0;
		int modestbranding = 1;
		int rel = 0;
		int start = 0;

		String cc_lang_pref = "";
		String color = "";
		String hl = "";

		return new Parameters(event, url, width, height, autoplay, cc_load_policy, controls, disablekb, end, fs,
				iv_load_policy, loop, modestbranding, rel, start, cc_lang_pref, color, hl);

	}

}
