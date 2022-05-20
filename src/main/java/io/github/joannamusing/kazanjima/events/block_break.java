package io.github.joannamusing.kazanjima.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;

public class block_break implements Listener {
    @EventHandler
    public void onEvent(BlockBreakEvent event){

    }
    public ArrayList<Material> getBlocks (){
        ArrayList<Material> blocks = new ArrayList<>();
        blocks.add(Material.COPPER_ORE);
        blocks.add(Material.DEEPSLATE_COPPER_ORE);
        blocks.add(Material.IRON_ORE);
        blocks.add(Material.DEEPSLATE_IRON_ORE);
        blocks.add(Material.GOLD_ORE);
        blocks.add(Material.DEEPSLATE_GOLD_ORE);
        blocks.add(Material.STONE);

        return blocks;
    }
}


