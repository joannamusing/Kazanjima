package io.github.joannamusing.kazanjima.other;

import org.bukkit.entity.Player;

import java.util.UUID;

public class party {
    UUID partyUUID;
    ArrayList<UUID> partyMembers = new ArrayList<>();

    //We create a party object, using values we get from the leader of the new party.
    public party(Player partyLeader){
        uuid = partyLeader.getUniqueId();
        members.add(uuid);

    }
    public UUID getPartyUUID(){
        return this.partyUUID;
    }
    public void setPartyUUID(Player player){
        this.partyUUID = player.getUniqueID();
    }
    public ArrayList<UUID> getPartyMembers(){
        return this.partyMembers();
    }
    public void addPartyMember(UUID uuid){
        if(!(getPartyMembers().contains(uuid)){
            partyMembers.add(player.getUniqueID();
        }
    }
    public void removePartyMember(UUID uuid){
        if(partyMembers.contains(uuid){
            partyMembers.remove(uuid);
        }
    }
    public void setPartyLeader(Player player){
        if(partyMembers.contains(player.getUniqueID()){
            this.partyUUID = player.getUniqueID();
        }
    }
}
