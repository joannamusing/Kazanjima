package io.github.joannamusing.kazanjima.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import net.kyori.adventure.text.Component;

public class party_command implements CommandExecutor {
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.party")){
                party p = PartyManager.getParty(player);
                if(args.length > 0){
                    for(Player target : Bukkit.getOnlinePlayers()){
                        if(args[0].equalsIgnoreCase(target.getName())){
                            if(p != null){
                            //If args[0] is a player, we then invite them or something.
                            //Probably use a Bukkit#runCommand or something.
                            }
                        }
                    }
                    //If there is some kind of argument after party, we go to the switch. "/party <argument>"
                    switch(args[0]){
                        case("chat"):
                            if(p != null){
                            }
                            break;
                        case("create"):
                            break;
                        case("disband"):
                            if(p != null){
                            }
                            break;
                        case("help"):
                            //Help command to be helpful. Gives them the options.
                            ArrayList<String> strings = new ArrayList<>();
                            strings.add("/party - Check your party status.");
                            strings.add("/party <Player> - Invites another player to join your party.");
                            strings.add("/party chat - Toggle party chat on/off.");
                            strings.add("/party create <String> - Creates a party with the name of the string.
                            strings.add("/party disband - Disbands your party.");
                            strings.add("/party help - I wonder what this does.");
                            strings.add("/party invite <Player> - Invites a player to join your party.");
                            strings.add("/party join <Player>- Accepts an invite from the player.");
                            strings.add("/party leave - Leaves your current party.");
                            for (String s : strings) {
                                player.sendMessage(s);
                            }
                            break;
                        case("invite"):
                            if(args.length != 2){
                                player.sendMessage("/party invite <Player>");
                            }
                            if(p != null){
                            }
                            break;
                        case("join"):
                            if(args.length != 2){
                                player.sendMessage("/party join <Player>");
                            }
                            for(Player target : Bukkit.getOnlinePlayers()){
                                if(args[1].equalsIgnoreCase(target.getName())){
                                    p = PartyManager.getParty(target);
                                    if(PartyManager.isInvited(player)){
                                        p.addMember(player);
                                    }
                                }
                            }
                            break;
                        case("leave"):
                            if(p != null){
                            }
                            break;
                    }
                }else{
                    if(p != null){
                    }
                    //This will be a basic "/party" command.
                    //If the player is in a party, return the party GUI. Otherwise, return some statement or "/party help".
                }
            }
        }
    }  
}
