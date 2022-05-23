package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerPreConnectEvent;

public class server_hop {
    @Subscribe(order = PostOrder.NORMAL)
    public void onServerHop(ServerPreConnectEvent event){
        //Check which server they are trying to connect to.
        //Get the available player slots.
        //Compare to members.size().
        //If enough slots, hop people.
        //If not enough slots, don't hop leader.
    }
}
