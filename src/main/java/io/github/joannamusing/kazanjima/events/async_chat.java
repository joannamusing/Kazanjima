package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.Main;
import io.github.joannamusing.kazanjima.other.party;
import io.github.joannamusing.kazanjima.other.party_manager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class async_chat implements Listener {
    party_manager pm = new party_manager();
    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        party party = pm.getParty(player);
        String message = event.getMessage();
        FileConfiguration fc = Main.getInstance().getConfig();
        String prefix = fc.getString("party.prefix");
        player.sendMessage(prefix);
        //Prefix is currently null?
        if(prefix != null) {
            if (message.startsWith(prefix)) {
                player.sendMessage("prefix worked");
                if (party != null) {
                    //This will only return true if the player has party chat toggled on.
                    if (pm.getChatVisibility(player)) {
                        party.sendPartyMessage(player, event.toString());
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
