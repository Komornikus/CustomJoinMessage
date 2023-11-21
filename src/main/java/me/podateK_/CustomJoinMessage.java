package me.podateK_;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public final class CustomJoinMessage extends JavaPlugin {

    public static boolean JoinMessage = true;
    public static boolean LeaveMessage = true;

    private static CustomJoinMessage instance;
    private Config config;



    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        config = ConfigManager.create(Config.class, (it) -> {
            it.withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit()); // specify configurer implementation, optionally additional serdes packages
            it.withBindFile(new File(getDataFolder(), "config.yml")); // specify Path, File or pathname
            it.withRemoveOrphans(true); // automatic removal of undeclared keys
            it.saveDefaults(); // save file if does not exists
            it.load(true); // load and save to update comments/new fields
        });
        System.out.println("CustomJoinMessage by podateK_ for KarioCode turning on");
        getCommand("customjoinmessage").setExecutor(new customJoinMessageCommand());
        getCommand("customjoinmessage").setTabCompleter(new tabCompleter());

        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new LeaveEvent(), this);

    }





    @Override
    public void onDisable() {
        System.out.println("CustomJoinMessage by podateK_ for KarioCode turning off");
    }


    public static CustomJoinMessage getInstance() {
        return instance;

    }

    public Config getConfigFile() {
        return config;
    }
}
