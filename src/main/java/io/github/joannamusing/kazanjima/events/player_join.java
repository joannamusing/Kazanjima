package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.data.player_setup;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class player_join implements Listener {
    player_setup alpha = new player_setup();
    @EventHandler
    public void onEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String name = player.getName();
        if(!player.hasPlayedBefore()){
            player.sendMessage("Welcome to the server, " + name + "!");
            alpha.setupPlayerFile(player);
        }else{
            player.sendMessage("Welcome back, " + name + "!");
        }
    }
}
