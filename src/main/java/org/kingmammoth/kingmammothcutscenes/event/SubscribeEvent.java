package org.kingmammoth.kingmammothcutscenes.event;

import java.lang.reflect.Method;

@Deprecated
public class SubscribeEvent {

	public static Class<?> getClazz(String event) {

		String[] split = event.split(".");

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < split.length - 1; i++) {

			sb.append(split[i] + ".");

		}

		try {
			return Class.forName(sb.toString().substring(0, sb.length() - 1));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public static Method getMethod(String event, String[] params) {

		String[] split = event.split(".");
		Class<?>[] clazz = new Class<?>[params.length];

		for (int i = 0; i < clazz.length; i++) {

			try {
				clazz[i] = Class.forName(params[i]);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			return getClazz(event).getMethod(split[split.length - 1], clazz);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

}
