package io.github.joannamusing.kazanjima;

import io.github.joannamusing.kazanjima.commands.*;
import io.github.joannamusing.kazanjima.events.player_join;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class main extends JavaPlugin {
    private Logger l;
    @Override
    public void onEnable() {
        l = getLogger();

        registerCommands();
        registerEvents();
    }
    @Override
    public void onDisable() {
    }
    public void registerCommands(){
        this.getCommand("feed").setExecutor(new feed());
        this.getCommand("heal").setExecutor(new heal());
        this.getCommand("item").setExecutor(new item());
        this.getCommand("rtp").setExecutor(new random_teleport());
        this.getCommand("suicide").setExecutor(new suicide());
        l.info("Commands have been registered.");
    }
    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new player_join(), this);
        l.info("Events have been registered.");
    }
}
