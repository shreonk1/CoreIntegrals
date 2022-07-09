package me.shrob.commands.staff.punishments;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MuteCommand implements CommandExecutor {

    CoreIntegrals main;
    public MuteCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        int length = args.length;
        String kickedUser = args[0];
        if(command.getName().equalsIgnoreCase("mute")) {
            if(player.hasPermission("coreintegrals.comamnds.staff.punishments.mute")) {



                if(!(sender instanceof Player)) {
                    sender.sendMessage(Utils.color("&b[CONSOLE] &ahas &cmuted " + "&e" + player.getName() + "&a!"));
                }

            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/mute").replace("<red>", "§c"));
            }
        }
        return false;
    }
}
