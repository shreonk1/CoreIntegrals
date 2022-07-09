package me.joeyessentials.commands.helpingPlayers;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    JoeyEssentials main;
    public HealCommand(JoeyEssentials main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("heal")) {
            Player player = (Player) sender;
            if (player.hasPermission("joeyessentials.commands.helpingplayers.heal")) {
                player.setHealth(20);
                player.sendMessage(Utils.color("&aYou have healed " + "&e" + player.getName()));
            } else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/heal").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
