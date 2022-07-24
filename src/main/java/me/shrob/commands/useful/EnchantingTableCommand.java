package me.shrob.commands.useful;

import me.shrob.CoreIntegrals;
import me.shrob.listeners.EnchantTableListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

public class EnchantingTableCommand implements CommandExecutor {
    CoreIntegrals main;
    public EnchantingTableCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("enchantingtable")) {
            if(player.hasPermission("coreintegrals.commands.useful.enchantingtable")) {

            }else {
                player.sendMessage(main.getConfig().getString("nopermission").replace("%command%", "/enchantingtable").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
