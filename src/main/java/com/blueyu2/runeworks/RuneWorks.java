package com.blueyu2.runeworks;

import com.blueyu2.runeworks.handler.ConfigurationHandler;
import com.blueyu2.runeworks.handler.GuiHandler;
import com.blueyu2.runeworks.init.ModBlocks;
import com.blueyu2.runeworks.init.ModItems;
import com.blueyu2.runeworks.init.Recipes;
import com.blueyu2.runeworks.proxy.IProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * Created by Blueyu2 on 7/27/2014.
 */
@Mod(modid = RuneWorks.MOD_ID, name = RuneWorks.MOD_NAME, version = RuneWorks.VERSION)
public class RuneWorks {
    public static final String MOD_ID = "runeworks";
    public static final String MOD_NAME = "RuneWorks";
    public static final String VERSION = "1.7.10-1.0";
    public static final String CLIENT_PROXY_CLASS = "com.blueyu2.runeworks.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.blueyu2.runeworks.proxy.ServerProxy";
    public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ":";

    @Mod.Instance(RuneWorks.MOD_ID)
    public static RuneWorks instance;

    @SidedProxy(clientSide = RuneWorks.CLIENT_PROXY_CLASS, serverSide = RuneWorks.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        proxy.registerTileEntities();
        Recipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
