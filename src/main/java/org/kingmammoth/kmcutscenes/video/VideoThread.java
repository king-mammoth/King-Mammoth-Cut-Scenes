package org.kingmammoth.kmcutscenes.video;

import java.util.concurrent.atomic.AtomicBoolean;

public class VideoThread implements Runnable {

	public VideoPlayer player;
	public static AtomicBoolean isDone;
	
	public VideoThread(VideoPlayer playerDummy, AtomicBoolean isDoneDummy) {
		player = playerDummy;
		isDone = isDoneDummy;
	}

	@Override
	public void run() {
		
		playVideo();
		player.primary.show();
	}

	public void stopVideo() throws Exception {
		player.stop();
	
	}

	private void playVideo() {
		player = new VideoPlayer();
		player.isDone = isDone;
		player.launchApp();
	}
}
