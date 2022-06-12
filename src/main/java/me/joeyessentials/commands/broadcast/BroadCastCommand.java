package me.joeyessentials.commands.broadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadCastCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("broadcast")) {

            Player player = (Player) sender;

            if (player.hasPermission("joeyessentials.broadcast")) {
                if (args.length < 1) {
                    sender.sendMessage(ChatColor.RED + "Please include a message.");
                    return true;
                }
                String temp = String.join(" ", args);
                temp = ChatColor.translateAlternateColorCodes('&', temp);
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + " [Broadcast] " + temp);
            }
        }
        return true;
    }
}
