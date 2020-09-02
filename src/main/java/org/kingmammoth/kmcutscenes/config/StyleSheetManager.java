package org.kingmammoth.kmcutscenes.config;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class StyleSheetManager {

	public static String path = "config/KingMammothCutScenes/style.css";

	public static void init() throws IOException {

		String contents = "body {\r\n" + "    overflow-x: hidden;\r\n" + "    overflow-y: hidden;\r\n" + "}";
		PrintWriter pw = new PrintWriter(new File(path));
		pw.println(contents);
		pw.close();

	}

	public static File getFile() {

		return new File(path);

	}

}
