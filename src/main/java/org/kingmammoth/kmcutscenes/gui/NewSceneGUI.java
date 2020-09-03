package org.kingmammoth.kmcutscenes.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiButton;

import java.util.HashMap;

public class NewSceneGUI extends GuiContainer {

	public static int GUIID = 1;
	public static HashMap<String, GuiTextField> guiinventory = new HashMap<>();

	private static final ResourceLocation texture = new ResourceLocation(
			"kingmammothcutscenes:textures/youtubegui.png");

	public World world;
	public int x;
	public int y;
	public int z;
	public EntityPlayer entity;
	public GuiTextField event;
	public GuiTextField url;

	public NewSceneGUI(World world, int x, int y, int z, EntityPlayer entity) {
			
			super(new GUIContainer(world, x, y, z, entity));
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 288;
			this.ySize = 210;
		}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		zLevel = 100.0F;
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		try {
			super.mouseClicked(mouseX, mouseY, mouseButton);
			event.mouseClicked(mouseX - guiLeft, mouseY - guiTop, mouseButton);
			url.mouseClicked(mouseX - guiLeft, mouseY - guiTop, mouseButton);
		} catch (Exception ignored) {
		}
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		event.updateCursorCounter();
		url.updateCursorCounter();
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) {
		try {
			super.keyTyped(typedChar, keyCode);
			event.textboxKeyTyped(typedChar, keyCode);
			url.textboxKeyTyped(typedChar, keyCode);
		} catch (Exception ignored) {
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {

		this.fontRenderer.drawString("King Mammoth Cut Scenes Editor", 70, 20, -1);
		this.fontRenderer.drawString("Cutscene Name", 30, 40, -1);
		this.fontRenderer.drawString("Event", 30, 60, -1);
		this.fontRenderer.drawString("Youtube URL", 30, 80, -1);
		this.fontRenderer.drawString("Width", 30, 100, -1);
		this.fontRenderer.drawString("Height", 30, 120, -1);

		event.drawTextBox();
		url.drawTextBox();
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void initGui() {

		super.initGui();

		this.guiLeft = (this.width - 288) / 2;
		this.guiTop = (this.height - 210) / 2;
		this.buttonList.clear();
		Keyboard.enableRepeatEvents(true);

		event = new GuiTextField(0, this.fontRenderer, 99, 42, 120, 20);
		guiinventory.put("text:event", event);
		event.setMaxStringLength(32767);
		event.setText("loadworld");

		url = new GuiTextField(1, this.fontRenderer, 99, 69, 120, 20);
		guiinventory.put("text:url", url);
		url.setMaxStringLength(32767);
		url.setText("https://www.youtube.com/watch?v=MmB9b5njVbA");

	}

	@Override
	protected void actionPerformed(GuiButton button) {
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
