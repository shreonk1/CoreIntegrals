package me.joeyessentials.commands.staff;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StaffChatCommand implements CommandExecutor {
    JoeyEssentials main;
    public StaffChatCommand(JoeyEssentials main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("staffchat")) {
            if (player.hasPermission("joeyessentials.commands.staff.staffchat")) {

            } else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "§c"));
            }

            if (args.length < 1) {
                player.sendMessage(Utils.color("&cPlease send a message!"));
            }

            String message = "&c&l[StaffChat] " + "&f" + player.getName() + ": ";
            for (String s : args) {
                message = message + s + " ";
            }
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("joeyessentials.commands.staff.staffchat")) {
                    player.sendMessage(Utils.color(message));
                }
            }
        }
            return false;
    }
}
