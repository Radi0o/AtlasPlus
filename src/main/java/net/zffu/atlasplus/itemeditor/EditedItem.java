package net.zffu.atlasplus.itemeditor;

import java.util.ArrayList;

public class EditedItem {

	private ArrayList<String> lore;
	private String displayName;
	
	
	public EditedItem(ArrayList<String> lore, String displayName) {
		this.lore = lore;
		this.displayName = displayName;
	}
	
	public String getDisplayName() {return this.displayName;}
	public ArrayList<String> getLore() {return this.lore;}
	
}
