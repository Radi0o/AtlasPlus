package net.zffu.atlasplus.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;


public class DamageCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "damage";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return getCommandName() + " <number>";
	}

	@Override
	  public boolean canCommandSenderUseCommand(ICommandSender sender) {
	    return true;
	  }
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
		NBTTagCompound nbt = player.getCurrentEquippedItem().getTagCompound();
		
		nbt.setInteger("damage", Integer.parseInt(args[0]));
		player.getCurrentEquippedItem().setTagCompound(nbt);
	
		
	}

}

