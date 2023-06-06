package com.shanedev.ultradeathmessages.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UDMCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("udm")) {
            Player player = (Player) sender;

            player.sendMessage("§8=======================================");
            player.sendMessage("");
            player.sendMessage("  §cPlugin: §7UltraDeathMessages");
            player.sendMessage("  §cAuthor: §7ShaneDev");
            player.sendMessage("");
            player.sendMessage("§8=======================================");

        }

        return true;
    }
}
