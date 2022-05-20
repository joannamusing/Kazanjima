package io.github.joannamusing.kazanjima.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ender_bow {
    public static ItemStack get(){
        ItemStack itemStack = new ItemStack(Material.BOW);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null) {
            itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Ender Bow");

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.LIGHT_PURPLE + "A legendary weapon used by the Ender Queen.");
            itemMeta.setLore(lore);

            itemMeta.addEnchant(Enchantment.DURABILITY, 5, true);

            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}
