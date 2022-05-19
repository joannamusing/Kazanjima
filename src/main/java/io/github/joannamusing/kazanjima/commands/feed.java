package io.github.joannamusing.kazanjima.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class feed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("kazanjima.commands.feed")){
                player.setFoodLevel(20); //Change to default maximum value.
                player.sendMessage("You have been fed!");
            }
        }
        return false;
    }
}
