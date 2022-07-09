package me.shrob.commands.staff;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StaffChatCommand implements CommandExecutor {
    CoreIntegrals main;
    public StaffChatCommand(CoreIntegrals main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("staffchat")) {
            if (player.hasPermission("coreintegrals.commands.staff.staffchat")) {

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
                if (player.hasPermission("coreintegrals.commands.staff.staffchat")) {
                    player.sendMessage(Utils.color(message));
                }
            }
        }
            return false;
    }
}
