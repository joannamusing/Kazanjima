package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.data.player_setup;
import org.bukkit.Bukkit;
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
import java.math.BigDecimal;
import java.util.Objects;

public class home implements CommandExecutor {
    player_setup alpha = new player_setup();

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
                            String s = "homes.home." + args[0] + ".";
                            World world = Bukkit.getWorld(Objects.requireNonNull(fc.getString(s + "world")));
                            double x = fc.getDouble(s + "x");
                            double y = fc.getDouble(s + "y");
                            double z = fc.getDouble(s + "z");

                            //Pitch and Yaw are not working properly but the system does work...
                            BigDecimal tempPitch = BigDecimal.valueOf(fc.getDouble(s + "pitch"));
                            BigDecimal tempYaw = BigDecimal.valueOf(fc.getDouble(s + "yaw"));
                            float pitch = tempPitch.floatValue();
                            float yaw = tempYaw.floatValue();

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
