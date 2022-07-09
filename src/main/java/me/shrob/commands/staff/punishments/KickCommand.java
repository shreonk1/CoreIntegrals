package me.shrob.commands.staff.punishments;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KickCommand implements CommandExecutor {

    CoreIntegrals main;
    public KickCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        int length = args.length;
        String kickedUser = args[0];

        if(!(sender instanceof Player)) {
            sender.sendMessage(Utils.color("&b[CONSOLE] &ahas &ckicked " + "&e" + player.getName() + "&a!"));
        }
        if(player.hasPermission("coreintegrals.commands.staff.punishments.ban")) {
            player.kick();
            player.sendMessage("&b[" + player.getName() + "] " + "&aHas kicked " + kickedUser + "," +  "&cReason: " + args[1] );
        }else {
            player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/kick").replace("<red>", "§c"));
        }
        if(!Bukkit.getOnlinePlayers().contains(kickedUser)) {
            player.sendMessage(main.getConfig().getString("invaliduser").replace("<red>", "§c"));
        }
        return false;
    }
}
