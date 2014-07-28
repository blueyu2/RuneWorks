package com.blueyu2.runeworks.client.gui;

import com.blueyu2.runeworks.RuneWorks;
import com.blueyu2.runeworks.handler.ConfigurationHandler;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.List;

/**
 * Created by Blueyu2 on 7/9/2014.
 */
public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                RuneWorks.MOD_ID,
                false,
                false,
                //Makes the mods config gui name the path to the config file
                /*GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString())*/
                RuneWorks.MOD_NAME + " Configuration");
    }
}
