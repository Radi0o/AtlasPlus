package net.zffu.atlasplus.listener;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.zffu.atlasplus.AtlasPlus;
import net.zffu.atlasplus.event.ClientPreChatEvent;

public class ClientChatEvent {
	
	 @SubscribeEvent
	public void onClientChat(ClientPreChatEvent e) {
		if(e.message.contains(":item:")) {
			JSONObject json = new JSONObject();
			ItemStack item = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();
			json.put("display_name", item.getDisplayName());
			NBTTagList nbtLore = item.getTagCompound().getCompoundTag("display").getTagList("Lore", 8); 
			
			ArrayList<String> lore = new ArrayList<>();
			
			for(int i = 0 ; i < nbtLore.tagCount() ; i++) {
				lore.add(nbtLore.getStringTagAt(i));
			}
			
			json.put("lore", lore);
			
			String id = AtlasPlus.getInstance().getPastebinAPI().createPastebin(json.toJSONString());
			if(id == "ERROR") {
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Could not send Request to server, Error code: 422"));
			}
			else {
				id = id.replace("https://pastebin.com/", "");
				String msg = e.message.replace(":item:" , "<itemdisplay>" + id + "<itemdisplay>");
				Minecraft.getMinecraft().thePlayer.sendChatMessage(msg);
			}
			
			e.setCanceled(true);
			
		}
		
	}
	

}
