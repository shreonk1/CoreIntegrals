package me.shrob;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisableHelpCommand implements CommandExecutor {

    CoreIntegrals main;
    public DisableHelpCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("help"))
            sender.sendMessage(ChatColor.RED + "Unknown Command. Please use our custom help commands.");
        return false;
    }
}
