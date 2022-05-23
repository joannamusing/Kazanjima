package io.github.joannamusing.kazanjima.util;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
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
    public static void createClickableCommand(Player player, String message, String command){
        //Creates a new text component that will translate color code hopefully of our message.
        TextComponent component = new TextComponent(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', message)));
        component.setColor(ChatColor.GREEN);
        //Making our invite message hover on the screen.
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(message)));
        //Adding a click event to our amazing component. Command would be "party join" for our purposes.
        component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + command));
        player.spigot().sendMessage(component);
    }
}
