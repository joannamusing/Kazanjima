package io.github.joannamusing.kazanjima.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import io.papermc.paper.event.player.AsyncChatEvent;

public class async_chat {
    @Subscribe(order = PostOrder.NORMAL)
    public void onAsyncChat(AsyncChatEvent event){
        //Check if they are using the '@'.
        //If they are, send it through party chat.
    }
}
