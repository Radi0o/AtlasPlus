package net.zffu.atlasplus.itemhover;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.zffu.atlasplus.AtlasPlus;

public class ItemHoverMessageQueue {

	private ArrayList<String> messages;
	
	public ItemHoverMessageQueue() {
		this.messages = new ArrayList<>();
		
	}
	
	public void addMessageToQueue(String msg) {
		this.messages.add(msg);
	}
	
	
	public void parseNextMessage() throws ParseException {
		String raw = this.messages.get(0);
		String[] l = raw.split("<itemdisplay>");
    	String id = l[1];
    	String content = AtlasPlus.getInstance().getPastebinAPI().getPastebin(id);
    	
    	Object obj = new JSONParser().parse(content);
        JSONObject jo = (JSONObject) obj;
        
        String displayName = (String) jo.get("display_name");
        JSONArray lore = (JSONArray) jo.get("lore");
        
        IChatComponent comp = new ChatComponentText(displayName);
        ChatStyle msgStyle = new ChatStyle();
        
        StringBuilder loreBuilder = new StringBuilder();
        for(Object line : lore) {
        	loreBuilder.append((String) line);
        }
        
        IChatComponent loreComp = new ChatComponentText(lore.toString());
        
        HoverEvent hover = new HoverEvent(HoverEvent.Action.SHOW_TEXT, loreComp);
        comp.getChatStyle().setChatHoverEvent(hover);
        
        IChatComponent msgComp = new ChatComponentText(l[0]);
        msgComp.appendSibling(comp);
        msgComp.appendText(l[2]);
        
        Minecraft.getMinecraft().thePlayer.addChatMessage(msgComp);
        
        this.messages.remove(0);
	}
	
	
	public ArrayList<String> getMessages() {return this.messages;}
	
	
	
}
