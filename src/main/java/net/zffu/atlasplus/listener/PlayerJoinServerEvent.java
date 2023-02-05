package net.zffu.atlasplus.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.zffu.atlasplus.AtlasPlus;

public class PlayerJoinServerEvent {
	
	
	


private boolean worldJustLoaded = false;
@SubscribeEvent
public void onWorldLoad(WorldEvent.Load event) {
    this.worldJustLoaded = true;
    
}


@SubscribeEvent
public void onTick(TickEvent.PlayerTickEvent event) {
    if(this.worldJustLoaded) {
        this.worldJustLoaded = false;
        if(Minecraft.getMinecraft().getCurrentServerData().serverIP.equals("play.the-atlas.net")) {
        	if(AtlasPlus.getInstance().getConfig().getString("api", "key", null, null) != "NONE") {
        		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You didnt set your api key! Most of the features will not work"));
        		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You can set your api key by doing /api new"));
        	}
        }
        
        if(AtlasPlus.getInstance().getUpdater().shouldUpdate()) {
        	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[ATLAS+] A new Version of Atlas+ is available"));
        }
    }
}


	
}
