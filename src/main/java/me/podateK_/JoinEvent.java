package me.podateK_;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Config configFile = CustomJoinMessage.getInstance().getConfigFile();
        String joinMessage = configFile.joinMessage;

        Player player = event.getPlayer();

        joinMessage = joinMessage.replace("{PLAYER}", player.getName());

        if(CustomJoinMessage.JoinMessage) {
           event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
        } else {
            event.setJoinMessage("§eGracz" + player.getName() + "dolaczyl do gry");
        }

    }
}
