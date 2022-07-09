package me.joeyessentials.commands.helpingPlayers;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class OpenEnderchestCommand implements CommandExecutor {

    JoeyEssentials main;
    public OpenEnderchestCommand(JoeyEssentials main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("openenderchest")) {
            if(player.hasPermission("joeyessentials.commands.helpingplayers.openenderchest")) {
                Inventory enderchest = player.getEnderChest();
                player.openInventory(enderchest);
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/openenderchest").replace("<red>","§c"));
            }
        }
        return false;
    }
}
