package net.zffu.atlasplus.listener;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minecraft.client.Minecraft;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.zffu.atlasplus.AtlasPlus;

public class ChatMessageEvent{

	@SubscribeEvent
    public void onMessageRecieved(ClientChatReceivedEvent e) throws ParseException {
        String raw = e.message.getUnformattedText();
        if(raw.contains("Your API key is: ")) {
        	String key = raw.replace("Your API key is: ", "");
        	AtlasPlus.getInstance().getConfig().get("api", "key", false).set(key);
        	AtlasPlus.getInstance().getConfig().save();
        	AtlasPlus.getInstance().getAPI().setKey(key);
        	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[ATLAS+] Your API Key was set"));
        }
        if(raw.contains("<itemdisplay>")) {
        	
    		String[] l = raw.split("<itemdisplay>");
        	String id = l[1];
        	l[0] = l[0].replace("<itemdisplay>", "");
        	l[2] = l[2].replace("<itemdisplay>", "");
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
            
            e.setCanceled(true);

        }
        
        // :item:
        
        
    }
	
	
	
	
}
