package net.zffu.atlasplus.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jdk.nashorn.internal.parser.JSONParser;
import net.zffu.atlasplus.api.leveling.AtlasLeveling;

public class AtlasAPI {
	
	private String key;
	
	public AtlasAPI(String key) {
		this.key = key;
	}
	
	public void setKey(String key) {this.key = key;}
	
	
	public URL getRouteURL(String route) throws MalformedURLException {
		return new URL("https://api.the-atlas.net/" + route + "?key=" + this.key);
	}
	
	public URL getRouteURL(String route, String args) throws MalformedURLException {
		return new URL("https://api.the-atlas.net/" + route + "?key=" + this.key + args); 
	}
	
	
	
	
	public boolean isKeyValid() {
		try {
			URL url = this.getRouteURL("key/isvalid?");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			InputStream responseStream = con.getInputStream();
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject)jsonParser.parse(
			      new InputStreamReader(responseStream, "UTF-8"));
			return jsonObject.get("key-valid").getAsBoolean();
			
		} catch (IOException e) {
			return false;
		}
	}
	
	public int getPlayerLevel(String uuid) {
		try {
			URL url = this.getRouteURL("user/data", "&uuid=" + uuid);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			InputStream responseStream = con.getInputStream();
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject)jsonParser.parse(
			      new InputStreamReader(responseStream, "UTF-8"));
			int xp = jsonObject.get("experience").getAsInt();
			return AtlasLeveling.getLevelFromXP(xp);
		
		} catch (IOException e) {
			return 0;
		}
	}
	 
	
	
	
	
}
