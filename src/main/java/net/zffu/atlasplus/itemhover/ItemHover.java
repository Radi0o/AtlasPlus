package net.zffu.atlasplus.itemhover;

public class ItemHover {

	private boolean isSendindRequest;
	private ItemHoverMessageQueue messageQueue;
	private PlayerCodeStorage codeStorage;
	
	
	public ItemHover() {
		this.isSendindRequest = false;
		this.messageQueue = new ItemHoverMessageQueue();
		this.codeStorage = new PlayerCodeStorage();
	}
	
	
	public ItemHoverMessageQueue getMessageQueue() {return this.messageQueue;}
	public PlayerCodeStorage getCodeStorage() {return this.codeStorage;}
	public boolean isSendingRequest() {return this.isSendindRequest;}
	public void setIsSendingRequest(boolean b) {
		this.isSendindRequest = b;
	}
	
}
