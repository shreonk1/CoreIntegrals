package me.shrob.commands.helpingPlayers;

import me.shrob.CoreIntegrals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class BackCommand implements CommandExecutor, Listener {

    CoreIntegrals main;
    public BackCommand(CoreIntegrals main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        return false;
    }
}
