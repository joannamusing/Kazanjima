package io.github.joannamusing.kazanjima.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class party {
    public String TAG = ChatColor.WHITE + "[" + ChatColor.GREEN + "Party" + ChatColor.WHITE + "]";
    UUID partyUUID;
    String partyID;
    String partyName;
    ArrayList<UUID> members = new ArrayList<>();
    ArrayList<UUID> partyChat = new ArrayList<>();

    //We create a party object, using values we get from the leader of the new party.
    public party(Player player, String string){
        partyUUID = player.getUniqueId();
        partyID = partyUUID.toString();
        partyName = string;
        members.add(partyUUID);
        partyChat.add(partyUUID);
    }
    public UUID getPartyUUID(){
        return this.partyUUID;
    }
    public void setPartyUUID(Player player){
        partyUUID = player.getUniqueId();
    }
    public String getPartyID(){
        return this.partyID;
    }
    public void setPartyID(){
        partyID = getPartyUUID().toString();
    }
    public String getPartyName(){
        return this.partyName;
    }
    public void setPartyName(Player player){
        this.partyName = player.getName() + "'s Party";
    }
    public ArrayList<UUID> getPartyMembers(){
        return this.members;
    }
    public void addPartyMember(Player player){
        UUID uuid = player.getUniqueId();
        if(!members.contains(uuid)){
            members.add(uuid);
        }
    }
    public void removePartyMember(UUID uuid){
        members.remove(uuid);
    }
    public void removeAllPartyMembers(){
        members.clear();
    }
    public int getPartySize(){
        return members.size();
    }
    public boolean isLeader(Player player) {
        UUID uuid = player.getUniqueId();
        return partyUUID.equals(uuid);
    }
    /*
    This section down here is for party chat methods.
     */
    public void sendPartyMessage(Player sender, String s){
        s = ChatColor.WHITE + " " + sender.getName() + ChatColor.GREEN + ": " + s;
        for(UUID uuid : getPartyMembers()) {
            Player receiver = Bukkit.getServer().getPlayer(uuid);
            if(receiver != null){
                receiver.sendMessage(TAG + "s");
            }
        }
    }
    public void togglePartyChat(Player player){
        UUID uuid = player.getUniqueId();
        if(partyChat.contains(uuid)){
            partyChat.remove(uuid);
            player.sendMessage("Party chat toggled off.");
        }else{
            partyChat.add(uuid);
            player.sendMessage("Party chat toggled on.");
        }
    }
    public boolean getChatVisibility(Player player){
        UUID uuid = player.getUniqueId();
        if(partyChat.contains(uuid)){
            System.out.println("TRUE!");
            return true;
        }
        System.out.println("FALSE!");
        return false;
    }
}
