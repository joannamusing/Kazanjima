package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import org.bukkit.event.player.PlayerKickEvent;

public class player_kick {
    @Subscribe(order = PostOrder.NORMAL)
    public void onEvent(PlayerKickEvent event){
        //Check if the player is a group leader.
        //If they are, create a timer.
        //If timer gets to X, set new group leader.
        //  a. New group leader is based on time in group.
    }
}
