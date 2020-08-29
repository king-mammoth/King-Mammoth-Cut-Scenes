package org.kingmammoth.kmcutscenes.event;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.fml.client.FMLClientHandler;

public class FreshWorldCreation extends WorldSavedData {

	private static final String DATA_NAME = KingMammothCutScenes.MODID + "_CUTSCENEDATA";

	public FreshWorldCreation() {
		super(DATA_NAME);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		return null;
	}

	public static boolean isFreshlyCreated() {

		FreshWorldCreation instance = (FreshWorldCreation) FMLClientHandler.instance().getWorldClient().getMapStorage()
				.getOrLoadData(FreshWorldCreation.class, DATA_NAME);

		return instance == null ? true : false;

	}

}
