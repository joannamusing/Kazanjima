package io.github.joannamusing.kazanjima.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("kazanjima.commands.heal")){
                player.setHealth(20);
                player.sendMessage("You have been healed!");
            }else{
                player.sendMessage("Kazanjima: Missing permissions \"kazanjima.commands.heal\"!");
            }
        }
        return false;
    }
}
