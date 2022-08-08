package me.shrob.commands.staff;

import me.shrob.CoreIntegrals;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {
    CoreIntegrals main;
    public VanishCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("vanish")) {
            Player player = (Player) sender;
            if (player.hasPermission("coreintegrals.commands.staff.vanish")) {
                if(main.vanishPlayers.contains(player)) {
                    for(Player people : Bukkit.getOnlinePlayers()) {
                        people.showPlayer(main, player);
                    }
                    main.vanishPlayers.remove(player);
                    player.sendMessage(main.getConfig().getString("messages.unvanish").replace("&", "§"));
                } else if (!main.vanishPlayers.contains(player)) {
                    for(Player people : Bukkit.getOnlinePlayers()) {
                        people.hidePlayer(main, player);
                    }
                    main.vanishPlayers.add(player);
                    player.sendMessage(main.getConfig().getString("messages.vanish").replace("&", "§"));
                }
            }
            for(Player perms : Bukkit.getOnlinePlayers()) {
                if(player.hasPermission("coreintegrals.commands.staff.vanish")) {
                    player.showPlayer(main, player);
                }
            }
        }
        return false;
    }
}
