package net.zffu.atlasplus.itemeditor.listeners;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.zffu.atlasplus.AtlasPlus;

public class ItemEditorClientTickEvent {

	
	public int ticks;
	
	public ItemEditorClientTickEvent() {
		this.ticks = 0;
	}
	
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent e) {
		
		 if(this.ticks == 4 && AtlasPlus.getInstance().getItemEditor().isProcessing() && !AtlasPlus.getInstance().getItemEditor().getLoreStorage().isEmpty()){ 
		
			 AtlasPlus.getInstance().getItemEditor().getLoreStorage().processNextLine();
			
			 

		 }
		 if(AtlasPlus.getInstance().getItemEditor().isProcessing() && AtlasPlus.getInstance().getItemEditor().getLoreStorage().isEmpty()) {
			 AtlasPlus.getInstance().getItemEditor().setProcessing(false);
		 }

			 ++this.ticks;
		
		
	}
	
}
