package org.kingmammoth.kmcutscenes.youtube.json;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.kingmammoth.kmcutscenes.youtube.DefaultReferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExampleVideoFile {
	
	public static String EventLoadWorld = "config/KingmammothCutScenes/loadworld.json";
	
	public static void init() throws IOException {
		
		new File(EventLoadWorld).createNewFile();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(new DefaultReferences());
		
		PrintWriter pw = new PrintWriter("config/KingmammothCutScenes/loadworld.json");
		pw.println(json);
		pw.close();		

	}
	
	public static File getFile() {
		
		return new File(EventLoadWorld);
		
	}
	

}
