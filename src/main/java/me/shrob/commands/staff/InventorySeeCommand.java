package me.shrob.commands.staff;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class InventorySeeCommand implements CommandExecutor {

    CoreIntegrals main;
    public InventorySeeCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("invsee")) {
            Player player = (Player) sender;
            String playerName = args[0];
            if(!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(playerName))) {
                player.sendMessage(Utils.color("&cInvalid Player"));
                player.sendMessage(Utils.color("&6Usage: /invsee playername"));
                return false;
            }
            if(player.hasPermission("coreintegrals.commands.staff.invsee")) {
                Inventory playerinventory = player.getInventory();
                player.openInventory(playerinventory);
                player.sendMessage(Utils.color("&aYou are currently editing: " + "&b" + player.getName() + "'s " + "&ainventory!"));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/invsee").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
