package com.blueyu2.runeworks.utility;

import com.blueyu2.runeworks.RuneWorks;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Blueyu2 on 7/14/2014.
 */
public class ResourceLocationHelper {
    public static ResourceLocation getResourceLocation(String modId, String path){
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path){
        return getResourceLocation(RuneWorks.MOD_ID.toLowerCase(), path);
    }
}
