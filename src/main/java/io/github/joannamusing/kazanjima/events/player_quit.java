package io.github.joannamusing.kazanjima.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class player_quit implements Listener {
    @EventHandler
    public void onEvent(PlayerQuitEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Come back soon!");
    }
}
