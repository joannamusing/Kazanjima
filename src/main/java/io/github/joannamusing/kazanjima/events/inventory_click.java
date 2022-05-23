package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import org.bukkit.event.inventory.InventoryClickEvent;

public class inventory_click {
    @Subscribe(order = PostOrder.NORMAL)
    public void onClick(InventoryClickEvent event){
        //Reminder to cancel and open new GUI as needed.
        //Make it so a shift+click will promote a member to the new leader.
        //Make it so a ctrl+click will kick a member.
    }
}
