package me.joeyessentials.commands.helpCommands;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class StaffHelp implements CommandExecutor {

    JoeyEssentials main;
    public StaffHelp(JoeyEssentials main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("staffhelp")) {
            sender.sendMessage(Utils.color("&6&lStaff's Help menu:"));
            sender.sendMessage(Utils.color("&6-/ban <user> <reason>"));
            sender.sendMessage(Utils.color("&6-/kick <user>"));
            sender.sendMessage(Utils.color("&6-/mute <user> <reason>"));
            sender.sendMessage(Utils.color("&6Command Spy - view all commands used by players."));
            sender.sendMessage(Utils.color("&6Staff chat, a private chat ingame for all staff members."));
            sender.sendMessage(Utils.color("&6-Staff chat aliases: /staffchat, /staffc, /sc, /staffmsg, /staffm, /sm"));
        }
        return false;
    }
}
