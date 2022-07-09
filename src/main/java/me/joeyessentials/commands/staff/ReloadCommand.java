package me.joeyessentials.commands.staff;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    JoeyEssentials main;
    public ReloadCommand(JoeyEssentials main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("jereload")) {
            if(player.hasPermission("joeyessentials.reload")) {
                long timeBefore = System.currentTimeMillis();
                main.loadConfigValues();

                long timeAfter = System.currentTimeMillis();
                long timeTaken = timeAfter - timeBefore;
                sender.sendMessage(Utils.color("&aReloaded Config, took: " + timeTaken + "ms."));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/jereload").replace("<green>","§a"));
            }
        }
        return false;
    }
}
