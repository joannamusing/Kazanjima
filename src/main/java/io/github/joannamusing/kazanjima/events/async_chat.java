package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.other.party_manager;
import io.github.joannamusing.kazanjima.other.party;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class async_chat implements Listener {
    party_manager pm = new party_manager();
    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        party p = pm.getParty(player);
        //Party is currently null?!
        if (message.startsWith("@")) {
            if (p != null) {
                if (p.getChatVisibility(player)) {
                    player.sendMessage(message);
                }
            } else {
                player.sendMessage("You are not in a party!");
            }
        }
    }
}
