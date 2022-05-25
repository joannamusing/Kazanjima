package io.github.joannamusing.kazanjima.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import net.kyori.adventure.text.Component;

public class party_command implements SimpleCommand {
    @Override
    public void execute(Invocation invocation) {
        CommandSource source = invocation.source();
        String[] args = invocation.arguments();
        if(source.hasPermission("kazanjima.commands.party")){
            source.sendMessage(Component.text("You used the party command!"));
        }
    }
}
