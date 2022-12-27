package de.jano.testlocationlistsave;

import de.jano.testlocationlistsave.commands.AddLocationCommand;
import de.jano.testlocationlistsave.managers.ConfigManager;
import de.jano.testlocationlistsave.managers.LocationsManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class TestLocationListSave extends JavaPlugin {
    private LocationsManager locationsManager;
    private ConfigManager configManager;
    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        registerManagers();
    }

    private void registerManagers() {
        configManager = new ConfigManager(new File(getDataFolder(), "config.yml"));
        locationsManager = new LocationsManager(this);

    }

    private void registerCommands() {
        getCommand("addlocation").setExecutor(new AddLocationCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public LocationsManager getLocationsManager() {
        return locationsManager;
    }
}
