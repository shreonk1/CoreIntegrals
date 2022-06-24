package me.joeyessentials.commands.staff.punishments;

import me.joeyessentials.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BanCommand implements CommandExecutor {
    // Command usage:
    // /ban bannedUser reason
    // i.e /ban LordFaquad Being Lord farquad

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        int length = args.length;
        String bannedUser = args[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < length; i++) {
            sb.append(args[i]).append(" ");
        }
        String reason = sb.toString();

        if(!(sender instanceof Player)) {
            player.banPlayer(bannedUser);
            Bukkit.broadcastMessage(Utils.color("&b[CONSOLE] &ahas &cbanned " + "&e" + player.getName() + "&a!"));
        }
        if(player.hasPermission("joeyessentials.commands.staff.punishments.ban")) {
            if(command.getName().equalsIgnoreCase("ban")) {
                player.banPlayer(Utils.color("Reason:&a " + reason));
                sender.sendMessage(Utils.color("&b[" + player.getName() + "] " + "&aHas banned " + bannedUser + "," +  "&cReason: " + reason ));
            }
            if(!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(bannedUser))) {
                sender.sendMessage(Utils.color("&cPlease select a user to ban!"));
            }else if(length < 2) {
                sender.sendMessage(Utils.color("&cPlease mention a reason to ban this user!"));
            }
        }
        return false;
    }
}
