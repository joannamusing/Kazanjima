package io.github.joannamusing.kazanjima.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import net.kyori.adventure.text.Component;

public class party_command implements CommandExecutor {

TODO: Add in the "/party set" branch to allow for leader and name to be changed.
TODO: Add "/party kick <Player>" command. 
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kazanjima.commands.party"));
                party p = PartyManager.getParty(player);
                if(args.length > 0){
                    for(Player target : Bukkit.getOnlinePlayers()){
                        if(args[0].equalsIgnoreCase(target.getName())){
                            /*
                            Creates a party if they are not in one, then invites the target player.
                            /party <Player>
                            */
                            if(p != null){
                                Bukkit.dispatchCommand(player, "party invite " + target.getName();
                            }else{
                                Bukkit.dispatchCommand(player, "party create " + player.getName();
                                Bukkit.dispatchCommand(player, "party invite " + target.getName();
                            }
                        }
                    }
                    //If there is some kind of argument after party, we go to the switch. "/party <argument>"
                    switch(args[0]){
                        /*
                        Toggles the party chat on or off.
                        /party chat
                        */
                        case("chat"):
                            if(p != null){
                                PartyManager.togglePartyChat(player);
                            }
                            break;
                        /*
                        Creates a new party with the specified name.
                        /party create <String>
                        */
                        case("create"):
                            if(p == null){
                                if(args.length == 2){
                                    p = new party(player, args[1]);
                                    PartyManager.addParty(p);
                                }else{
                                    player.sendMessage("/party create <String>");
                                }
                            }else{
                                player.sendMessage("You are already in a party.");
                            break;
                        /*
                        This will let the party leader disband the party.
                        /party disband
                        */
                        case("disband"):
                            if(p != null){
                                if(p.isLeader(player)){
                                    PartyManager.removeParty(p);
                                }
                            }
                            break;
                        /*
                        Gives the user a list of party commands.
                        /party help
                        */
                        case("help"):
                            ArrayList<String> strings = new ArrayList<>();
                            strings.add("/party - Check your party status.");
                            strings.add("/party <Player> - Invites another player to join your party.");
                            strings.add("/party chat - Toggle party chat on/off.");
                            strings.add("/party create <String> - Creates a party with the name of the string.");
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
                                for(Player target : Bukkit.getOnlinePlayers()){
                                    if(args[1].equalsIgnoreCase(target.getName())){
                                        PartyManager.addInvite(player, target);
                                        String message = "You have been invited to a party by " + player.getName() + "!");
                                        String command = "party join " + player.getName();
                                        utility.createClickableCommand(target, message, command);
                                    }
                                }
                            }
                            break;
                        case("join"):
                            if(args.length != 2){
                                player.sendMessage("/party join <Player>");
                            }
                            for(Player target : Bukkit.getOnlinePlayers()){
                                if(args[1].equalsIgnoreCase(target.getName())){
                                    p = PartyManager.getParty(target);
                                    if(PartyManager.getInvite(target, player)){
                                        p.addMember(player);
                                        PartyManager.removeInvite(target);
                                    }
                                }
                            }
                            break;
                        case("leave"):
                            if(p != null){
                                p.removeMember(player);
                            }
                            break;
                    }
                /*
                This is the general party command. It will open the party GUI ifthey are in a party, otherwise return a message.
                /party
                */
                }else{
                    if(p != null){
                        party_gui pgui = new party_gui(player, p);
                        player.openPartyGUI();
                    }else{
                        player.sendMessage("You are not in a party. Try \"/party help\".");
                }
            }
        }
    }  
}
