package me.shrob.commands.broadcast;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadCastCommand implements CommandExecutor {

    CoreIntegrals main;
    public BroadCastCommand(CoreIntegrals main) {
        this.main = main;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("broadcast")) {
            if (player.hasPermission("coreintegrals.commands.broadcast")) {
                if (args.length < 1) {
                    player.sendMessage(main.getConfig().getString("messages.nomessagegiven").replace("&", "§"));
                    return true;
                }
                String bc = String.join(" ", args);
                bc = ChatColor.translateAlternateColorCodes('&', bc);
                Bukkit.getServer().broadcastMessage(Utils.color("&6[Broadcast]" + bc));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("&", "§").replace("%command%", "/broadcast"));
            }
        }
        return true;
    }
}
