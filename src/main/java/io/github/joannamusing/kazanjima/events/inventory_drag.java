package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.gui.party_gui;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class inventory_drag implements Listener {
    @EventHandler
    public void onDrag(InventoryDragEvent event){
        if(event.getInventory().equals(party_gui.getInventory())) {
            event.setCancelled(true);
        }
    }
}
