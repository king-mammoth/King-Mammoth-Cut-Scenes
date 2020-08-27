package org.kingmammoth.kmcutscenes.youtube;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Parameters {

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

	public HashMap<String, Object> getArguments() throws Exception {

		HashMap<String, Object> args = new HashMap<>();

		Field[] fields = this.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {

			Field f = fields[i];

			if (f.getType() == int.class) {

				String name = f.getName();
				int value = f.getInt(this);

				if ((int) getValueOf(DefaultValueReference.class.newInstance(), name) != value) {

					if (!name.equals("width") && !name.equals("height")) {
						
						System.out.println("Name of Change: " + name + " => New Value Is: " + value);
						args.put(name, value);

					}

				}

			} else if (f.getType() == String.class) {

				String name = f.getName();
				String value = (String) f.get(this);

				if (!getValueOf(DefaultValueReference.class.newInstance(), name).toString().equals(value)) {

					args.put(name, value);

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
