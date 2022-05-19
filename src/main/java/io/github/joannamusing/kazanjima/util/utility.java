package io.github.joannamusing.kazanjima.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class utility {

    //Checks if a string is an integer.
    public static boolean isInt(String string){
        try{
            Integer.parseInt(string);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    //Creates an ArrayList of all vanilla materials.
    public static ArrayList<Material> allMaterials(){
        return new ArrayList<>(Arrays.asList(Material.values()));
    }
    public static ArrayList<ItemStack> allItems(ArrayList<Material> materials){
        ArrayList<ItemStack> items = new ArrayList<>();
        for (Material material : materials) {
            ItemStack itemStack = new ItemStack(material);
            items.add(itemStack);
        }
        return items;
    }
    public static ArrayList<ItemMeta> allMetas(ArrayList<ItemStack> items) {
        ArrayList<ItemMeta> metas = new ArrayList<>();
        for (ItemStack item : items) {
            if(item.hasItemMeta()) {
                ItemMeta itemMeta = item.getItemMeta();
                metas.add(itemMeta);
            }
        }
        return metas;
    }
    public static ArrayList<String> allNames(ArrayList<ItemMeta> metas){
        ArrayList<String> names = new ArrayList<>();
        for(ItemMeta meta : metas){
            names.add(String.valueOf(meta.displayName()));
        }
        return names;
    }

}
