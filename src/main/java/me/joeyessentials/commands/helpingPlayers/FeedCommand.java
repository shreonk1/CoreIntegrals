package me.joeyessentials.commands.helpingPlayers;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {

    JoeyEssentials main;
    public FeedCommand(JoeyEssentials main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("feed")) {
            if(player.hasPermission("joeyessentials.commands.helpingplayers.feed")) {
                player.setFoodLevel(20);
                player.sendMessage(Utils.color("&aYou have fed " + "&e" + player.getName()));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/feed").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
