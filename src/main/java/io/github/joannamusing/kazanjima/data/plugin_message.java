package io.github.joannamusing.kazanjima.data;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import io.github.joannamusing.kazanjima.Main;
import org.bukkit.entity.Player;

/*
This class is to handle sending data between the plugins of multiple servers.
 */
public class plugin_message {
    /*
    A method to connect a player to a specified server.
    Author: joannamusing
     */
    public static void connectPlayer(Player player, String server){
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(player.getName());
        output.writeUTF(server);
        player.sendPluginMessage(Main.getInstance(), "BungeeCord", output.toByteArray());
    }
    /*
    A method to connect a target player to a host player on a server.
    Author: joannamusing
     */
    public static void connectOtherPlayer(Player host, Player target){
        RegisteredServer registeredServer = (RegisteredServer) host.getServer();
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("ConnectOther");
        output.writeUTF(target.getName());
        output.writeUTF(registeredServer.toString());
        host.sendPluginMessage(Main.getInstance(), "BungeeCord", output.toByteArray());
    }
}
