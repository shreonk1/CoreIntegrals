package me.shrob.commands.broadcast;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BroadCastOnScreen implements CommandExecutor {

    CoreIntegrals main;
    public BroadCastOnScreen(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("screenbroadcast")) {
            if(sender.hasPermission("coreintegrals.commands.broadcast.screen")) {
                String broadcastTitle = String.join(" ", args);
                broadcastTitle = ChatColor.translateAlternateColorCodes('&', broadcastTitle);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(Utils.color("&2[Server Broadcast]"), Utils.color(broadcastTitle), 20, 80, 40);
                }
            }else {
                sender.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/screenbroadcast").replace("&", "§"));
            }
        }
        return false;
    }
}
