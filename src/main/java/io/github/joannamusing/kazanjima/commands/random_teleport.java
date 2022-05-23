package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.util.utility;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class random_teleport implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.rtp")) {
                if(args.length == 0){
                    try {
                        Location location = utility.generateLocation(player);
                        player.teleport(location);
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }
        return true;
    }
}
