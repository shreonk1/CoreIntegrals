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

public class EnderchestCommand implements CommandExecutor {

    CoreIntegrals main;
    public EnderchestCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("enderchest")) {
            Player player = (Player) sender;
            String playerName = args[0];
            if(!Bukkit.getOnlinePlayers().contains(playerName)) {
                player.sendMessage(main.getConfig().getString("invaliduser").replace("&", "§"));
            }
            if(player.hasPermission("coreintegrals.commands.staff.enderchest")) {
                Inventory enderchest = player.getEnderChest();
                player.openInventory(enderchest);
                player.sendMessage(Utils.color("&aYou are currently editing: " + "&b" + player.getName() + "'s " + "&aenderchest!"));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/enderchest").replace("&", "§"));
            }
        }
        return false;
    }
}
