package org.kingmammoth.kmcutscenes.youtube.json;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

public class ExampleVideoFile {
	
	public static String EventLoadWorld = "config/KingmammothCutScenes/ExampleScene.json";
	
	public static void init() throws IOException {
		
		new File(EventLoadWorld).createNewFile();

		String json = new Gson().toJson(new GeneratedSettings());
		
		PrintWriter pw = new PrintWriter("config/KingmammothCutScenes/ExampleScene.json");
		pw.println(json);
		pw.close();		

	}
	
	public static File getFile() {
		
		return new File(EventLoadWorld);
		
	}
	

}
