package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
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
    @Subscribe(order = PostOrder.NORMAL)
    public void onPlayerQuit(PlayerQuitEvent event){
        //Check if the player is a group leader.
        //If they are, create a timer.
        //If timer gets to X, set new group leader.
        //  a. New group leader is based on time in group.
    }
}
