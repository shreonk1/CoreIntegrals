package me.shrob.commands.gamemode;

import me.shrob.CoreIntegrals;
import me.shrob.guis.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenGamemodeInv implements CommandExecutor {

    CoreIntegrals main;
    public OpenGamemodeInv(CoreIntegrals main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("gamem")) {
                if (player.hasPermission("coreintegrals.commands.gamemode.opengui")) {
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
