package net.zffu.atlasplus.itemeditor;

import java.util.ArrayList;

public class ItemEditorLoreStorage {

	private ArrayList<String> lore;
	private int index;
	
	
	public ItemEditorLoreStorage() {
		this.lore = new ArrayList<>();
		this.index = 1;
	}
	
	public void addLine(String line) {this.lore.add(line);}
	public void addLines(ArrayList<String> lines) {
		for(String line : lines) {
			this.lore.add(line);
		}
	}
	
	public void processNextLine() {
		String line = this.lore.get(0);
		ItemEditorUtils.setLoreLine(this.index, line);
		this.lore.remove(0);
		this.index++;
	}
	
	public boolean isEmpty() {return this.lore.isEmpty();}
	
	
	
	
	
}
