package io.github.joannamusing.kazanjima.commands;

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
    setup alpha = new setup();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.delhome")) {
                File file = alpha.getPlayerFile(player);
                FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
                //set section to null to remove along with subsections of that section.

            }
        }
        return true;
    }
}
