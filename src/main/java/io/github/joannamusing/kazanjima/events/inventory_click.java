package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.Main;
import io.github.joannamusing.kazanjima.gui.party_gui;
import io.github.joannamusing.kazanjima.other.Party;
import io.github.joannamusing.kazanjima.other.party_manager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class inventory_click implements Listener {
    private final Main plugin = Main.getInstance();

    party_manager pm = plugin.getPartyManager();

    /*
    This class is for handling interactions in the Party GUI. They should be able to toggle party chat,
    kick or promote players (if leader). Interfacing for secondary "page" is planned for parties over 35 members.
     */
    @EventHandler
    public void onEvent(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            Party p = pm.getParty(player);
            //This block will return the inventory the player is in, if it is one of the party GUIs.
            if (party_gui.getOpenInventories() != null) {
                if (party_gui.getOpenInventories().containsKey(player.getUniqueId())) {
                    party_gui partyGui = party_gui.getOpenInventories().get(player.getUniqueId());
                    for (Inventory i : partyGui.getInventories()) {
                        if (event.getInventory().equals(i)) {
                            event.setCancelled(true);
                        }
                        if (p != null) {
                            //player.sendMessage(String.valueOf(event.getSlot()));
                            int currentPage = partyGui.getCurrentPage();
                            int totalPages = partyGui.getInventories().size();
                            switch (event.getSlot()) {
                                case (45):
                                    if(currentPage > totalPages){
                                        currentPage -= 1;
                                        player.openInventory(partyGui.getInventories().get(currentPage));
                                    }else{
                                        player.sendMessage("No previous page.");
                                    }
                                    break;
                                case (48):
                                    p.togglePartyChat(player);
                                    break;
                                case (50):
                                    Bukkit.dispatchCommand(player, "party disband");
                                case (53):
                                    if(!(currentPage >= totalPages - 1)){
                                        currentPage += 1;
                                        player.openInventory(partyGui.getInventories().get(currentPage));
                                    }else{
                                        player.sendMessage("No next page.");
                                    }
                                    break;
                            }
                            if (event.getSlot() != 45 && event.getSlot() != 48 && event.getSlot() != 50 && event.getSlot() != 53) {
                                if (event.getCurrentItem() != null) {
                                    for (Player target : Bukkit.getOnlinePlayers()) {
                                        ItemStack itemStack = event.getCurrentItem();
                                        if (itemStack.getType().equals(Material.PLAYER_HEAD)) {
                                            SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
                                            if (skullMeta.hasOwner() && skullMeta.getOwningPlayer() != null) {
                                                Player t = skullMeta.getOwningPlayer().getPlayer();
                                                if (t != null) {
                                                    if (target.getName().equalsIgnoreCase(t.getName())) {
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
                }
            }
        }
    }
}

