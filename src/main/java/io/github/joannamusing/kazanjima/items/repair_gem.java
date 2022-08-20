package io.github.joannamusing.kazanjima.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class repair_gem {
    public static ItemStack get(){
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null) {
            itemMeta.setDisplayName(ChatColor.AQUA + "Repair Gem");

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Right click with this to repair an item.");
            itemMeta.setLore(lore);

            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);

            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}
