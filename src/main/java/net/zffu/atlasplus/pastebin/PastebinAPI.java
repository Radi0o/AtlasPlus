package net.zffu.atlasplus.pastebin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.json.simple.parser.ParseException;

import net.zffu.atlasplus.AtlasPlus;

public class PastebinAPI {

	private String token;
	
	public PastebinAPI() {
		this.token = "sbcARpqzVTvBluQVuFHWpFDZDutqFA9n";
	}
	
	public String createPastebin(String content) {
		try {
			AtlasPlus.getInstance().getItemHover().setIsSendingRequest(true);
		    URL url = new URL("https://pastebin.com/api/api_post.php");
		    URLConnection con = url.openConnection();
		    HttpURLConnection http = (HttpURLConnection)con;
		    http.setRequestMethod("POST");
		    http.setDoOutput(true);
		    http.setDoInput(true);
		    Map<String,String> arguments = new HashMap<>();
		    arguments.put("api_option", "paste");
		    arguments.put("api_dev_key", this.token);
		    arguments.put("api_paste_code", content);
		    arguments.put("api_paste_private", "1");
		    
		    // ...

		    StringJoiner sj = new StringJoiner("&");
		    for(Map.Entry<String,String> entry : arguments.entrySet())
		        sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
		                + URLEncoder.encode(entry.getValue(), "UTF-8"));
		    byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		    int length = out.length;
		    http.setFixedLengthStreamingMode(length);
		    http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		    http.connect();
		    OutputStream os = http.getOutputStream();
		    os.write(out);
		    InputStream is = http.getInputStream();
		    String text = new BufferedReader(new InputStreamReader(is,StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
		    AtlasPlus.getInstance().getItemHover().setIsSendingRequest(false);
		    return text;
		} catch (IOException urlException) {
		    urlException.printStackTrace();
		    AtlasPlus.getInstance().getItemHover().setIsSendingRequest(false);
		    
		   
		    
		    return "ERROR";
		}
	}
	
	public String getPastebin(String pastebin) {
		try {
		    URL url = new URL("https://pastebin.com/raw/" + pastebin);
		    URLConnection con = url.openConnection();
		    HttpURLConnection http = (HttpURLConnection)con;
		    http.setRequestMethod("POST");
		    http.setDoOutput(true);
		    http.setDoInput(true);
	
		    // Repeat this for for all required API arguments
		    // ...

		    
		   
		    
		    http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		    http.connect();
		    OutputStream os = http.getOutputStream();
		    
		    InputStream is = http.getInputStream();
		    String text = new BufferedReader(new InputStreamReader(is,StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
		    return text;
		} catch (IOException urlException) {
		    urlException.printStackTrace();
		    return null;
		}
	}
	
}
