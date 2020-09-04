package org.kingmammoth.kingmammothcutscenes.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class CommandTrigger extends CommandBase {

	@Override
	public String getName() {
		return "kingmammothcutscenes";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "Usage: /kingmammothcutscenes create";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (sender instanceof EntityPlayer) {
			
			if (args[0].equalsIgnoreCase("create")) {
				
				EntityPlayer ep = (EntityPlayer) sender;
				Minecraft.getMinecraft().displayGuiScreen(new NewSceneGUI(ep.world, (int)ep.posX, (int)ep.posY, (int)ep.posZ, ep));
				
			}
			
		}
		
	}


}
