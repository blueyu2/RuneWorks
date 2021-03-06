package com.blueyu2.runeworks.handler;

import com.blueyu2.runeworks.RuneWorks;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Blueyu2 on 6/30/2014.
 */
public class ConfigurationHandler {
    public static Configuration configuration;
    public static boolean testValue = false;
    public static void init(File configFile){
        //Create the configuration object from the given configuration file
        if(configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(RuneWorks.MOD_ID)){
            loadConfiguration();
        }
    }
    private static void loadConfiguration(){
        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example configuration value.");
        if(configuration.hasChanged()){
            configuration.save();
        }
    }
}
