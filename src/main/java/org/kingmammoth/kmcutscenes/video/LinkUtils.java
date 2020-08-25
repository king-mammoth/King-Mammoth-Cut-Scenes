package org.kingmammoth.kmcutscenes.video;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static String getContentURL(String link) {

		StringBuilder sb = new StringBuilder("");
		sb.append("<iframe");
		sb.append(" ");
		sb.append("width=\"560\"");
		sb.append(" ");
		sb.append("height=\"315\"");
		sb.append(" ");
		sb.append("src=");
		sb.append('"');
		sb.append(getEmbedLink(link));
		sb.append('"');
		sb.append(" ");
		sb.append("controls=\"0\"");
		sb.append(" ");
		sb.append("autoplay=\"0\"");
		sb.append(" ");
		sb.append("frameborder=\"0\"");
		sb.append(" ");
		sb.append("start");
		sb.append(" ");
		sb.append("allowfullscreen>");
		sb.append(" ");
		sb.append("</iframe>");
		
		String result = sb.toString();
		
		System.out.println(result);
		
		return sb.toString();
		
	}
}
