package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.util.utility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class player_join implements Listener {
    @EventHandler
    public void onEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String name = player.getName();
        if(!player.hasPlayedBefore()){
            player.sendMessage("Welcome to the server, " + name + "!");
        }else{
            player.sendMessage("Welcome back, " + name + "!");
        }
    }
}
