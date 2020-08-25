package org.kingmammoth.kmcutscenes.mixin;

import java.io.IOException;
import java.util.List;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.video.VideoPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateWorld;

@Mixin(GuiCreateWorld.class)
public class WorldCreation {

	@Shadow
	protected List<GuiButton> buttonList;

	@Inject(at = @At("HEAD"), method = "actionPerformed()V")
	protected void actionPerformed(GuiButton button) throws IOException {

		if (KingMammothCutScenes.playonceonly) {

			if (!KingMammothCutScenes.playedvideo) {

				if (creatingWorldPressed(button)) {

					KingMammothCutScenes.logger.info("Playing video for the first time.");
					playVideo();

				}

			}
			
		} else {
			
			if (creatingWorldPressed(button)) {

				KingMammothCutScenes.logger.info("Playing video.");
				playVideo();

			}
			
		}

	}

	private boolean creatingWorldPressed(GuiButton b) {

		return b.enabled && b.id == 1;

	}

	@SuppressWarnings("static-access")
	private void playVideo() {

		int width = Minecraft.getMinecraft().displayWidth;
		int height = Minecraft.getMinecraft().displayHeight;

		VideoPlayer cutscene = new VideoPlayer();
		cutscene.link = KingMammothCutScenes.videolink;
		cutscene.width = width;
		cutscene.height = height;
		cutscene.launch(new String[] {});

	}

}
