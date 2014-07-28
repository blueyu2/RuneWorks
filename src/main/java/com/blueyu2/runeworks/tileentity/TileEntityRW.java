package com.blueyu2.runeworks.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Blueyu2 on 7/12/2014.
 */
public class TileEntityRW extends TileEntity
{
    protected String customName;
    public static final String CUSTOM_NAME = "CustomName";

    public TileEntityRW()
    {
        customName = "";
    }

    public String getCustomName()
    {
        return customName;
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(TileEntityRW.CUSTOM_NAME))
        {
            this.customName = nbtTagCompound.getString(TileEntityRW.CUSTOM_NAME);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        if (this.hasCustomName())
        {
            nbtTagCompound.setString(TileEntityRW.CUSTOM_NAME, customName);
        }
    }

    public boolean hasCustomName()
    {
        return customName != null && customName.length() > 0;
    }
}
