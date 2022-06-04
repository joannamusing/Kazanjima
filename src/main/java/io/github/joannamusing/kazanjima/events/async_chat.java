package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.Main;
import io.github.joannamusing.kazanjima.other.Party;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class async_chat implements Listener {
    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        Party p = plugin.getPartyManager().getParty(player);
        if (message.startsWith("@")) {
            if (p != null) {
                if (p.getChatVisibility(player)) {
                    p.sendPartyMessage(player, message);
                    event.setCancelled(true);
                }
            } else {
                player.sendMessage("You are not in a party!");
            }
        }
        String default_rank = (String) plugin.getConfig().get("default-rank");

    }
}
