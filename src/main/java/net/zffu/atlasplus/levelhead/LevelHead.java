package net.zffu.atlasplus.levelhead;

public class LevelHead {

	private LevelCacheStorage levelCache;
	
	public LevelHead() {
		this.levelCache = new LevelCacheStorage();
	}
	
	public LevelCacheStorage getCache() {return this.levelCache;}
	
}
