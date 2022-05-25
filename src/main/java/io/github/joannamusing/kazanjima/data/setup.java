package io.github.joannamusing.kazanjima.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class setup {

    File file;
    FileConfiguration fc;

    public void setupFile(String path, String fileName){
        file = new File(path, fileName);
        fc = YamlConfiguration.loadConfiguration(file);
        if(!file.exists()){
            try{
                file.mkdir();
                file.createNewFile();
                fc.save(file);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public File getFile(String path, String name){
        file = new File(path, name);
        return file;
    }
    public void saveFile(File file, FileConfiguration fileConfiguration){
        try{
            fileConfiguration.save(file);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
