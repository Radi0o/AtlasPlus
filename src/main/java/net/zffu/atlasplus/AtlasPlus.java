package net.zffu.atlasplus;



import java.io.File;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.zffu.atlasplus.api.AtlasAPI;
import net.zffu.atlasplus.commands.TestCommand;
import net.zffu.atlasplus.commands.ViewNBTCommand;
import net.zffu.atlasplus.commands.itemsaver.LoadItemCommand;
import net.zffu.atlasplus.commands.itemsaver.SaveItemCommand;
import net.zffu.atlasplus.itemeditor.ItemEditor;
import net.zffu.atlasplus.itemeditor.listeners.ItemEditorClientTickEvent;
import net.zffu.atlasplus.itemhover.ItemHover;
import net.zffu.atlasplus.itemsaver.ItemSaver;
import net.zffu.atlasplus.levelhead.LevelHead;
import net.zffu.atlasplus.listener.PlayerJoinServerEvent;
import net.zffu.atlasplus.pastebin.PastebinAPI;
import net.zffu.atlasplus.updater.Updater;

@Mod(modid = AtlasPlus.MODID, version = AtlasPlus.VERSION)
public class AtlasPlus
{
    public static final String MODID = "atlasplus";
    public static final String VERSION = "1.0";
 
    private static AtlasPlus INSTANCE;
    
    private Configuration config;
    
    private AtlasAPI atlasapi;
    private PastebinAPI pastebinApi;
    
    private Updater updater;
    
    private ItemHover itemHover;
    
    private LevelHead levelHead;
    
    private ItemEditor itemEditor;
    
    private ItemSaver itemSaver;
    
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	this.INSTANCE = this;
    	
    	File folder = new File(Loader.instance().getConfigDir(), "atlasplus/");
    	
    	if(!folder.exists()) {
    		folder.mkdir();
    	}
    			
    			
    	
		File configFile = new File(Loader.instance().getConfigDir(), "atlasplus/config.cfg");
	    this.config = new Configuration(configFile);
	    config.load();
	    Property key = config.get("api", "key", "NONE");
	    
	    if(config.hasChanged()){
	       config.save();
	    } 
	    
	    this.atlasapi = new AtlasAPI(key.getString());
	    this.pastebinApi = new PastebinAPI();
	    
	    this.updater = new Updater(this.VERSION);
	    
	    this.itemHover = new ItemHover();
	    
	    this.levelHead = new LevelHead();
	    
	    this.itemEditor = new ItemEditor();
	    
	    this.itemSaver = new ItemSaver();
	    
	    ClientCommandHandler.instance.registerCommand(new ViewNBTCommand());
	    ClientCommandHandler.instance.registerCommand(new TestCommand());
	    ClientCommandHandler.instance.registerCommand(new SaveItemCommand());
	    ClientCommandHandler.instance.registerCommand(new LoadItemCommand());
	    
	    
	    MinecraftForge.EVENT_BUS.register(new PlayerJoinServerEvent());
	   // MinecraftForge.EVENT_BUS.register(new ClientChatEvent());
	   // MinecraftForge.EVENT_BUS.register(new ChatMessageEvent());
	    MinecraftForge.EVENT_BUS.register(new ItemEditorClientTickEvent());
	    
	    
	    
	    
    }
    
    
    public static AtlasPlus getInstance() {return INSTANCE;}
    public Configuration getConfig() {return this.config;}
    public AtlasAPI getAPI() {return this.atlasapi;}
    public ItemHover getItemHover() {return this.itemHover;}
    public Updater getUpdater() {return this.updater;}
    public PastebinAPI getPastebinAPI() {return this.pastebinApi;}
    public LevelHead getLevelHead() {return this.levelHead;}
    public ItemEditor getItemEditor() {return this.itemEditor;}
    public ItemSaver getItemSaver() {return this.itemSaver;}
}
