package io.github.joannamusing.kazanjima;

import io.github.joannamusing.kazanjima.commands.Feed;
import io.github.joannamusing.kazanjima.commands.Heal;
import io.github.joannamusing.kazanjima.commands.Suicide;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {
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
        this.getCommand("feed").setExecutor(new Feed());
        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("suicide").setExecutor(new Suicide());
        l.info("Commands have been registered.");
    }
    public void registerEvents(){

    }
}
