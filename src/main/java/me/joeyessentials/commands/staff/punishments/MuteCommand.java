package me.joeyessentials.commands.staff.punishments;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
import org.jetbrains.annotations.NotNull;

public class MuteCommand implements CommandExecutor {

    JoeyEssentials main;
    public MuteCommand(JoeyEssentials main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        int length = args.length;
        String kickedUser = args[0];
        if(command.getName().equalsIgnoreCase("mute")) {
            if(player.hasPermission("joeyessentials.comamnds.staff.punishments.mute")) {



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
