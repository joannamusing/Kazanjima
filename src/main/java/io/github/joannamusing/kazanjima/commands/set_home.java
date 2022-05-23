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
                        //This is where we declare the path in the player files all homes will take.
                        String s = "homes.home." + args[0];
                        if (fc.isConfigurationSection(s)) {
                            player.sendMessage("A home with that name already exists.");
                        } else {
                            //We create a new section in the player file for our home coordinates.
                            fc.createSection(s + ".world");
                            fc.createSection(s + ".x");
                            fc.createSection(s + ".y");
                            fc.createSection(s + ".z");
                            fc.createSection(s + ".pitch");
                            fc.createSection(s + ".yaw");
                            //We then set those sections to the value of the location.
                            fc.set(s + ".world", world);
                            fc.set(s + ".x", x);
                            fc.set(s + ".y", y);
                            fc.set(s + ".z", z);
                            fc.set(s + ".pitch", pitch);
                            fc.set(s + ".yaw", yaw);

                            player.sendMessage("You have set the home: " + args[0] + "!");
                            //Got to make sure we increase the total amount of homes the player has set.
                            totalHomes += 1;
                            fc.set("homes.total", totalHomes);
                            setup.saveFile(file, fc);
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
