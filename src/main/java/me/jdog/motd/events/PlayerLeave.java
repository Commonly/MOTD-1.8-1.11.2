package me.jdog.motd.events;

import me.jdog.motd.MOTD;
import me.jdog.murapi.api.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    private MOTD motd;

    public PlayerLeave(MOTD motd) {
        this.motd = motd;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(motd.getConfig().getBoolean("leave.showplayerleavemessage")) {
            e.setQuitMessage(Color.addColor("leave.playerleavemessage", motd).replace("%player%", p.getName()));
        } else {
            e.setQuitMessage(null);
        }
    }
}
