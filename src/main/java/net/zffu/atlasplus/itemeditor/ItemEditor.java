package net.zffu.atlasplus.itemeditor;

public class ItemEditor {

	private ItemEditorLoreStorage loreStorage;
	private boolean isProcessing;
	
	public ItemEditor() {
		this.loreStorage = new ItemEditorLoreStorage();
		this.isProcessing = false;
	}
	
	public ItemEditorLoreStorage getLoreStorage() {return this.loreStorage;}
	public boolean isProcessing() {return this.isProcessing;}
	public void setProcessing(boolean b) {this.isProcessing = b;}
	
	public void processItem(EditedItem item) {
		if(this.isProcessing) return;
		
		this.isProcessing = true;
		
		this.loreStorage.addLines(item.getLore());
		ItemEditorUtils.renameItem(item.getDisplayName());
		
		
		
	}
	
}
