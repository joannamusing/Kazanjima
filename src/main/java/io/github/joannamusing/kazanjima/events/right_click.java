package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.data.player_setup;
import io.github.joannamusing.kazanjima.items.repair_gem;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;
import java.util.Objects;

public class right_click implements Listener {

    player_setup alpha = new player_setup();

    @EventHandler
    public void onEvent(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        //Add in a permission check if desired.
        File file = alpha.getPlayerFile(player);
        FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
        if(action == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                for (String key : Objects.requireNonNull(fc.getConfigurationSection("conditions.repairing")).getKeys(false)) {
                    if (key.equals("true")) {
                        player.getItemInHand().setDurability(player.getItemInHand().getType().getMaxDurability());
                    } else if (event.getItem().equals(repair_gem.get())) {
                        player.getInventory().removeItem(repair_gem.get());
                        fc.set("conditions.repairing", false);
                    }
                }
            }
        }
    }
}
