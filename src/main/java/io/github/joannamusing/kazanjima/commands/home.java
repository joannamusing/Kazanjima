package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.data.setup;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Objects;

public class home implements CommandExecutor {
    setup alpha = new setup();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.home")) {
                File file = alpha.getPlayerFile(player);
                FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
                if(args.length == 1){
                    for(String key : Objects.requireNonNull(fc.getConfigurationSection("homes.home")).getKeys(false)) {
                        if(args[0].equalsIgnoreCase(key)){
                            World world = (World) fc.get("homes.home" + args[0] + ".world");
                            double x = (double) fc.get("homes.home." + args[0] + ".x");
                            double y = (double) fc.get("homes.home." + args[0] + ".y");
                            double z = (double) fc.get("homes.home." + args[0] + ".z");
                            float pitch = (float) fc.get("homes.home." + args[0] + ".pitch");
                            float yaw = (float) fc.get("homes.home." + args[0] + ".yaw");

                            Location location = new Location(world, x, y, z, pitch, yaw);
                            player.teleport(location);
                            player.sendMessage("You have teleported home.");
                        }else{
                            player.sendMessage("No home found with that name.");
                        }
                    }
                }else{
                    player.sendMessage("/home <name>");
                }
            }
        }
        return true;
    }
}
