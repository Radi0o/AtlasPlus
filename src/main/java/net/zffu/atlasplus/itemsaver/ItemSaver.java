package net.zffu.atlasplus.itemsaver;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.zffu.atlasplus.AtlasPlus;
import net.zffu.atlasplus.itemeditor.EditedItem;
import net.zffu.atlasplus.itemsaver.utils.ItemFileUtils;

public class ItemSaver {

	
	public ItemSaver() {
		
	}
	
	public void saveItem(ItemStack item, String name) {
		NBTTagCompound nbt = item.getTagCompound();
		String display = item.getDisplayName();
		
		NBTTagList nbtLore = item.getTagCompound().getCompoundTag("display").getTagList("Lore", 8); 
		
		ArrayList<String> lore = new ArrayList<>();
		
		for(int i = 0 ; i < nbtLore.tagCount() ; i++) {
			lore.add(nbtLore.getStringTagAt(i));
		}
		
		JSONObject json = new JSONObject();
		json.put("display_name", display);
		json.put("lore", lore);
		
		ItemFileUtils.createItemFile(name, json);
		
	}
	
	
	public void loadItem(String name) {
		try {
			EditedItem item = ItemFileUtils.loadItemFile(name);
			AtlasPlus.getInstance().getItemEditor().processItem(item);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
