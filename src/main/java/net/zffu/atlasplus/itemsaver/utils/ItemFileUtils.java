package net.zffu.atlasplus.itemsaver.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minecraft.util.StringUtils;
import net.minecraftforge.fml.common.Loader;
import net.zffu.atlasplus.itemeditor.EditedItem;

public class ItemFileUtils {

	public static void createItemFile(String itemName, JSONObject jsonObject) {
		
		File folder = new File(Loader.instance().getConfigDir(), "atlasplus/saveditems/"); 
		if(!folder.exists()) {
			folder.mkdir();
		}
		
		
		File file = new File(Loader.instance().getConfigDir(), "atlasplus/saveditems/" + itemName + ".json");
		FileWriter jsonFile;
		try {
			jsonFile = new FileWriter(file);
			jsonFile.write(jsonObject.toJSONString());
			jsonFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static EditedItem loadItemFile(String itemName) throws IOException, ParseException {
		File file = new File(Loader.instance().getConfigDir(), "atlasplus/saveditems/" + itemName + ".json");
		JSONParser jsonParser = new JSONParser();
        
        FileReader reader = new FileReader(file);
        Object obj = jsonParser.parse(reader);
        
        JSONObject json = (JSONObject) obj;
        String display = (String) json.get("display_name");
        display = display.replaceAll("§", "&");
        display = display.replaceAll("\\u00A7", "&");
        ArrayList<String> lore = new ArrayList<>();
        for(Object line : (JSONArray) json.get("lore")) {
        	String lline = (String) line;
        	lline = lline.replaceAll("§", "&");
        	lline = lline.replaceAll("\\u00A7", "&");
        	lore.add(lline);
        }
        
        return new EditedItem(lore, display);

	}
	
	
}
