package com.example.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import com.example.plugin.managers.PluginManager;

public class vrctCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            try {
                // Open virtual chest
                Inventory chest = PluginManager.getInstance().getVirtualChest(player);
                if (chest == null) {
                    player.sendMessage("§cError: Could not create virtual chest!");
                    return true;
                }
                player.openInventory(chest);
                player.sendMessage("§aVirtual chest opened!");
            } catch (Exception e) {
                player.sendMessage("§cError opening chest: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
            player.sendMessage("§6Usage: §f/virtualchest - Opens your virtual chest");
        } else {
            player.sendMessage("§cInvalid arguments. Use /virtualchest help for usage.");
        }

        return true;
    }
}