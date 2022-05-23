package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import org.bukkit.event.inventory.InventoryDragEvent;

public class inventory_drag {
    @Subscribe(order = PostOrder.NORMAL)
    public void onDrag(InventoryDragEvent event){
        //Reminder to cancel drag event.
    }
}
