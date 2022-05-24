package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import io.github.joannamusing.kazanjima.data.player_setup;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

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
            File file = alpha.getPlayerFile(player);
            FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
            if(fc.get("ip") != player.getServer().getIp()){
                int count = 0;
                for(String s : fc.getConfigurationSection("ip").getKeys(false)){
                    count++;
                }
                fc.set("ip." + count, player.getServer().getIp());
            }
        }
    }
    @Subscribe(order = PostOrder.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event){
        //Check if the person connecting is a group leader.
        //If they are, set their timer to null.
    }
}
