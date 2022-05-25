package io.github.joannamusing.kazanjima.gui;

import io.github.joannamusing.kazanjima.other.party;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class party_gui {
    //Create a new inventory.
    //Get the party members, and for each party member, make a player head object to display.
    //Return the inventory to the user.
    private Player player;
    private party party;
    private Inventory inventory;

    public party_gui(Player player, party party){
        this.player = player;
        this.party = party;
    }

    public void openPartyGUI(){
        inventory = Bukkit.createInventory(player, (9 * 5), party.getPartyName());

        for(int i = 0; i < party.getPartySize(); i++){
            UUID uuid = party.getPartyMembers().get(i);
            Player player = Bukkit.getPlayer(uuid);

            //Making a player head item to use for each group member.
            ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
            //Apparently we have to use SkullMeta for this part; Source: Google.
            SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
            if(skullMeta != null && player != null) {
                //Checks if the current player in the loop is our leader, since leader UUID is returned on getUUID().
                if (party.getPartyUUID().equals(uuid)) {
                    skullMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + player.getName());
                }else{
                    skullMeta.setDisplayName(ChatColor.DARK_AQUA + "" + player.getName());
                }
                //This should set each head to be based on the member profiles.
                skullMeta.setOwnerProfile(player.getPlayerProfile());
                itemStack.setItemMeta(skullMeta);
                //Hopefully this works?!
                getInventory().setItem(i, itemStack);
            }
        }
    }
    public Player getPlayer(){
        return player;
    }
    public party getGroup(){
        return party;
    }
    public Inventory getInventory(){
        return inventory;
    }
}
