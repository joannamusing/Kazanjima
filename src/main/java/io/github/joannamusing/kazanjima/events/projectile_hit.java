package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.items.ender_bow;
import io.github.joannamusing.kazanjima.util.utility;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class projectile_hit implements Listener {
    @EventHandler
    public void onEvent(ProjectileHitEvent event){
        if(event.getEntity() instanceof Arrow){
            if(event.getEntity().getShooter() instanceof Player) {
                Player player = (Player) event.getEntity().getShooter();
                //Reminder to figure out how to check durability when comparing items.
                if (player.getInventory().getItemInMainHand().isSimilar(ender_bow.get())) {
                    Material material = Material.ENDER_PEARL;
                    int amount = 1;
                    int total = utility.getTotal(player, material);
                    if(total >= amount) {
                        utility.removeItem(player, material, amount);
                        Location location = event.getEntity().getLocation();
                        player.teleport(location);
                    }else{
                        player.sendMessage("This ability requires [" + amount + "] [" + material + "].");
                    }
                }
            }
        }
    }
}
