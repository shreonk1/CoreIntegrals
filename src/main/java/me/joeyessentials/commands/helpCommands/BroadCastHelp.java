package me.joeyessentials.commands.helpCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadCastHelp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("broadcasthelp")) {
            sender.sendMessage(ChatColor.BOLD + "Broadcast Help Menu:");
            sender.sendMessage(ChatColor.GOLD + "/broadcast - Broadcasts a message in chat to all other users");
            sender.sendMessage(ChatColor.GOLD + "/screenbroadcast - Broadcasts a message in chat and on all players screens to notify them.");
        }
        return false;
    }
}
