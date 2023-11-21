package me.podateK_;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerQuitEvent event) {
        Config configFile = CustomJoinMessage.getInstance().getConfigFile();
        String leaveMessage = configFile.leaveMessage;

        Player player = event.getPlayer();

        leaveMessage = leaveMessage.replace("{PLAYER}", player.getName());

        if(CustomJoinMessage.LeaveMessage) {
            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', leaveMessage));
        } else {
            event.setQuitMessage("§eGracz" + player.getName() + "dolaczyl do gry");
        }

    }
}
