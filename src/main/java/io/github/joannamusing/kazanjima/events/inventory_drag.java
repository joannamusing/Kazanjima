package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.gui.party_gui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

public class inventory_drag implements Listener {
    @EventHandler
    public void onDrag(InventoryDragEvent event){
        if(event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (party_gui.getOpenInventories() != null) {
                if (party_gui.getOpenInventories().containsKey(player.getUniqueId())) {
                    party_gui partyGui = party_gui.getOpenInventories().get(player.getUniqueId());
                    for (Inventory i : partyGui.getInventories()) {
                        if (event.getInventory().equals(i)) {
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}
