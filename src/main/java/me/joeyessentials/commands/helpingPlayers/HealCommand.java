package me.joeyessentials.commands.helpingPlayers;

import me.joeyessentials.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("heal")) {
            Player player = (Player) sender;
            if (player.hasPermission("joeyessentials.helpplayers.heal")) {
                player.setHealth(20);
                player.sendMessage(Utils.color("&aYou have healed " + "&e" + player.getName()));
            } else {
                player.sendMessage(Utils.color("&cYou do not have permission to use " + "&e/heal!" + " " + "&cIf you believe there is an issue please consult an admin."));
            }
        }
        return false;
    }
}
