package org.kingmammoth.kmcutscenes.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class GUIContainer extends Container {

	World world;
	EntityPlayer entity;
	int x, y, z;

	public GUIContainer(World world, int x, int y, int z, EntityPlayer player) {
		this.world = world;
		this.entity = player;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
	}
}
