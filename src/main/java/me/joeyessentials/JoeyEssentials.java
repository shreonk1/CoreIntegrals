package me.joeyessentials;

import me.joeyessentials.commands.broadcast.BroadCastCommand;
import me.joeyessentials.commands.broadcast.BroadCastOnScreen;
import me.joeyessentials.commands.chat.ClearChat;
import me.joeyessentials.commands.funstuff.NickNameCommand;
import me.joeyessentials.commands.gamemode.OpenGamemodeInv;
import me.joeyessentials.commands.helpCommands.BroadCastHelp;
import me.joeyessentials.commands.helpCommands.StaffHelp;
import me.joeyessentials.commands.helpingPlayers.*;
import me.joeyessentials.commands.kits.KitCommands;
import me.joeyessentials.commands.permissions.PermissionMenuInv;
import me.joeyessentials.commands.staff.EnderchestCommand;
import me.joeyessentials.commands.staff.InventorySeeCommand;
import me.joeyessentials.commands.staff.ReloadCommand;
import me.joeyessentials.commands.staff.StaffChatCommand;
import me.joeyessentials.commands.staff.punishments.BanCommand;
import me.joeyessentials.commands.staff.punishments.FreezeCommand;
import me.joeyessentials.kits.listeners.InventoryClickListener;
import me.joeyessentials.listeners.*;
import me.joeyessentials.tabcompleters.GamemodeTabCompleter;
import me.joeyessentials.tabcompleters.PermissionsMenuCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoeyEssentials extends JavaPlugin implements Listener {

    String nopermissionmessage;
    String nonicknamegivenmessage;
    String reloadpluginmessage;
    String invalidcommandmessage;
    String nomessagegiven;
    String invalidusermessage;
    String invalidreasonmessage;


    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        StartUpMessages startup = new StartUpMessages();
        StartUpMessages.onStartup();


        getCommand("broadcast").setExecutor(new BroadCastCommand(this));
        getCommand("broadcasthelp").setExecutor(new BroadCastHelp(this));
        getCommand("screenbroadcast").setExecutor(new BroadCastOnScreen(this));
        getCommand("help").setExecutor(new DisableHelpCommand(this));
        getCommand("clearchat").setExecutor(new ClearChat(this));
        getCommand("gamem").setExecutor(new OpenGamemodeInv(this));
        getCommand("gamem").setTabCompleter(new GamemodeTabCompleter());
        getCommand("editperms").setExecutor(new PermissionMenuInv(this));
        getCommand("editperms").setTabCompleter(new PermissionsMenuCompleter());
        getCommand("jereload").setExecutor(new ReloadCommand(this));
        getCommand("staffhelp").setExecutor(new StaffHelp(this));
        getCommand("staffchat").setExecutor(new StaffChatCommand(this));
        getCommand("invsee").setExecutor(new InventorySeeCommand(this));
        getCommand("enderchest").setExecutor(new EnderchestCommand(this));
        getCommand("openenderchest").setExecutor(new OpenEnderchestCommand(this));
        getCommand("heal").setExecutor(new HealCommand(this));
        getCommand("nickname").setExecutor(new NickNameCommand(this));
        getCommand("feed").setExecutor(new FeedCommand(this));
        getCommand("back").setExecutor(new BackCommand(this));
        getCommand("ban").setExecutor(new BanCommand(this));
        getCommand("god").setExecutor(new GodCommand(this));
        getCommand("kits").setExecutor(new KitCommands(this));
        getCommand("freeze").setExecutor(new FreezeCommand(this));
        getServer().getPluginManager().registerEvents(new GamemodeGUIClickListener(), this);
        getServer().getPluginManager().registerEvents(new PermissionsMenuClickListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
        getServer().getPluginManager().registerEvents(new BackCommand(this), this);
        getServer().getPluginManager().registerEvents(new InvSeeListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);

        /*
        getCommand("setMotd").setExecutor(new setMotd(this));
        getCommand("motd").setExecutor(new motd(this));

         */

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);


        loadConfigValues();
    }

    public void loadConfigValues() {
        reloadConfig();
        this.nopermissionmessage = getConfig().getString("messages.nopermission");
        this.nonicknamegivenmessage = getConfig().getString("messages.nonicknamegiven");
        this.reloadpluginmessage = getConfig().getString("messages.reloadplugin");
        this.invalidcommandmessage = getConfig().getString("messages.invalidcommand");
        this.nomessagegiven = getConfig().getString("messages.nomessagegiven");
        this.invalidreasonmessage = getConfig().getString("messages.invalidreason");
        this.invalidusermessage = getConfig().getString("messages.invaliduser");
    }
}
