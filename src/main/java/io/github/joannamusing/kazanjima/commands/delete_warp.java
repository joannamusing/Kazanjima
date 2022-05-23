package io.github.joannamusing.kazanjima.commands;

import io.github.joannamusing.kazanjima.Main;
import io.github.joannamusing.kazanjima.data.setup;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class delete_warp implements CommandExecutor {
    setup alpha = new setup();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.delwarp")) {
                String path = Main.getInstance().getDataFolder().getPath();
                String fileName = "warp.yml";
                File file = alpha.getFile(path, fileName);
                FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
                if(args.length == 1){
                    String s = "warp." + args[0];
                    if (fc.isConfigurationSection(s)) {
                        fc.set(s, null);
                        player.sendMessage("Warp removed.");
                        setup.saveFile(file, fc);
                    }else{
                        player.sendMessage("No warp with that name found.");
                    }
                }
            }
        }
        return true;
    }
}
