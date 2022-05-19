package io.github.joannamusing.kazanjima.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class molten_pickaxe {

    public static ItemStack get(){
        ItemStack itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null) {
            itemMeta.setDisplayName(ChatColor.GOLD + "Molten Pickaxe");

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_RED + "Forged in the heart of a volcano.");
            itemMeta.setLore(lore);

            itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);

            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}
