package me.joeyessentials.commands.broadcast;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadCastCommand implements CommandExecutor {

    JoeyEssentials main;
    public BroadCastCommand(JoeyEssentials main) {
        this.main = main;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("broadcast")) {
            Player player = (Player) sender;
            if (player.hasPermission("joeyessentials.commands.broadcast")) {
                if (args.length < 1) {
                    player.sendMessage(main.getConfig().getString("messages.nomessagegiven").replace("<red>", "§c"));
                    return true;
                }
                String bc = String.join(" ", args);
                bc = ChatColor.translateAlternateColorCodes('&', bc);
                Bukkit.getServer().broadcastMessage(Utils.color("&6[Broadcast]" + bc));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("<red>", "§c").replace("%command%", "/broadcast"));
            }
        }
        return true;
    }
}
