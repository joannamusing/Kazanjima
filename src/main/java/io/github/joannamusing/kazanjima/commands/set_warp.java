package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.Main;
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

public class set_warp implements CommandExecutor {
    setup alpha = new setup();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.setwarp")) {
                if (args.length == 1) {
                    String path = Main.getInstance().getDataFolder().getPath();
                    String fileName = "warp.yml";
                    alpha.setupFile(path, fileName);
                    File file = alpha.getFile(path, "warp.yml");
                    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);

                    Location location = player.getLocation();
                    String world = player.getWorld().getName();
                    double x = location.getX();
                    double y = location.getY();
                    double z = location.getZ();
                    float pitch = location.getPitch();
                    float yaw = location.getYaw();

                    String s = "warp." + args[0];
                    if (fc.isConfigurationSection(s)) {
                        player.sendMessage("A warp with that name already exists.");
                    } else {
                        fc.createSection(s + ".world");
                        fc.createSection(s + ".x");
                        fc.createSection(s + ".y");
                        fc.createSection(s + ".z");
                        fc.createSection(s + ".pitch");
                        fc.createSection(s + ".yaw");

                        fc.set(s + ".world", world);
                        fc.set(s + ".x", x);
                        fc.set(s + ".y", y);
                        fc.set(s + ".z", z);
                        fc.set(s + ".pitch", pitch);
                        fc.set(s + ".yaw", yaw);

                        player.sendMessage("You have set the warp: " + args[0] + "!");
                        alpha.saveFile(file, fc);
                    }
                }
            }
        }
        return true;
    }
}
