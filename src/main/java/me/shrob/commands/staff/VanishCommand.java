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
        if(command.getName().equalsIgnoreCase("vanish")) {
            Player player = (Player) sender;
            if(player.hasPermission("coreintegrals.commands.staff.vanish")) {
                ArrayList<Player> vanishplayers = new ArrayList<>();

                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(player.hasPermission("coreintegrals.commands.staff.vanish")) {
                    }
                }
            }else {
                player.sendMessage(main.getConfig().getString("messages.vanish").replace("%command%", "/vanish").replace("<green>", "§3"));
            }
        }
        return false;
    }
}
