package io.github.joannamusing.kazanjima.other;

import org.bukkit.entity.Player;

import java.util.UUID;

public class party {
    UUID uuid;
    String partyID;

    //We create a party object, using values we get from the leader of the new party.
    public party(Player partyLeader){
        uuid = partyLeader.getUniqueId();
        partyID = uuid.toString();

    }
}
