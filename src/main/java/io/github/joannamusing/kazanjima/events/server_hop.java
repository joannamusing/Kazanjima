package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerConnectedEvent;
import com.velocitypowered.api.proxy.Player;
import io.github.joannamusing.kazanjima.Main;
import io.github.joannamusing.kazanjima.other.party;
import io.github.joannamusing.kazanjima.other.party_manager;
import org.bukkit.Server;
import org.jetbrains.annotations.NotNull;

public class server_hop {
    private Main plugin = Main.getInstance();
    private party_manager pm = plugin.getPartyManager();

    @Subscribe(order = PostOrder.NORMAL)
    public void onServerHop(ServerConnectedEvent event){
        Player player = event.getPlayer();
        party p = pm.getParty((org.bukkit.entity.Player) player);
        if(p != null){
            @NotNull Server targetServer = ((org.bukkit.entity.Player) player).getServer();
            System.out.println(targetServer);
        }
        //Check which server they are trying to connect to.
        //Get the available player slots.
        //Compare to members.size().
        //If enough slots, hop people.
        //If not enough slots, don't hop leader.
    }
}
