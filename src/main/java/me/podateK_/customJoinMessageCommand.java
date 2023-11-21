package me.podateK_;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class customJoinMessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;


        if (!player.hasPermission("KarioCode.CustomJoinMessage.admin")) {
            return true;
        }

        if (args.length == 2) {  //komenda arg0 arg1
            if (args[0].equalsIgnoreCase("joinmessage")) {
                if (args[1].equalsIgnoreCase("on")) {
                    if (!CustomJoinMessage.JoinMessage) {
                        CustomJoinMessage.JoinMessage = true;
                        player.sendMessage("§7Pomyslnie wlaczyles customowe wiadomosci po wejsciu przez gracza na serwer");
                        player.sendMessage("§7Mozesz je zmienic w pliku config.yml w folderze o takiej samej nazwie jak plugin");
                    } else {
                        player.sendMessage("§7Customowe wiadomosci po wejsciu gracza sa juz wlaczone");
                    }
                } else if (args[1].equalsIgnoreCase("off")) {
                    if (CustomJoinMessage.JoinMessage) {
                        CustomJoinMessage.JoinMessage = false;
                        player.sendMessage("§7Pomyslnie wylaczyles customowe wiadomosci po wejsciu przez gracza na serwer");
                    } else {
                        player.sendMessage("Customowe wiadomosci po wejsciu sa juz wylaczone");
                    }
                }

            } else if (args[0].equalsIgnoreCase("leavemessage")) {
                if (args[1].equalsIgnoreCase("on")) {
                    if (!CustomJoinMessage.LeaveMessage) {
                        CustomJoinMessage.LeaveMessage = true;
                        player.sendMessage("§7Pomyslnie wlaczyles customowe wiadomosci po wyjsciu przez gracza na serwer");
                        player.sendMessage("§7Mozesz je zmienic w pliku config.yml w folderze o takiej samej nazwie jak plugin");
                    } else {
                        player.sendMessage("§7Customowe wiadomosci po wyjsciu gracza sa juz wlaczone");
                    }
                } else if (args[1].equalsIgnoreCase("off")) {
                    if (CustomJoinMessage.LeaveMessage) {
                        CustomJoinMessage.LeaveMessage = false;
                        player.sendMessage("§7Pomyslnie wylaczyles customowe wiadomosci po wyjsciu przez gracza na serwer");
                    } else {
                        player.sendMessage("Customowe wiadomosci po wyjsciu sa juz wylaczone");
                    }

                }
            } else if(args[0].equalsIgnoreCase("reloadconfig")) {
                reloadConfig();
                player.sendMessage("&7Pomyslnie przeladowano config");
            }
            return false;
        }
        return false;


    }

    private void reloadConfig() {
        Config configFile = CustomJoinMessage.getInstance().getConfigFile();

        try {
            configFile.load(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CustomJoinMessage.getInstance().saveConfig();
    }
}