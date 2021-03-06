package org.kingmammoth.kingmammothcutscenes.youtube.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kingmammoth.kingmammothcutscenes.KingMammothCutScenes;
import org.kingmammoth.kingmammothcutscenes.youtube.VideoLink;

public class LinkUtils {

	public static String getEmbedLink(String url) {

		String urlPattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

		Pattern compiledPattern = Pattern.compile(urlPattern);
		Matcher matcher = compiledPattern.matcher(url);
		if (matcher.find()) {
			return "http://www.youtube.com/embed/" + matcher.group();
		}

		return "null";

	}

	public static void setNewWindowLink(int width, int height, int time) {

		KingMammothCutScenes.current.url = KingMammothCutScenes.current.url.replaceAll("([?&]start=\\w+)", "");
		KingMammothCutScenes.current.url += ("&start=" + time);

		System.out.println("New Link: " + KingMammothCutScenes.current.url);

	}

	public static String getContentURL(VideoLink link, int width, int height) {

		StringBuilder sb = new StringBuilder();
		sb.append("<html><body style='margin: 0'>");
		sb.append("");
		sb.append("<iframe");
		sb.append(" ");
		sb.append("width=");
		sb.append('"');
		sb.append(width);
		sb.append('"');
		sb.append(" ");
		sb.append("height=");
		sb.append('"');
		sb.append(height);
		sb.append('"');
		sb.append(" ");
		sb.append("src=");
		sb.append('"');
		sb.append(link.url);
		sb.append('"');
		sb.append(" ");
		sb.append("</iframe>");
		sb.append(" ");
		sb.append("</body></html>");
		String result = sb.toString();

		System.out.println(result);

		return sb.toString();

	}
}
