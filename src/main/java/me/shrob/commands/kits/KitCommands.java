package me.shrob.commands.kits;

import me.shrob.CoreIntegrals;
import me.shrob.kits.kitguis.SelectKitGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KitCommands implements CommandExecutor {

    CoreIntegrals main;
    public KitCommands(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("kits")) {
            Player player = (Player) sender;
            if(player.hasPermission("coreintegrals.kits.selectkit")) {
                SelectKitGui kitselectiongui = new SelectKitGui();
                kitselectiongui.createGui(player);
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/kits").replace("&", "§"));
            }
        }
        return false;
    }
}
