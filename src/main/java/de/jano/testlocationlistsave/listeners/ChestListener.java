package de.jano.testlocationlistsave.listeners;

import de.jano.testlocationlistsave.managers.LocationsManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ChestListener implements Listener {
    private LocationsManager locationsManager;
    public ChestListener(LocationsManager locationsManager) {
        this.locationsManager = locationsManager;
    }
    @EventHandler
    public void onChestOpen(BlockBreakEvent event) {
        Bukkit.broadcastMessage("Block broken!");

        if(!event.getBlock().getType().name().contains("CHEST")) return;
        Bukkit.broadcastMessage("Chest broken!");
        Bukkit.broadcastMessage("Locations: " + locationsManager.getLocations().size());
        if(!locationsManager.getLocations().contains(event.getBlock().getLocation())) return;
        Bukkit.broadcastMessage("Chest is in list!");
        event.setCancelled(true);
        Bukkit.broadcastMessage("You can't break this chest!");

    }
}

