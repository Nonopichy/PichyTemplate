package com.nonopichy.plugin;

import lombok.Getter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pichy.server.ServerVersion;

import java.util.Arrays;

public class Main extends JavaPlugin {

    @Getter public static Main Instance;
    @Getter public static PluginManager pluginManager;

    public void onEnable(){
        Instance = this;
        pluginManager = getServer().getPluginManager();
        enableAPIs();
  }

    public void onDisable(){

    }

    public void enableAPIs(){
        if(ServerVersion.getServerVersion() == ServerVersion.v1_7) {
            System.out.println("Running in 1.7 :D");
        }
    }

    private void registerEvents(Listener... listeners) {
        Arrays.stream(listeners).forEach(c -> pluginManager.registerEvents(c, this));
    }

    private void setExecutorAndTabCompleter(String name, Object obj) {
        PluginCommand command = getCommand(name);
        command.setExecutor((CommandExecutor) obj);
        command.setTabCompleter((TabCompleter) obj);
    }

}