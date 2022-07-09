package me.shrob.commands.funstuff;

import me.shrob.CoreIntegrals;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NickNameCommand implements CommandExecutor {

    CoreIntegrals main;
    public NickNameCommand(CoreIntegrals main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("nickname")) {
            Player player = (Player) sender;
            if(player.hasPermission("coreintegrals.commands.funstuff.nickname")) {
                if(args.length < 1) {
                    main.getConfig().getString("messages.nonicknamegiven").replace("<red>", "§c");
                }
                String nick = String.join(" ", args);
                nick = ChatColor.translateAlternateColorCodes('&', nick);

                player.setDisplayName(nick);
            }else {
                player.sendMessage(main.getConfig().getString("messages.nopermission".replace("%command%", "/nickname").replace("<red>", "§c")));
            }
        }
        return false;
    }
}
