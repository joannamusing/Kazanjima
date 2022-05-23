package io.github.joannamusing.kazanjima.other;

import java.util.HashMap;

public class party_manager {
    //We store all of our party objects in this HashMap using the partyID, and the object.
    HashMap<String, party> allParties;

    //We call our party_manager in our main class in order to initialize it on startup.
    public party_manager(){
        allParties = new HashMap<>();
    }
}
