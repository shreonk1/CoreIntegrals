package me.joeyessentials;

import me.joeyessentials.commands.broadcast.BroadCastCommand;
import me.joeyessentials.commands.broadcast.BroadCastOnScreen;
import me.joeyessentials.commands.chat.ClearChat;
import me.joeyessentials.commands.gamemode.OpenGamemodeInv;
import me.joeyessentials.commands.helpCommands.BroadCastHelp;
import me.joeyessentials.listeners.InventoryClickListener;
import me.joeyessentials.listeners.JoinListener;
/*
import me.joeyessentials.misc.motd;
import me.joeyessentials.misc.setMotd;

 */
import me.joeyessentials.tabcompleters.GamemodeTabCompleter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoeyEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        Bukkit.getConsoleSender().sendMessage("-----------------------" + "-----------------------");
        Bukkit.getConsoleSender().sendMessage("|                     |" + " |                     |");
        Bukkit.getConsoleSender().sendMessage("-------         -------" + " |         -------------");
        Bukkit.getConsoleSender().sendMessage("       |       |"        + "        |         |");
        Bukkit.getConsoleSender().sendMessage("       |       |"        + "        |         -------------");
        Bukkit.getConsoleSender().sendMessage("       |       |"        + "        |                     |");
        Bukkit.getConsoleSender().sendMessage("       |       |"        + "        |         -------------");
        Bukkit.getConsoleSender().sendMessage("       |       |"        + "        |         |");
        Bukkit.getConsoleSender().sendMessage("       |       |"        + "        |         -------------");
        Bukkit.getConsoleSender().sendMessage("       |       |"        + "        |                     |");
        Bukkit.getConsoleSender().sendMessage("-------        |"        + "        -----------------------");
        Bukkit.getConsoleSender().sendMessage("|              |");
        Bukkit.getConsoleSender().sendMessage("|              |");
        Bukkit.getConsoleSender().sendMessage("----------------");


        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Broadcast] is Working Fine.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[BroadcastHelp] is Working Fine.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Help] has been Disabled as per request.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[ClearChat] is Working Fine.");


        getCommand("broadcast").setExecutor(new BroadCastCommand());
        getCommand("broadcasthelp").setExecutor(new BroadCastHelp());
        getCommand("screenbroadcast").setExecutor(new BroadCastOnScreen());
        getCommand("help").setExecutor(new DisableHelpCommand());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("gamem").setExecutor(new OpenGamemodeInv());
        getCommand("gamem").setTabCompleter(new GamemodeTabCompleter());
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);

        /*
        getCommand("setMotd").setExecutor(new setMotd(this));
        getCommand("motd").setExecutor(new motd(this));

         */

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

    }
}
