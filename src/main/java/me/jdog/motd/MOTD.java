package me.jdog.motd;

import me.jdog.motd.events.PlayerJoin;
import me.jdog.motd.events.PlayerLeave;
import me.jdog.murapi.api.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MOTD extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(this), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("motd")) {
            if (args.length != 1) {
                sender.sendMessage(Color.addColor("&cPlease add args! &a/motd <reload>"));
                return true;
            }

            if(args[0].equalsIgnoreCase("reload")) {
                reloadConfig();
                saveConfig();
                sender.sendMessage(Color.addColor("&aConfig reload successful!"));
                return true;
            } else {
                sender.sendMessage(Color.addColor("&cPlease add args! &a/motd <reload>"));
                return true;
            }
        }
        return false;
    }
}
