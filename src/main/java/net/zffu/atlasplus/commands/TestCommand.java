package net.zffu.atlasplus.commands;

import java.util.ArrayList;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.zffu.atlasplus.AtlasPlus;
import net.zffu.atlasplus.itemeditor.EditedItem;

public class TestCommand extends CommandBase  {
	@Override
	public String getCommandName() {
		return "test";
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
		ArrayList<String> lore = new ArrayList<>();
		lore.add("hallo");
		lore.add("its me");
		AtlasPlus.getInstance().getItemEditor().processItem(new EditedItem(lore, "&c&lSUS"));
		
	
		
	}
}
