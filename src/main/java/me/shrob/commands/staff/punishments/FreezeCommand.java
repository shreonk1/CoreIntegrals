package me.shrob.commands.staff.punishments;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FreezeCommand implements CommandExecutor {
    public static ArrayList<Player> frozenplayers = new ArrayList<>();

    CoreIntegrals main;
    public FreezeCommand(CoreIntegrals main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("freeze")) {
            Player player = (Player) sender;
            if (player.hasPermission("coreintegrals.commands.staff.punishments.freeze")) {
                if (frozenplayers.contains(player)) {
                    frozenplayers.remove(player);
                    player.sendTitle(Utils.color("&cUnfrozen!"), Utils.color("&aYou have been Unfrozen, behave next time!"), 20, 80, 40);
                } else {
                    frozenplayers.add(player);
                    player.sendTitle(Utils.color("&cFrozen!"), Utils.color("&aYou have been frozen, behave next time!"), 20, 80, 40);
                }
            } else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/freeze").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
