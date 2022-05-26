package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.gui.party_gui;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class inventory_click implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getClickedInventory().equals(party_gui.getInventory())){
            ItemStack itemStack = event.getCurrentItem();
            event.setCancelled(true);
            if(event.isShiftClick() && event.isRightClick()){
                if(itemStack != null && itemStack.getItemMeta() != null) {
                    String playerName = itemStack.getItemMeta().getDisplayName();
                    for(Player target : Bukkit.getOnlinePlayers()){
                        if(target.getDisplayName().equalsIgnoreCase(playerName)){
                            //Kick member.
                        }
                    }
                }
            }else if(event.isShiftClick() && event.isLeftClick()){
                if(itemStack != null && itemStack.getItemMeta() != null) {
                    String playerName = itemStack.getItemMeta().getDisplayName();
                    for(Player target : Bukkit.getOnlinePlayers()){
                        if(target.getDisplayName().equalsIgnoreCase(playerName)){
                            //Promote to leader.
                        }
                    }
                }
            }//Check if the slot is equal to the chat sign, if it is, togglePartyChat.
        }
    }
}
