package me.shrob.commands.helpingPlayers;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    CoreIntegrals main;
    public HealCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("heal")) {
            Player player = (Player) sender;
            if (player.hasPermission("coreintegrals.commands.helpingplayers.heal")) {
                player.setHealth(20);
                player.sendMessage(Utils.color("&aYou have healed " + "&e" + player.getName()));
            } else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/heal").replace("&", "§"));
            }
        }
        return false;
    }
}
