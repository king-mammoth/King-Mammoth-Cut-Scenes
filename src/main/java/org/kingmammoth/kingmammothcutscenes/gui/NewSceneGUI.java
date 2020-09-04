package org.kingmammoth.kingmammothcutscenes.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiButton;

public class NewSceneGUI extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation(
			"kingmammothcutscenes:textures/gui/youtubegui.png");

	public World world;
	public int x;
	public int y;
	public int z;
	public EntityPlayer entity;

	public GuiTextField[] textfields = new GuiTextField[4];

	public GuiTextField event;
	public GuiTextField url;
	public GuiTextField playerwidth;
	public GuiTextField playerheight;

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

			for (int i = 0; i < textfields.length; i++) {

				textfields[i].mouseClicked(mouseX - guiLeft, mouseY - guiTop, mouseButton);

			}

		} catch (Exception ignored) {}
	}

	@Override
	public void updateScreen() {
		super.updateScreen();

		for (int i = 0; i < textfields.length; i++) {

			textfields[i].updateCursorCounter();

		}

	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) {
		try {
			super.keyTyped(typedChar, keyCode);

			for (int i = 0; i < textfields.length; i++) {

				textfields[i].textboxKeyTyped(typedChar, keyCode);

			}
		} catch (Exception ignored) {}
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

		Keyboard.enableRepeatEvents(true);

		this.guiLeft = (this.width - 288) / 2;
		this.guiTop = (this.height - 210) / 2;

		event = new GuiTextField(0, this.fontRenderer, 120, 39, 150, 10);
		event.setMaxStringLength(32767);
		event.setText("loadworld");

		url = new GuiTextField(1, this.fontRenderer, 120, 59, 150, 10);
		url.setMaxStringLength(32767);
		url.setText("https://www.youtube.com/watch?v=MmB9b5njVbA");

		playerwidth = new GuiTextField(1, this.fontRenderer, 120, 79, 150, 10);
		playerwidth.setMaxStringLength(32767);
		playerwidth.setText("-1");

		playerheight = new GuiTextField(1, this.fontRenderer, 120, 99, 150, 10);
		playerheight.setMaxStringLength(32767);
		playerheight.setText("-1");

		textfields[0] = event;
		textfields[1] = url;
		textfields[2] = playerwidth;
		textfields[3] = playerheight;

		this.buttonList.add(new GuiButton(1, 160, 300, 100, 20, "Hello"));

	}

	@Override
	protected void actionPerformed(GuiButton button) {
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
