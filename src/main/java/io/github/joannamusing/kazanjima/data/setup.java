package io.github.joannamusing.kazanjima.data;

import io.github.joannamusing.kazanjima.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class setup{
    File folder = new File(Main.getInstance().getDataFolder().toString());
    File path = new File(folder + "\\player-data");
    File file;
    FileConfiguration fc;

    public void setupDirectory() {
        if (!folder.exists()) {
            folder.mkdir();
        }
        if (!path.exists()) {
            path.mkdir();
        }
    }
    public File getPlayerFile(Player player){
        String uuid = player.getUniqueId().toString();
        file = new File(path + "\\" + uuid + ".yml");
        return file;

    }
    public File getFile(String path, String name){
        file = new File(path, name);
        return file;
    }
    public void writeFile(Player player, String path, String value){

    }
    public void saveFile(Player player){

    }
    public void setupPlayerFile(Player player){
        String name = player.getName();
        String uuid = player.getUniqueId().toString();

        file = new File(path + "\\" + uuid + ".yml");
        fc = YamlConfiguration.loadConfiguration(file);
        setupDirectory();
        if(!file.exists()){
            try {
                file.createNewFile();

                fc.createSection("username");
                fc.set("username", name);

                fc.createSection("uuid");
                fc.set("uuid", uuid);

                fc.createSection("homes.max");
                fc.set("homes.max", 1); //Default value, pull from config.yml later for user friendly.
                fc.createSection("homes.total");
                fc.set("homes.total", 0);

                fc.save(file);
            }catch(IOException e){
                e.printStackTrace();
            }
        }




    }
}
