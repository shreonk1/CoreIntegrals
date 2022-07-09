package me.joeyessentials.commands.staff;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class EnderchestCommand implements CommandExecutor {

    JoeyEssentials main;
    public EnderchestCommand(JoeyEssentials main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("enderchest")) {
            Player player = (Player) sender;
            String playerName = args[0];
            if(!Bukkit.getOnlinePlayers().contains(playerName)) {
                player.sendMessage(main.getConfig().getString("invaliduser").replace("<red>", "§c"));
            }
            if(player.hasPermission("joeyessentials.commands.staff.enderchest")) {
                Inventory enderchest = player.getEnderChest();
                player.openInventory(enderchest);
                player.sendMessage(Utils.color("&aYou are currently editing: " + "&b" + player.getName() + "'s " + "&aenderchest!"));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/enderchest").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
