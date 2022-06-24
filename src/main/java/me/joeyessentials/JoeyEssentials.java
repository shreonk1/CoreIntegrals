package me.joeyessentials;

import me.joeyessentials.commands.broadcast.BroadCastCommand;
import me.joeyessentials.commands.broadcast.BroadCastOnScreen;
import me.joeyessentials.commands.chat.ClearChat;
import me.joeyessentials.commands.gamemode.OpenGamemodeInv;
import me.joeyessentials.commands.helpCommands.BroadCastHelp;
import me.joeyessentials.commands.helpCommands.StaffHelp;
import me.joeyessentials.commands.helpingPlayers.BackCommand;
import me.joeyessentials.commands.helpingPlayers.FeedCommand;
import me.joeyessentials.commands.helpingPlayers.HealCommand;
import me.joeyessentials.commands.permissions.PermissionMenuInv;
import me.joeyessentials.commands.staff.punishments.BanCommand;
import me.joeyessentials.listeners.GamemodeGUIClickListener;
import me.joeyessentials.listeners.JoinListener;
import me.joeyessentials.listeners.PermissionsMenuClickListener;
import me.joeyessentials.tabcompleters.GamemodeTabCompleter;
import me.joeyessentials.tabcompleters.PermissionsMenuCompleter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoeyEssentials extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        Bukkit.getConsoleSender().sendMessage("-----------------------" + "-----------------------");
        Bukkit.getConsoleSender().sendMessage("|                     |" + " |                     |");
        Bukkit.getConsoleSender().sendMessage("-------         -------" + " |         -------------");
        Bukkit.getConsoleSender().sendMessage("       |       |" + "        |         |");
        Bukkit.getConsoleSender().sendMessage("       |       |" + "        |         -------------");
        Bukkit.getConsoleSender().sendMessage("       |       |" + "        |                     |");
        Bukkit.getConsoleSender().sendMessage("       |       |" + "        |         -------------");
        Bukkit.getConsoleSender().sendMessage("       |       |" + "        |         |");
        Bukkit.getConsoleSender().sendMessage("       |       |" + "        |         -------------");
        Bukkit.getConsoleSender().sendMessage("       |       |" + "        |                     |");
        Bukkit.getConsoleSender().sendMessage("-------        |" + "        -----------------------");
        Bukkit.getConsoleSender().sendMessage("|              |");
        Bukkit.getConsoleSender().sendMessage("|              |");
        Bukkit.getConsoleSender().sendMessage("----------------");


        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[Broadcast] is Working Fine."));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[ScreenBroadcast] is Working Fine"));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[BroadcastHelp] is Working Fine."));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[Help] has been Disabled as per request."));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[ClearChat] is Working Fine."));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[GamemodeGUI] is Working Fine"));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[PermissionsGUI] is Working Fine"));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[Tabcompleters] are Working Fine"));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[Feed, Heal] are working fine"));
        Bukkit.getConsoleSender().sendMessage(Utils.color("aStaff perks are working fine."));


        getCommand("broadcast").setExecutor(new BroadCastCommand());
        getCommand("broadcasthelp").setExecutor(new BroadCastHelp());
        getCommand("screenbroadcast").setExecutor(new BroadCastOnScreen());
        getCommand("help").setExecutor(new DisableHelpCommand());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("gamem").setExecutor(new OpenGamemodeInv());
        getCommand("gamem").setTabCompleter(new GamemodeTabCompleter());
        getCommand("joeypermissions").setExecutor(new PermissionMenuInv());
        getCommand("joeypermissions").setTabCompleter(new PermissionsMenuCompleter());
        getCommand("staffhelp").setExecutor(new StaffHelp());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("back").setExecutor(new BackCommand());
        getCommand("ban").setExecutor(new BanCommand());
        getServer().getPluginManager().registerEvents(new GamemodeGUIClickListener(), this);
        getServer().getPluginManager().registerEvents(new PermissionsMenuClickListener(), this);
        getServer().getPluginManager().registerEvents(new BackCommand(), this);

        /*
        getCommand("setMotd").setExecutor(new setMotd(this));
        getCommand("motd").setExecutor(new motd(this));

         */

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

    }
}
