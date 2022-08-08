package me.shrob.commands.useful;

import me.shrob.CoreIntegrals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WorkbenchCommand implements CommandExecutor {

    CoreIntegrals main;
    public WorkbenchCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("workbench")) {
            if(player.hasPermission("coreintegrals.commands.useful.workbench")) {
                player.openWorkbench(null, true);
            }else {
                player.sendMessage(main.getConfig().getString("nopermission").replace("%command%", "/workbench").replace("&", "§"));
            }
        }
        return false;
    }
}
