package org.kingmammoth.kmcutscenes.video;

public class VideoSettings {

	public double transperency = 0.9f;

	public boolean showSkipButton = true;
	public boolean exitOnClose = false;
	public boolean followMinecraftScreenDrag = true;
	public boolean followMinecraftScreenSize = true;
	public boolean focusOnScreen = true;

	public VideoSettings(double transperency, boolean showSkipButton, boolean exitOnClose,
			boolean followMinecraftScreenDrag, boolean followMinecraftScreenSize, boolean focusOnScreen) {

		this.transperency = transperency;

		this.showSkipButton = showSkipButton;
		this.exitOnClose = exitOnClose;
		this.followMinecraftScreenDrag = followMinecraftScreenDrag;
		this.followMinecraftScreenSize = followMinecraftScreenSize;
		this.focusOnScreen = focusOnScreen;

	}

	public double getTransperency() {
		return transperency;
	}

	public void setTransperency(double transperency) {
		this.transperency = transperency;
	}

	public boolean isShowSkipButton() {
		return showSkipButton;
	}

	public void setShowSkipButton(boolean showSkipButton) {
		this.showSkipButton = showSkipButton;
	}

	public boolean isExitOnClose() {
		return exitOnClose;
	}

	public void setExitOnClose(boolean exitOnClose) {
		this.exitOnClose = exitOnClose;
	}

	public boolean isFollowMinecraftScreenDrag() {
		return followMinecraftScreenDrag;
	}

	public void setFollowMinecraftScreenDrag(boolean followMinecraftScreenDrag) {
		this.followMinecraftScreenDrag = followMinecraftScreenDrag;
	}

	public boolean isFollowMinecraftScreenSize() {
		return followMinecraftScreenSize;
	}

	public void setFollowMinecraftScreenSize(boolean followMinecraftScreenSize) {
		this.followMinecraftScreenSize = followMinecraftScreenSize;
	}

	public boolean isFocusOnScreen() {
		return focusOnScreen;
	}

	public void setFocusOnScreen(boolean focusOnScreen) {
		this.focusOnScreen = focusOnScreen;
	}

}
