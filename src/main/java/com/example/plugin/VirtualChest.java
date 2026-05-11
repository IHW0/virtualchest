package com.example.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import com.example.plugin.managers.PluginManager;
import com.example.plugin.listeners.PlayerListener;
import com.example.plugin.commands.vrctCommand;

public class VirtualChest extends JavaPlugin {
    
    @Override
    public void onEnable() {
        
        // Initialize managers
        PluginManager.getInstance().initialize();
        
        // Register listeners
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        
        // Register commands
        getCommand("virtualchest").setExecutor(new vrctCommand());
        
        getLogger().info("VirtualChest has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("VirtualChest has been disabled!");
    }
}