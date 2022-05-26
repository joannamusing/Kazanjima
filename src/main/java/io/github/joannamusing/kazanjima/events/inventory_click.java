package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.Main;
import io.github.joannamusing.kazanjima.gui.party_gui;
import io.github.joannamusing.kazanjima.other.party;
import io.github.joannamusing.kazanjima.other.party_manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class inventory_click implements Listener {
    private final Main plugin = Main.getInstance();

    party_manager pm = plugin.getPartyManager();

    /*
    This class is for handling interactions in the Party GUI. They should be able to toggle party chat,
    kick or promote players (if leader). Interfacing for secondary "page" is planned for parties over 35 members.
     */
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (Objects.equals(event.getClickedInventory(), party_gui.getInventory())) {
            if(event.getWhoClicked() instanceof Player) {
                Player player = (Player) event.getWhoClicked();
                party p = pm.getParty(player);
                event.setCancelled(true);
                if (p != null) {
                    switch (event.getSlot()) {
                        case (36):
                            System.out.print("001: Set up previous page for Party GUI.");
                            break;
                        case (40):
                            p.togglePartyChat(player);
                            break;
                        case (44):
                            System.out.print("002: Set up next page for Party GUI.");
                            break;
                    }
                    if (event.getSlot() != 36 && event.getSlot() != 40 && event.getSlot() != 44) {
                        if(event.getCurrentItem() != null) {
                            for (Player target : Bukkit.getOnlinePlayers()) {
                                if (target.getName().equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                                    player.sendMessage("We made it here!"); //This is where the code fails.
                                    if (event.isShiftClick() && event.isRightClick()) {
                                        Bukkit.dispatchCommand(player, "party kick " + target.getName());
                                    } else if (event.isShiftClick() && event.isLeftClick()) {
                                        Bukkit.dispatchCommand(player, "party promote " + target.getName());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

