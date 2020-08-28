package org.kingmammoth.kmcutscenes.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.kingmammoth.kmcutscenes.youtube.DefaultValueReference;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EventConfigManager {
	
	public static void loadFiles() throws FileNotFoundException {
		
		File[] dir = new File("config/KingMammothCutScenes").listFiles();
		
		for (int i = 0; i < dir.length; i++) {
			
			if (getFileExtension(dir[i]).equals(".json")) {
				
//				Gson gson = new GsonBuilder().setPrettyPrinting().create();
//				String json = gson.toJson(new DefaultValueReference());
//				
//				PrintWriter pw = new PrintWriter("config/KingMammothCutScenes/" + fileNames[i]);
//				pw.println(json);
//				pw.close();
				
			}
			
		}
		
	}
	
	private static String getFileExtension(File file) {
	    String name = file.getName();
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf);
	}

}
