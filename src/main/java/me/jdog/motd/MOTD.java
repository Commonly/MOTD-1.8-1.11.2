package me.jdog.motd;

import me.jdog.motd.commands.MOTDCommand;
import me.jdog.motd.events.PlayerJoin;
import me.jdog.motd.events.PlayerLeave;
import me.jdog.murapi.api.cmd.CMDManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MOTD extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(this), this);
        CMDManager.registerCommand(new MOTDCommand(this), this);
    }
}