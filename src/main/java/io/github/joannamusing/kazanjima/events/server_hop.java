package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerConnectedEvent;
import com.velocitypowered.api.proxy.Player;
import io.github.joannamusing.kazanjima.Main;
import io.github.joannamusing.kazanjima.data.plugin_message;
import io.github.joannamusing.kazanjima.other.party;
import io.github.joannamusing.kazanjima.other.party_manager;
import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.util.UUID;

public class server_hop {
    private final Main plugin = Main.getInstance();
    private final party_manager pm = plugin.getPartyManager();

    @Subscribe(order = PostOrder.NORMAL)
    public void onServerHop(ServerConnectedEvent event){
        Player player = event.getPlayer();
        party p = pm.getParty((org.bukkit.entity.Player) player);
        if(p != null){
            Server server = (Server) event.getServer();
            int maximumPlayers = server.getMaxPlayers();
            int currentPlayers = server.getOnlinePlayers().size();
            int partySize = p.getPartySize();
            if(currentPlayers <= maximumPlayers - partySize){
                //Then we have enough space for the party members.
                for(UUID uuid : p.getPartyMembers()){
                    Player target = (Player) Bukkit.getPlayer(uuid);
                    try{
                        assert target != null;
                        plugin_message.connectPlayer((org.bukkit.entity.Player) target, server.getName());
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
