package me.shrob.commands.staff;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    CoreIntegrals main;
    public ReloadCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("cireload")) {
            if(player.hasPermission("coreintegrals.reload")) {
                long timeBefore = System.currentTimeMillis();
                main.loadConfigValues();

                long timeAfter = System.currentTimeMillis();
                long timeTaken = timeAfter - timeBefore;
                sender.sendMessage(Utils.color("&aReloaded Config, took: " + timeTaken + "ms."));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/cireload").replace("&", "§"));
            }
        }
        return false;
    }
}