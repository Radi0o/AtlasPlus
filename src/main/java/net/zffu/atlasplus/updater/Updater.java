package net.zffu.atlasplus.updater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Updater {

	private String version;
	
	private boolean shouldUpdate;
	
	public Updater(String version) {
		this.version = version;
		
		try {
			URL url = new URL("https://zffu-api.vercel.app/api/atlasplus/version");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			InputStream responseStream = con.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			String ver = content.toString();
			
			if(this.version.equals(ver)) {
				this.shouldUpdate = false;
			}
			else {
				this.shouldUpdate = true;
			}
			
			
			
		} catch (IOException e) {
			
		}
		
	}
	
	public boolean shouldUpdate() {return this.shouldUpdate;}
	
	public String getVersion() {return this.version;}
	
}
