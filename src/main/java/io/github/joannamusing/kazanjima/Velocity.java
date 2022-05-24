package io.github.joannamusing.kazanjima;

import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import io.github.joannamusing.kazanjima.commands.party;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(id = "kazanjima", name = "Kazanjima", version = "1.0.0", url = "https://github.com/joannamusing/kazanjima",
        description = "[DESCRIPTION]", authors = {"joannamusing"})
public class Velocity {

    private final ProxyServer proxyServer;
    private final Logger logger;
    private final Path path;

    @Inject
    public Velocity(ProxyServer proxyServer, Logger logger, @DataDirectory Path path){
        this.proxyServer = proxyServer;
        this.logger = logger;
        this.path = path;

        logger.info("[Kazanjima]: Enabled Velocity.");
    }
    @Subscribe
    public void onInitialization(ProxyInitializeEvent event){
        CommandManager commandManager = proxyServer.getCommandManager();
        commandManager.register("party", new party());
        logger.info("[Kazanjima]: Registered commands.");

        logger.info("[Kazanjima]: Registered events.");
    }
}
