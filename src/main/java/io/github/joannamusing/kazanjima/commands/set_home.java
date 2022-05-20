package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.data.setup;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class set_home implements CommandExecutor {
    setup alpha = new setup();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.sethome")) {
                if (args.length == 1) {
                    File file = alpha.getPlayerFile(player);
                    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
                    int maxHomes = fc.getInt("homes.max");
                    int totalHomes = fc.getInt("homes.total");
                    if (maxHomes <= totalHomes) {
                        player.sendMessage("You have set your maximum amount of homes.");
                    } else {
                        Location location = player.getLocation();
                        String world = player.getWorld().getName();
                        double x = location.getX();
                        double y = location.getY();
                        double z = location.getZ();
                        float pitch = location.getPitch();
                        float yaw = location.getYaw();

                        fc.createSection("homes.home."+ args[0] + ".world");
                        fc.createSection("homes.home." + args[0] + ".x");
                        fc.createSection("homes.home." + args[0] + ".y");
                        fc.createSection("homes.home." + args[0] + ".z");
                        fc.createSection("homes.home." + args[0] + ".pitch");
                        fc.createSection("homes.home." + args[0] + ".yaw");

                        fc.set("homes.home." + args[0] + ".world", world);
                        fc.set("homes.home." + args[0] + ".x", x);
                        fc.set("homes.home." + args[0] + ".y", y);
                        fc.set("homes.home." + args[0] + ".z", z);
                        fc.set("homes.home." + args[0] + ".pitch", pitch);
                        fc.set("homes.home." + args[0] + ".yaw", yaw);

                        player.sendMessage("You have set the home: " + args[0] + "!");
                        totalHomes += 1;
                        fc.set("homes.total", totalHomes);
                        try {
                            fc.save(file);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }else{
                    player.sendMessage("/sethome <name>");
                }
            }
        }
        return true;
    }
}
