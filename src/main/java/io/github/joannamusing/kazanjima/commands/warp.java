package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.Main;
import io.github.joannamusing.kazanjima.data.setup;
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

public class warp implements CommandExecutor {
    setup alpha = new setup();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.warp")) {
                String path = Main.getInstance().getDataFolder().getPath();
                String fileName = "warp.yml";
                File file = alpha.getFile(path, fileName);
                FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
                if(args.length == 1){
                    for(String key : Objects.requireNonNull(fc.getConfigurationSection("warp")).getKeys(false)) {
                        if(args[0].equalsIgnoreCase(key)){
                            String s = "warp." + args[0] + ".";
                            World world = Bukkit.getWorld(Objects.requireNonNull(fc.getString(s + "world")));
                            double x = fc.getDouble(s + "x");
                            double y = fc.getDouble(s + "y");
                            double z = fc.getDouble(s + "z");

                            BigDecimal tempPitch = BigDecimal.valueOf(fc.getDouble(s + "pitch"));
                            BigDecimal tempYaw = BigDecimal.valueOf(fc.getDouble(s + "yaw"));
                            float pitch = tempPitch.floatValue();
                            float yaw = tempYaw.floatValue();

                            Location location = new Location(world, x, y, z, pitch, yaw);
                            player.teleport(location);
                            player.sendMessage("You have teleported to the warp.");
                        }else{
                            player.sendMessage("No warp found with that name.");
                        }
                    }
                }else{
                    player.sendMessage("/warp <name>");
                }
            }
        }
        return true;
    }
}
