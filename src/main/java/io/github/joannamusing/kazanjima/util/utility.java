package io.github.joannamusing.kazanjima.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
    public static int getTotal(Player player,  Material material){
        int total = 0;
        Inventory items = player.getInventory();
        for(ItemStack item : items){
            if(item != null){
                if(item.getType() == material){
                    total += item.getAmount();
                }
            }
        }
        return total;
    }
    public static void addItem(Player player, Material material, int amount){
        ItemStack itemStack = new ItemStack(material, amount);
        if(player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(itemStack);
        }else{
            player.getLocation().getWorld().dropItemNaturally(player.getLocation(), itemStack);
        }}
    public static void removeItem(Player player, Material material, int amount){
        Inventory items = player.getInventory();
        int total = getTotal(player, material);
        if(total >= amount) {
            for (ItemStack item : items) {
                if (item != null) {
                    if (item.getType() == material) {
                        int x = item.getAmount();
                        if (amount > x) {
                            amount -= x;
                            item.setAmount(0);
                        } else {
                            x -= amount;
                            item.setAmount(x);
                            return;
                        }}}}}}
}
