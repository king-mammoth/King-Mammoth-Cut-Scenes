package org.kingmammoth.kmcutscenes.video;

public class VideoThread implements Runnable {

	public static VideoPlayer player;

	public VideoThread(VideoPlayer playerDummy) {
		player = playerDummy;
	}

	@Override
	public void run() {
		playVideo();
	}

	public void stopVideo() throws Exception {
		player.stop();
	}

	private static void playVideo() {
		player = new VideoPlayer();
		player.launchApp();
	}
}
