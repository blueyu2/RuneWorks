package com.blueyu2.runeworks.item;

import com.blueyu2.runeworks.RuneWorks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Blueyu2 on 7/10/2014.
 */
public class ItemRW extends Item {
    public ItemRW(){
        super();
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    @Override
    public String getUnlocalizedName(){
        return String.format("item.%s%s", RuneWorks.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

    }
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", RuneWorks.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
