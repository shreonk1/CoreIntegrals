package me.joeyessentials.commands.gamemode;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import me.joeyessentials.guis.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenGamemodeInv implements CommandExecutor {

    JoeyEssentials main;
    public OpenGamemodeInv(JoeyEssentials main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("gamem")) {
                if (player.hasPermission("joeyessentials.commands.gamemode.opengui")) {
                    if (args.length < 1) {
                        player.sendMessage(main.getConfig().getString("messages.invalidcommand").replace("<red>", "§c"));
                    }
                    if (args[0].equalsIgnoreCase("opengui")) {
                        GUI gui = new GUI();
                        gui.createGUI(player);

                    }
                }else {
                    player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/gamem").replace("<red>", "§c"));
                }
            }
        }
        return false;
        }
    }
