package net.zffu.atlasplus.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ViewNBTCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "viewnbt";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return getCommandName();
	}

	@Override
	  public boolean canCommandSenderUseCommand(ICommandSender sender) {
	    return true;
	  }
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§aThe NBT Of the Item was sent in the console"));
		System.out.println("Item NBT: ");
		System.out.println(player.getHeldItem().getTagCompound().toString());
		
	}

}
