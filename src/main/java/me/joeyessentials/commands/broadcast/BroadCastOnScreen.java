package me.joeyessentials.commands.broadcast;

import me.joeyessentials.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BroadCastOnScreen implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("screenbroadcast")) {
            if(!sender.hasPermission("joeyessentials.broadcast.screen")) {
                sender.sendMessage(Utils.color("&cYou do not have permission to use this command!"));
            }
           String broadcastTitle = String.join(" ", args);
            broadcastTitle = ChatColor.translateAlternateColorCodes('&', broadcastTitle);
            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle(Utils.color("&2[Server Broadcast]"), Utils.color(broadcastTitle), 20, 80, 40);
            }


        }
        return false;
    }
}
