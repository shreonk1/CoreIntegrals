package me.shrob.commands.helpingPlayers;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {

    CoreIntegrals main;
    public FeedCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("feed")) {
            if(player.hasPermission("coreintegrals.commands.helpingplayers.feed")) {
                player.setFoodLevel(20);
                player.sendMessage(Utils.color("&aYou have fed " + "&e" + player.getName()));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/feed").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
