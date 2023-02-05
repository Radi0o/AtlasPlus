package net.zffu.atlasplus.itemeditor;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;

public class ItemEditorUtils {

	public static void giveEmptyItem() {
		Minecraft.getMinecraft().thePlayer.sendChatMessage("/sandbox");
		
	}
	
	public static int findItemHotbarSlot() {
for(int i = 0; i<9; i++) {
			
			i++;
			if(Minecraft.getMinecraft().thePlayer.getInventory()[i].getDisplayName().equals(EnumChatFormatting.GOLD + "Editable Item")) {
				return i;
			}
		}
		return 0;
	}
	
	public static void selectEditableItem() {
		int slot = findItemHotbarSlot();
		EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().thePlayer;
		player.inventory.currentItem = slot;
	}
	 
	public static void renameItem(String name) {
		Minecraft.getMinecraft().thePlayer.sendChatMessage("/rename " + name);
	}
	
	public static void openEditMenu() {
		Minecraft.getMinecraft().thePlayer.sendChatMessage("/edit");
	}
	
	public static void selectStatsInEditMenu() {
		Minecraft.getMinecraft().thePlayer.openContainer.slotClick(20, 0, 0, Minecraft.getMinecraft().thePlayer);
	}
	
	public static void setLoreLine(int index, String line) {
		Minecraft.getMinecraft().thePlayer.sendChatMessage("/sll " + index + " " + line);
	}
	
	
	
}
