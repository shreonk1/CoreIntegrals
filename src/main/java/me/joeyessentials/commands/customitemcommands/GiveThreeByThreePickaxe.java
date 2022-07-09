package me.joeyessentials.commands.customitemcommands;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import me.joeyessentials.customitems.pickaxes.ThreeByThreePickaxe;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveThreeByThreePickaxe implements CommandExecutor {

    JoeyEssentials main;
    public GiveThreeByThreePickaxe(JoeyEssentials main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("threebythree")) {
            if(player.hasPermission("joeyessentials.customitems.threebythreepickaxe")) {
                ThreeByThreePickaxe.giveItem(player);
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/threebythree").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
