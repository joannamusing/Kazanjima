package io.github.joannamusing.kazanjima.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class random_teleport implements CommandExecutor {
    //This command crashes the server currently?!
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.rtp")) {
                Random random = new Random();
                int x = random.nextInt(1000);
                int z = random.nextInt(1000);
                int y = 50;
                World world = player.getWorld();
                Location location = new Location(world, x, y, z);
                while (!location.getBlock().getType().isAir()) {
                    y += 1;
                }
                player.teleport(location);
                player.sendMessage("You have teleported to a random location!");
            }
        }
        return true;
    }
}
