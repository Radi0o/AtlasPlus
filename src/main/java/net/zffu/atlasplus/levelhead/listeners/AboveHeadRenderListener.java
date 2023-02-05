package net.zffu.atlasplus.levelhead.listeners;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.zffu.atlasplus.AtlasPlus;

public class AboveHeadRenderListener {

	@SubscribeEvent
	public void onRenderAboveHead(RenderLivingEvent.Specials.Post<EntityLivingBase> event) {
		
		if(!(event.entity instanceof EntityPlayer)) return;
		
		EntityPlayer player = (EntityPlayer) event.entity;
		
		if(AtlasPlus.getInstance().getLevelHead().getCache().isPlayerCached(player.getUniqueID().toString())) {
			
		}
		
		
	}
	
}
