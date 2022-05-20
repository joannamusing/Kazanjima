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
    public File getFile(Player player){
        String uuid = player.getUniqueId().toString();
        file = new File(path + "\\" + uuid + ".yml");
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

                fc.save(file);
            }catch(IOException e){
                e.printStackTrace();
            }
        }




    }
}
