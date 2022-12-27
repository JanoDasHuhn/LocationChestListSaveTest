package de.jano.testlocationlistsave.commands;

import de.jano.testlocationlistsave.TestLocationListSave;
import de.jano.testlocationlistsave.Utils.BasicUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddLocationCommand implements CommandExecutor {
    private TestLocationListSave plugin;

    public AddLocationCommand(TestLocationListSave plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(args.length != 1) {
        sender.sendMessage("§cPlease use /addlocation <number>");
    }
    if(!BasicUtil.isInteger(args[0])){
        sender.sendMessage("§cPlease use a number!");
        return true;
    }
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();
            plugin.getLocationsManager().addLocation(location, Integer.parseInt(args[0]));
            player.sendMessage("§aLocation added!");
            player.getWorld().getBlockAt(location).setType(Material.CHEST);

        }
        return false;
    }
}
