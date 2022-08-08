package me.shrob.commands.helpingPlayers;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GodCommand implements CommandExecutor {

    CoreIntegrals main;
    public GodCommand(CoreIntegrals main) {
        this.main = main;
    }
    ArrayList<Player> godmode = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("god")) {
            Player player = (Player) sender;
            if (player.hasPermission("coreintegrals.commands.helpingplayers.god")) {
                if(godmode.contains(player)) {
                    godmode.remove(player);
                    player.setInvulnerable(false);
                    player.sendMessage(Utils.color("&cYour god mode has been turned off!"));
                }else {
                    godmode.add(player);
                    player.setInvulnerable(true);
                    player.sendMessage(Utils.color("&aYour god mode has been turned on!"));
                }
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/god").replace("&", "§"));
            }
        }
        return false;
    }
}
