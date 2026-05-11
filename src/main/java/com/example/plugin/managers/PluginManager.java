package com.example.plugin.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PluginManager {
    private static PluginManager instance;
    private Map<UUID, Inventory> virtualChests = new HashMap<>();
    
    public static PluginManager getInstance() {
        if (instance == null) {
            instance = new PluginManager();
        }
        return instance;
    }
    
    public void initialize() {
        // Initialize your managers here
    }
    
    public Inventory getVirtualChest(Player player) {
        return virtualChests.computeIfAbsent(player.getUniqueId(), uuid -> Bukkit.createInventory(null, 27, "Virtual Chest"));
    }
    
    public void saveVirtualChest(Player player, Inventory inv) {
        virtualChests.put(player.getUniqueId(), inv);
    }
}