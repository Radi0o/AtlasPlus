package net.zffu.atlasplus.levelhead;

import java.util.HashMap;

public class LevelCacheStorage {

	private HashMap<String, Integer> LEVEL_CACHE;
	
	public LevelCacheStorage() {
		this.LEVEL_CACHE = new HashMap<>();
	}
	
	public boolean isPlayerCached(String uuid) {
		return this.LEVEL_CACHE.containsKey(uuid);
	}
	
	public void addPlayer(String uuid, int level) {
		this.LEVEL_CACHE.put(uuid, level);
	}
	
	public void removePlayer(String uuid) {
		this.LEVEL_CACHE.remove(uuid);
	}
	
	public int getPlayerLevel(String uuid) {
		return this.LEVEL_CACHE.get(uuid);
	}
	
	
	
	public HashMap<String, Integer> getCache() {return this.LEVEL_CACHE;}
	
	
}
