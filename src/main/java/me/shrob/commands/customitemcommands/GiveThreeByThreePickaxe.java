package me.shrob.commands.customitemcommands;

import me.shrob.CoreIntegrals;
import me.shrob.customitems.pickaxes.ThreeByThreePickaxe;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveThreeByThreePickaxe implements CommandExecutor {

    CoreIntegrals main;
    public GiveThreeByThreePickaxe(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("threebythree")) {
            if(player.hasPermission("coreintegrals.customitems.threebythreepickaxe")) {
                ThreeByThreePickaxe.giveItem(player);
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/threebythree").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
