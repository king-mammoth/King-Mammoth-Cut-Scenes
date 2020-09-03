package org.kingmammoth.kmcutscenes.youtube;

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

}
