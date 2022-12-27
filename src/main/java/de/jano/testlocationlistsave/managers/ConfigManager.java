package de.jano.testlocationlistsave.managers;



import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private final File configFile;
    private final FileConfiguration config;

    public ConfigManager(File configFile) {
        this.configFile = configFile;
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void set(String path, Object value) {
        config.set(path, value);
        save();
    }
    public ConfigurationSection getConfigurationSection(String path) {
        return  config.getConfigurationSection(path);
    }

    public Object get(String path) {
        return config.get(path);
    }

    public boolean contains(String path) {
        return config.contains(path);
    }

    public void save() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

