package net.zffu.atlasplus.commands.itemsaver;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.zffu.atlasplus.AtlasPlus;

public class LoadItemCommand extends CommandBase{
	@Override
	public String getCommandName() {
		return "loaditem";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return getCommandName() + " <string>";
	}

	@Override
	  public boolean canCommandSenderUseCommand(ICommandSender sender) {
	    return true;
	  }
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer p = (EntityPlayer) sender.getCommandSenderEntity();
		p.addChatMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "Loading your item with the name " + args[0]));
		String name = args[0];
		AtlasPlus.getInstance().getItemSaver().loadItem(args[0]);
	
		
	}
}