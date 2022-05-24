package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.data.player_setup;
import io.github.joannamusing.kazanjima.data.setup;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class delete_home implements CommandExecutor {
    player_setup alpha = new player_setup();
    setup beta = new setup();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.delhome")) {
                File file = alpha.getPlayerFile(player);
                FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
                int totalHomes = fc.getInt("homes.total");
                if(args.length == 1){
                    String s = "homes.home." + args[0];
                    if (fc.isConfigurationSection(s)) {
                        fc.set(s, null);
                        totalHomes -= 1;
                        fc.set("homes.total", totalHomes);
                        player.sendMessage("Home removed.");
                        beta.saveFile(file, fc);
                    }else{
                        player.sendMessage("No home with that name found.");
                    }
                }
            }
        }
        return true;
    }
}
