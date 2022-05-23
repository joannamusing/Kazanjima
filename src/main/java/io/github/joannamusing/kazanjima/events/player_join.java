package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import io.github.joannamusing.kazanjima.data.setup;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class player_join implements Listener {
    setup alpha = new setup();
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
    @Subscribe(order = PostOrder.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event){
        //Check if the person connecting is a group leader.
        //If they are, set their timer to null.
    }
}
