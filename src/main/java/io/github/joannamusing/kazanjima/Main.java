package io.github.joannamusing.kazanjima;

import io.github.joannamusing.kazanjima.commands.*;
import io.github.joannamusing.kazanjima.events.block_break;
import io.github.joannamusing.kazanjima.events.player_join;
import io.github.joannamusing.kazanjima.events.player_quit;
import io.github.joannamusing.kazanjima.events.projectile_hit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    public static Main instance;
    public static Logger l;
    @Override
    public void onEnable() {
        instance = this;
        l = getLogger();

        registerCommands();
        registerEvents();
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
        this.getCommand("rtp").setExecutor(new random_teleport());
        this.getCommand("sethome").setExecutor(new set_home());
        this.getCommand("setwarp").setExecutor(new set_warp());
        this.getCommand("suicide").setExecutor(new suicide());
        this.getCommand("warp").setExecutor(new warp());
        l.info("Commands have been registered.");
    }
    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new block_break(), this);
        getServer().getPluginManager().registerEvents(new player_join(), this);
        getServer().getPluginManager().registerEvents(new player_quit(), this);
        getServer().getPluginManager().registerEvents(new projectile_hit(), this);
        l.info("Events have been registered.");
    }
    public static Main getInstance(){
        return instance;
    }
}
