package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.items.ender_bow;
import io.github.joannamusing.kazanjima.items.molten_pickaxe;
import io.github.joannamusing.kazanjima.util.utility;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class item implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
                if (player.hasPermission("kazanjima.commands.item")) {
                    if (args.length == 2) {
                        int amount = 1;
                        if (utility.isInt(args[1])) {
                            amount = Integer.parseInt(args[1]);
                        }
                        try {
                            for (int x = 0; x < amount; x++) {
                                ArrayList<String> itemNames = getItemNames(getItems());
                                for (int i = 0; i < itemNames.size(); i++) {
                                    if (args[0].equalsIgnoreCase(itemNames.get(i))) {
                                        player.getInventory().addItem(getItems().get(i));
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        return true;
    }
    public static ArrayList<ItemStack> getItems () {
        ArrayList<ItemStack> items = new ArrayList<>();
        /*
        for(Material material : Material.values()){
            items.add(new ItemStack(material));
        }
         */
        items.add(ender_bow.get());
        items.add(molten_pickaxe.get());
        return items;
    }
    public static ArrayList<String> getItemNames (ArrayList<ItemStack> items) {
        ArrayList<String> itemNames = new ArrayList<>();
        for (ItemStack item : items) {
            String tempName = item.getItemMeta().getDisplayName();
            tempName = ChatColor.stripColor(tempName);
            tempName = tempName.replace(" ", "_");
            itemNames.add(tempName);
        }
        return itemNames;
    }
}
