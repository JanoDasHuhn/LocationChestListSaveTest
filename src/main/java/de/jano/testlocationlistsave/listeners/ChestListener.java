package de.jano.testlocationlistsave.listeners;

import de.jano.testlocationlistsave.managers.LocationsManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ChestListener implements Listener {
    private final LocationsManager locationsManager;
    public ChestListener(LocationsManager locationsManager) {
        this.locationsManager = locationsManager;
    }
    @EventHandler
    public void onChestOpen(BlockBreakEvent event) {


        if(!event.getBlock().getType().name().contains("CHEST")) return;

        if(!locationsManager.getLocations().contains(event.getBlock().getLocation())) return;

        event.setCancelled(true);


    }
}

