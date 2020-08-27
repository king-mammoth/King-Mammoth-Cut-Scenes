package org.kingmammoth.kmcutscenes.youtube.json;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.kingmammoth.kmcutscenes.youtube.DefaultValueReference;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONHandler {
	
	public static String EventLoadWorld = "config/kingmammothcutscenes/EventLoadWorld.json";
	
	public static void init() throws IOException {
		
		new File(EventLoadWorld).createNewFile();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(new DefaultValueReference());
		
		PrintWriter pw = new PrintWriter("config/kingmammothcutscenes/EventLoadWorld.json");
		pw.println(json);
		pw.close();		

	}
	
	public static File getFile() {
		
		return new File(EventLoadWorld);
		
	}
	

}
