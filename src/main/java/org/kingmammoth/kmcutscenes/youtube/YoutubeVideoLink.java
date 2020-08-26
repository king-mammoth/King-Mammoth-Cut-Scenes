package org.kingmammoth.kmcutscenes.youtube;

import java.util.HashMap;

import org.kingmammoth.kmcutscenes.video.LinkUtils;

public class YoutubeVideoLink {
	
	public String url;
	
	public YoutubeVideoLink(String link, Parameters p) throws Exception {
		
		String embed = LinkUtils.getEmbedLink(link) + "?";
		
		StringBuilder sb = new StringBuilder(embed);
		
		HashMap<String, Object> arguments = p.getArguments();
		for (String key : arguments.keySet()) {
			
			Object val = arguments.get(key);
			
			if (val instanceof Integer) {
				
				sb.append(key + "=" + (int)val);
				sb.append("&");
				
			} else if (val instanceof String) {
				
				sb.append(key + "=" + '"' + val.toString() + '"');
				sb.append("&");
				
			}
			
		}

		this.url = sb.toString().substring(0, sb.length() - 1);
		
	}


}
