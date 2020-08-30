package org.kingmammoth.kmcutscenes.youtube;

import org.kingmammoth.kmcutscenes.video.VideoSettings;

import com.google.gson.annotations.JsonAdapter;

public class DefaultReferences {
	
	public String event[] = new String[] {"loadworld", ""};
	public String url = "";
	
	public int width = -1;
	public int height = -1;
	
	public int autoplay = 0;
	public int cc_load_policy = 0;
	public int controls = 0;
	public int disablekb = 0;
	public int end = 0;
	public int fs = 0;
	public int iv_load_policy = 0;
	public int loop = 0;
	public int modestbranding = 0;
	public int rel = 1;
	public int start = 0;
	
	public String cc_lang_pref = "";
	public String color = "";
	public String hl = "";
	
	@JsonAdapter(CustomJSONAdapter.class)
	public VideoSettings settings = new VideoSettings(0.9f, true, false, true, true, true);
	
	public String[] getEvent() {
		return event;
	}

	public void setEvent(String[] event) {
		this.event = event;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getAutoplay() {
		return autoplay;
	}

	public void setAutoplay(int autoplay) {
		this.autoplay = autoplay;
	}

	public int getCc_load_policy() {
		return cc_load_policy;
	}

	public void setCc_load_policy(int cc_load_policy) {
		this.cc_load_policy = cc_load_policy;
	}

	public int getControls() {
		return controls;
	}

	public void setControls(int controls) {
		this.controls = controls;
	}

	public int getDisablekb() {
		return disablekb;
	}

	public void setDisablekb(int disablekb) {
		this.disablekb = disablekb;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getFs() {
		return fs;
	}

	public void setFs(int fs) {
		this.fs = fs;
	}

	public int getIv_load_policy() {
		return iv_load_policy;
	}

	public void setIv_load_policy(int iv_load_policy) {
		this.iv_load_policy = iv_load_policy;
	}

	public int getLoop() {
		return loop;
	}

	public void setLoop(int loop) {
		this.loop = loop;
	}

	public int getModestbranding() {
		return modestbranding;
	}

	public void setModestbranding(int modestbranding) {
		this.modestbranding = modestbranding;
	}

	public int getRel() {
		return rel;
	}

	public void setRel(int rel) {
		this.rel = rel;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getCc_lang_pref() {
		return cc_lang_pref;
	}

	public void setCc_lang_pref(String cc_lang_pref) {
		this.cc_lang_pref = cc_lang_pref;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHl() {
		return hl;
	}

	public void setHl(String hl) {
		this.hl = hl;
	}
	
	public VideoSettings getSettings() {
		return settings;
	}
	
	public void setSettings(VideoSettings settings) {
		this.settings = settings;
	}
	
}
