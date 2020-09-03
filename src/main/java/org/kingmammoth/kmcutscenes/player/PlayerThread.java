package org.kingmammoth.kmcutscenes.player;

import java.util.concurrent.atomic.AtomicBoolean;

public class PlayerThread implements Runnable {

	public YoutubeVideoPlayer player;
	public static AtomicBoolean isDone;
	
	public PlayerThread(YoutubeVideoPlayer playerDummy, AtomicBoolean isDoneDummy) {
		player = playerDummy;
		isDone = isDoneDummy;
	}

	@Override
	public void run() {
		playVideo();
		player.primary.show();
	}

	private void playVideo() {
		player = new YoutubeVideoPlayer();
		player.isDone = isDone;
		player.launchApp();
	}
}
