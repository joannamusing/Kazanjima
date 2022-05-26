package io.github.joannamusing.kazanjima.gui;

import io.github.joannamusing.kazanjima.other.party;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.UUID;

public class party_gui {
    //Create a new inventory.
    //Get the party members, and for each party member, make a player head object to display.
    //Return the inventory to the user.
    private final Player player;
    private final party p;
    private static Inventory inventory;
    private final ChatColor color1;
    private final ChatColor color2;

    public party_gui(Player player, party p){
        this.player = player;
        this.p = p;
        this.color1 = p.getColor1();
        this.color2 = p.getColor2();
    }

    public void openPartyGUI(){
        inventory = Bukkit.createInventory(player, (9 * 5), color1 + "" + ChatColor.BOLD + p.getPartyName().toUpperCase());

        //Our middle space at the bottom of the GUI we use to toggle chat.
        inventory.setItem(40, getSignage());

        for(int i = 0; i < p.getPartySize(); i++){
            UUID uuid = p.getPartyMembers().get(i);
            Player player = Bukkit.getPlayer(uuid);

            //Making a player head item to use for each group member.
            ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
            ArrayList<String> lore = new ArrayList<>();
            SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
            if(skullMeta != null && player != null) {
                //Checks if the current player in the loop is our leader, since leader UUID is returned on getUUID().
                if (p.getPartyUUID().equals(uuid)) {
                    skullMeta.setDisplayName(color1 + "" + ChatColor.ITALIC + player.getName());
                    lore.add(color1 + "Shift + Left Click to promote.");
                    lore.add(color1 + "Shift + Right Click to kick.");
                }else{
                    skullMeta.setDisplayName(color2 + "" + player.getName());
                }
                //This should set each head to be based on the member profiles.
                skullMeta.setOwnerProfile(player.getPlayerProfile());
                skullMeta.setLore(lore);
                itemStack.setItemMeta(skullMeta);
                //Hopefully this works to not overwrite the party chat spot and stuff.
                if(i == 36 || i == 40 || i == 44){
                    i++;
                }
                getInventory().setItem(i, itemStack);
                player.openInventory(inventory);
            }
        }

    }
    public Player getPlayer(){
        return player;
    }
    public static Inventory getInventory(){
        return inventory;
    }
    public ItemStack getSignage(){
        ItemStack itemStack = new ItemStack(Material.OAK_SIGN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null) {
            itemMeta.setDisplayName(color1 + "Toggle Party Chat");

            ArrayList<String> lore = new ArrayList<>();
            lore.add(color2 + "Click this sign to toggle party chat.");
            itemMeta.setLore(lore);

            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}
