package org.kingmammoth.kmcutscenes.youtube;

import java.io.IOException;

import org.kingmammoth.kmcutscenes.video.VideoSettings;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class CustomJSONAdapter extends TypeAdapter<VideoSettings> {

	@Override
	public VideoSettings read(JsonReader in) throws IOException {

		in.beginObject();
		VideoSettings settings = new VideoSettings(in.nextDouble(), in.nextBoolean(), in.nextBoolean(),
				in.nextBoolean(), in.nextBoolean(), in.nextBoolean());
		in.endObject();

		return settings;

	}

	@Override
	public void write(JsonWriter out, VideoSettings value) throws IOException {

		out.beginObject();
		VideoSettings settings = new VideoSettings(value.transperency, value.showSkipButton, value.exitOnClose,
				value.followMinecraftScreenSize, value.followMinecraftScreenSize, value.focusOnScreen);
		out.endObject();

	}

}
