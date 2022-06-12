package me.joeyessentials.commands.gamemode;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.guis.GUI;
import me.joeyessentials.guis.GamemodeGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenGamemodeInv implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("gamem")) {
                if (args.length < 1) {
                    sender.sendMessage("Please choose what command you want to use.");
                }
                if (args[0].equalsIgnoreCase("opengui")) {
                    GUI gui = new GUI();
                    gui.createGUI(player);

                }
            }
        }
        return false;
    }
}
