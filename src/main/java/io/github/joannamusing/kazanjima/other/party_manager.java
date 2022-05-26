package io.github.joannamusing.kazanjima.other;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class party_manager {
    /*
    We store all our party objects in an ArrayList called allParties, so we can check through them later.
    When a player is invited to a party, we put them in a HashMap with the person who invited them.
    Each player can only invite one player at a time, else it will fail.
    The HashMap is <Inviter, Invitee> for clarification.
    We store the list of all players from all parties who have enabled partyChat in an ArrayList.
     */
    ArrayList<party> allParties;
    HashMap<UUID, UUID> invites;

    //We call our party_manager in our main class in order to initialize it on startup.
    public party_manager(){
        allParties = new ArrayList<>();
        invites = new HashMap<>();

    }
    public void addParty(party p){
        if(!allParties.contains(p)){
            allParties.add(p);
        }
    }
    public void removeParty(party p){
        p.removeAllPartyMembers();
        allParties.remove(p);
    }
    public party getParty(Player player){
        for(party p : allParties){
            if(p.getPartyMembers().contains(player.getUniqueId())){
                return p;
            }
        }
        return null;
    }
    public boolean getInvite(Player sender, Player receiver){
        UUID senderUUID = sender.getUniqueId();
        UUID receiverUUID = receiver.getUniqueId();
        if(invites.containsKey(senderUUID)){
            return invites.get(senderUUID).equals(receiverUUID);
        }
        return false;
    }
    public void addInvite(Player user, Player target){
        UUID userUUID = user.getUniqueId();
        UUID targetUUID = target.getUniqueId();
        if(invites.containsKey(userUUID)){
            user.sendMessage("You have already invited someone recently.");
            return;
        }
        invites.put(userUUID, targetUUID);
    }
    public void removeInvite(Player player){
        UUID uuid = player.getUniqueId();
        if(invites.containsKey(uuid)){
            invites.remove(player.getUniqueId());
        }
    }
}
