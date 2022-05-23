package io.github.joannamusing.kazanjima.events;

import io.github.joannamusing.kazanjima.items.molten_pickaxe;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class block_break implements Listener {
    @EventHandler
    public void onEvent(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(molten_pickaxe.get())) {
            HashMap<Material, Material> drops = getDrops();
            if (drops.containsKey(block.getType())) {
                event.setDropItems(false);
                Material material = drops.get(block.getType());
                ItemStack itemStack = new ItemStack(material);
                Location location = event.getBlock().getLocation();
                location.getWorld().dropItemNaturally(location, itemStack);
            }
        }
    }
    public HashMap<Material, Material> getDrops(){
        HashMap<Material, Material> drops = new HashMap<>();
        drops.put(Material.COPPER_ORE, Material.COPPER_INGOT);
        drops.put(Material.DEEPSLATE_COPPER_ORE, Material.COPPER_INGOT);
        drops.put(Material.IRON_ORE, Material.IRON_INGOT);
        drops.put(Material.DEEPSLATE_IRON_ORE, Material.IRON_INGOT);
        drops.put(Material.GOLD_ORE, Material.GOLD_INGOT);
        drops.put(Material.DEEPSLATE_GOLD_ORE, Material.GOLD_INGOT);
        drops.put(Material.STONE, Material.STONE);
        return drops;
    }
}


