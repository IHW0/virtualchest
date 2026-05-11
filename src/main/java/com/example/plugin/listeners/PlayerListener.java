package com.example.plugin.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import com.example.plugin.managers.PluginManager;

public class PlayerListener implements Listener {
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Handle player join event
    }
    
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getView().getTitle().equals("Virtual Chest")) {
            PluginManager.getInstance().saveVirtualChest((org.bukkit.entity.Player) event.getView().getPlayer(), event.getInventory());
        }
    }
}
