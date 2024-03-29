package io.github.joannamusing.kazanjima.data;

import io.github.joannamusing.kazanjima.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class player_setup {
    setup files = new setup();
    File folder = new File(Main.getInstance().getDataFolder().toString());
    File path = new File(folder + "\\player-data");
    File file;
    FileConfiguration fc;

    public File getPlayerFile(Player player){
        String uuid = player.getUniqueId().toString();
        file = new File(path + "\\" + uuid + ".yml");
        return file;

    }
    public void setupPlayerFile(Player player){
        String name = player.getName();
        String uuid = player.getUniqueId().toString();
        String ip = player.getServer().getIp();

        file = new File(path + "\\" + uuid + ".yml");
        fc = YamlConfiguration.loadConfiguration(file);
        if(!file.exists()){
            try {
                file.createNewFile();

                fc.createSection("username");
                fc.set("username", name);

                fc.createSection("uuid");
                fc.set("uuid", uuid);

                fc.createSection("ip.original");
                fc.set("ip.original", ip);

                fc.createSection("ranks");
                fc.set("ranks", "default");

                fc.createSection("homes.max");
                fc.set("homes.max", 2); //Default value, pull from config.yml later for user friendly.
                fc.createSection("homes.total");
                fc.set("homes.total", 0);

                fc.createSection("conditions.repairing");
                fc.set("conditions.repairing", true);

                fc.save(file);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
