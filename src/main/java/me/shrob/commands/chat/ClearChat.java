package me.shrob.commands.chat;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {

    CoreIntegrals main;
    public ClearChat(CoreIntegrals main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("clearchat")) {
            Player player = (Player) sender;
            if(player.hasPermission("coreintegrals.commands.chat.clearchat")) {

                for(int i = 1; i < 200; i++) {
                    Bukkit.broadcastMessage(" ");

                }
                Bukkit.broadcastMessage(Utils.color("&6|-------------------+====+-------------------|"));
                Bukkit.broadcastMessage(Utils.color(" &lThe chat has been cleared by a staff member."));
                Bukkit.broadcastMessage(Utils.color("&6|-------------------+====+-------------------|"));
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/clearchat").replace("<red>", "§c"));
            }

        }
        return false;
    }
}
