package org.kingmammoth.kingmammothcutscenes.youtube;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Parameters {

	public String[] event;
	public String url;

	public int width;
	public int height;

	public int autoplay;
	public int cc_load_policy;
	public int controls;
	public int disablekb;
	public int end;
	public int fs;
	public int iv_load_policy;
	public int loop;
	public int modestbranding;
	public int rel;
	public int start;

	public String cc_lang_pref;
	public String color;
	public String hl;

	public Parameters(String[] event, String url, int width, int height, int autoplay, int cc_load_policy, int controls,
			int disablekb, int end, int fs, int iv_load_policy, int loop, int modestbranding, int rel, int start,
			String cc_lang_pref, String color, String hl) {

		this.event = event;
		this.url = url;
		this.width = width;
		this.height = height;
		this.autoplay = autoplay;
		this.cc_load_policy = cc_load_policy;
		this.controls = controls;
		this.disablekb = disablekb;
		this.end = end;
		this.fs = fs;
		this.iv_load_policy = iv_load_policy;
		this.loop = loop;
		this.modestbranding = modestbranding;
		this.rel = rel;
		this.start = start;
		this.cc_lang_pref = cc_lang_pref;
		this.color = color;
		this.hl = hl;

	}

	public Parameters getDefaultYoutubeParameters() {

		String[] event = new String[] { "", "" };
		String url = "";

		int width = -1;
		int height = -1;

		int autoplay = 0;
		int cc_load_policy = 0;
		int controls = 1;
		int disablekb = 0;
		int end = 0;
		int fs = 0;
		int iv_load_policy = 0;
		int loop = 0;
		int modestbranding = 0;
		int rel = 1;
		int start = 0;

		String cc_lang_pref = "";
		String color = "";
		String hl = "";

		return new Parameters(event, url, width, height, autoplay, cc_load_policy, controls, disablekb,
				end, fs, iv_load_policy, loop, modestbranding, rel, start, cc_lang_pref, color, hl);

	}

	public HashMap<String, Object> getArguments() throws Exception {
		
		Parameters params = getDefaultYoutubeParameters();
		
		HashMap<String, Object> args = new HashMap<>();
		
		Field[] fields = this.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {

			Field f = fields[i];

			if (f.getType() == int.class) {

				String name = f.getName();
				int value = f.getInt(this);

				if ((int) getValueOf(params, name) != value) {

					if (!name.equals("width") && !name.equals("height")) {

						args.put(name, value);

					}

				}

			} else if (f.getType() == String.class) {

				String name = f.getName();
				String value = (String) f.get(this);
				
				if (!name.equals("url")) {
					
					if (!getValueOf(params, name).toString().equals(value)) {

						if (!name.equals(url)) {

							args.put(name, value);

						}

					}
					
				}
				
			}

		}

		return args;

	}

	public static Object getValueOf(Object clazz, String search) throws Exception {
		Field field = clazz.getClass().getField(search);
		Class<?> clazzType = field.getType();
		if (clazzType.toString().equals("int"))
			return field.getInt(clazz);
		else if (clazzType.toString().equals("String"))
			return (String) field.get(clazz);
		return field.get(clazz);
	}

}
