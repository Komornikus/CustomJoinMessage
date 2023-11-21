package me.podateK_;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class tabCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1) { // /cos args1 args2?
            List<String> argumenty1 = new ArrayList<String>();
            argumenty1.add("joinmessage");
            argumenty1.add("leavemessage");
            argumenty1.add("reloadconfig");
            return argumenty1;
        }
        if(args.length == 2) {
            List<String> argumenty2= new ArrayList<String>();
            argumenty2.add("on");
            argumenty2.add("off");
            return argumenty2;
        }
        return null;
    }
}
