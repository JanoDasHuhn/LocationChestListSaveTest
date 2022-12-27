package de.jano.testlocationlistsave.managers;

import de.jano.testlocationlistsave.TestLocationListSave;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationsManager {
    private TestLocationListSave plugin;
    private List<Location> locations = new ArrayList<>();
    public LocationsManager(TestLocationListSave plugin) {
        this.plugin = plugin;

        setupLocations();
    }

    private void setupLocations() {
        if(plugin.getConfigManager().contains("locations")) {
            for(String key : plugin.getConfigManager(). getConfigurationSection("locations").getKeys(false)) {
                Location location = new Location(Bukkit.getWorld(plugin.getConfigManager().get("locations." + key + ".world").toString()),
                        Double.parseDouble(plugin.getConfigManager().get("locations." + key + ".x").toString()),
                        Double.parseDouble(plugin.getConfigManager().get("locations." + key + ".y").toString()),
                        Double.parseDouble(plugin.getConfigManager().get("locations." + key + ".z").toString()));
                locations.add(location);
                Bukkit.getServer().getLogger().info("Location found number:!" + key);
            }
        }
    }

    public void addLocation(Location location, int i) {

        plugin.getConfigManager().set("locations." + i + ".x",location.getBlockX());
        plugin.getConfigManager().set("locations." + i + ".y",location.getBlockY());
        plugin.getConfigManager().set("locations." + i + ".z",location.getBlockZ());
        plugin.getConfigManager().set("locations." + i + ".world",location.getWorld().getName());
        locations.add(location);


    }

}
