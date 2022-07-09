package me.shrob.commands.helpingPlayers;

import me.shrob.CoreIntegrals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class OpenEnderchestCommand implements CommandExecutor {

    CoreIntegrals main;
    public OpenEnderchestCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("openenderchest")) {
            if(player.hasPermission("coreintegrals.commands.helpingplayers.openenderchest")) {
                Inventory enderchest = player.getEnderChest();
                player.openInventory(enderchest);
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/openenderchest").replace("<red>","§c"));
            }
        }
        return false;
    }
}
