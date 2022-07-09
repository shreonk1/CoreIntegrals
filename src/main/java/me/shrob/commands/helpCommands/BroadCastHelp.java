package me.shrob.commands.helpCommands;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadCastHelp implements CommandExecutor {

    CoreIntegrals main;
    public BroadCastHelp(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("broadcasthelp")) {
            sender.sendMessage(Utils.color("&lBroadcast Help Menu:"));
            sender.sendMessage(Utils.color("&6/broadcast - Broadcasts a message in chat to all other users"));
            sender.sendMessage(Utils.color("&6/screenbroadcast - Broadcasts a message in chat and on all players screens to notify them."));
        }
        return false;
    }
}
