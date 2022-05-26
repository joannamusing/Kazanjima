package io.github.joannamusing.kazanjima;

import io.github.joannamusing.kazanjima.commands.*;
import io.github.joannamusing.kazanjima.events.*;
import io.github.joannamusing.kazanjima.other.party_manager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    public static Main instance;
    public static Logger l;
    public party_manager pm;
    @Override
    public void onEnable() {
        instance = this;
        l = getLogger();

        saveDefaultConfig();

        registerCommands();
        registerEvents();

        pm = new party_manager();
    }
    @Override
    public void onDisable() {
    }
    public void registerCommands(){
        this.getCommand("delhome").setExecutor(new delete_home());
        this.getCommand("delwarp").setExecutor(new delete_warp());
        this.getCommand("feed").setExecutor(new feed());
        this.getCommand("heal").setExecutor(new heal());
        this.getCommand("home").setExecutor(new home());
        this.getCommand("item").setExecutor(new item());
        this.getCommand("party").setExecutor(new party_command());
        this.getCommand("rtp").setExecutor(new random_teleport());
        this.getCommand("sethome").setExecutor(new set_home());
        this.getCommand("setwarp").setExecutor(new set_warp());
        this.getCommand("suicide").setExecutor(new suicide());
        this.getCommand("warp").setExecutor(new warp());
        l.info("Commands have been registered.");
    }
    public void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new async_chat(), this);
        pm.registerEvents(new block_break(), this);
        pm.registerEvents(new inventory_click(), this);
        pm.registerEvents(new inventory_drag(), this);
        pm.registerEvents(new player_join(), this);
        pm.registerEvents(new player_quit(), this);
        pm.registerEvents(new projectile_hit(), this);
        l.info("Events have been registered.");
    }
    public static Main getInstance(){
        return instance;
    }
    public FileConfiguration getConfig(){
        return this.getConfig();
    }
    public party_manager getPartyManager(){
        return pm;
    }
}
