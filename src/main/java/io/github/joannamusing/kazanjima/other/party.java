package io.github.joannamusing.kazanjima.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class party {
    ChatColor color1 = ChatColor.GREEN;
    ChatColor color2 = ChatColor.WHITE;
    public String TAG = color2 + "[" + color1 + "Party" + color2 + "]";
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
    public void setPartyID(Player player){
        partyID = player.getUniqueId().toString();
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
    public boolean isMember(Player player){
        return this.members.contains(player.getUniqueId());
    }
    public void setLeader(Player player){
        if(!partyUUID.equals(player.getUniqueId())){
            setPartyUUID(player);
            setPartyID(player);
        }
    }
    public void promoteMember(Player leader, Player member){
        if(isLeader(leader)){
            setLeader(member);
        }
    }
    public ChatColor getColor1(){
        return color1;
    }
    public ChatColor getColor2(){
        return color2;
    }
    /*
    This section down here is for party chat methods.
     */
    public void sendPartyMessage(Player sender, String s){
        s = s.replace('@', ' ');
        s = color1 + " " + sender.getName() + color2 + ":" + s;
        for(UUID uuid : getPartyMembers()) {
            Player receiver = Bukkit.getServer().getPlayer(uuid);
            if(receiver != null){
                receiver.sendMessage(TAG + s);
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
            return true;
        }
        return false;
    }
}
