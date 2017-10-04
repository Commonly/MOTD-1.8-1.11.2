package me.jdog.motd.commands;

import me.jdog.motd.MOTD;
import me.jdog.murapi.api.Color;
import me.jdog.murapi.api.cmd.CMD;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class MOTDCommand implements CMD {

    private MOTD motd;

    public MOTDCommand(MOTD motd) {
        this.motd = motd;
    }

    @Override
    public String getName() {
        return "motd";
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Color.addColor("&cPlease add args! &a/motd <reload|spigot|motd>"));
            return true;
        }
        if(args[0].equalsIgnoreCase("reload")) {
            motd.reloadConfig();
            motd.saveConfig();
            sender.sendMessage(Color.addColor("&aConfig reload successful!"));
            return true;
        } else if(args[0].equalsIgnoreCase("spigot")) {
            sender.sendMessage(Color.addColor("&aSpigot link:&7 https://www.spigotmc.org/resources/motd.15032/"));
            return true;
        } else if (args[0].equalsIgnoreCase("motd")) {
            String msg = StringUtils.join(args, ' ', 1, args.length);
            motd.getConfig().set("motd.message", msg);
            motd.saveConfig();
            sender.sendMessage(Color.addColor("&aNew MOTD message: " + msg));
            return true;
        } else {
            sender.sendMessage(Color.addColor("&cPlease add args! &a/motd <reload|spigot|motd>"));
            return true;
        }
    }
}
