package org.kingmammoth.kingmammothcutscenes.youtube;

import java.util.HashMap;

import org.kingmammoth.kingmammothcutscenes.youtube.util.LinkUtils;

public class VideoLink {
	
	public String url;
	public Parameters parameters;
	
	public VideoLink(Parameters p) throws Exception {
		
		this.parameters = p;
		
		String embed = LinkUtils.getEmbedLink(p.url) + "?";
		
		StringBuilder sb = new StringBuilder(embed);
		
		HashMap<String, Object> arguments = p.getArguments();
		arguments.remove("url");
		
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
