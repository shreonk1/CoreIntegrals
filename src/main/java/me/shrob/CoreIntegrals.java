package me.shrob;

import me.shrob.commands.broadcast.BroadCastCommand;
import me.shrob.commands.broadcast.BroadCastOnScreen;
import me.shrob.commands.chat.ClearChat;
import me.shrob.commands.customitemcommands.Barrier;
import me.shrob.commands.customitemcommands.DebugStick;
import me.shrob.commands.customitemcommands.LightBlock;
import me.shrob.commands.funstuff.NickNameCommand;
import me.shrob.commands.gamemode.*;
import me.shrob.commands.helpCommands.BroadCastHelp;
import me.shrob.commands.helpCommands.StaffHelp;
import me.shrob.commands.helpingPlayers.*;
import me.shrob.commands.kits.KitCommands;
import me.shrob.commands.money.BalanceCommand;
import me.shrob.commands.money.MoneyCommands;
import me.shrob.commands.permissions.PermissionMenuInv;
import me.shrob.commands.staff.*;
import me.shrob.commands.staff.punishments.BanCommand;
import me.shrob.commands.staff.punishments.FreezeCommand;
import me.shrob.commands.useful.*;
import me.shrob.kits.listeners.InventoryClickListener;
import me.shrob.listeners.*;
import me.shrob.scoreboard.ScoreboardClass;
import me.shrob.tabcompleters.EnchantCompleter;
import me.shrob.tabcompleters.GamemodeTabCompleter;
import me.shrob.tabcompleters.MoneyCompleter;
import me.shrob.tabcompleters.PermissionsMenuCompleter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

public final class CoreIntegrals extends JavaPlugin implements Listener {

    public ArrayList<Player> vanishPlayers = new ArrayList<>();

    String nopermissionmessage;
    String nonicknamegivenmessage;
    String reloadpluginmessage;
    String invalidcommandmessage;
    String nomessagegiven;
    String nousermessage;
    String invalidusermessage;
    String invalidreasonmessage;
    String playerafkmessage;
    String playernotafkmessage;
    String youareafkmessage;
    String playerofflinemessage;
    String youarenotafkmessage;
    String vanishmessage;
    String unvanishmessage;
    String playervanishmessage;
    String playerunvanishmessage;
    String scoreboardTitle;
    String scoreboardLine1;
    String scoreboardLine2;
    String scoreboardLine3;
    String scoreboardLine4;
    String scoreboardLine5;
    String scoreboardLine6;
    String fixmessage;
    String notenoughmoneymessage;

    private static final Logger log = Logger.getLogger("Minecraft");
    public File commandsFile = new File(getDataFolder(), "commands.yml");
    public FileConfiguration commandsFileConfig;
    public static Economy economy = null;


    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        if (!commandsFile.exists()) {
            saveResource("commands.yml", false);
        }

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
        getCommand("cireload").setExecutor(new ReloadCommand(this));
        getCommand("staffhelp").setExecutor(new StaffHelp(this));
        getCommand("staffchat").setExecutor(new StaffChatCommand(this));
        getCommand("invsee").setExecutor(new InventorySeeCommand(this));
        getCommand("enderchest").setExecutor(new EnderchestCommand(this));
        getCommand("openenderchest").setExecutor(new OpenEnderchestCommand(this));
        getCommand("heal").setExecutor(new HealCommand(this));
        getCommand("nickname").setExecutor(new NickNameCommand(this));
        getCommand("realname").setExecutor(new RealNameCommand(this));
        getCommand("feed").setExecutor(new FeedCommand(this));
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("back").setExecutor(new BackCommand(this));
        getCommand("ban").setExecutor(new BanCommand(this));
        getCommand("god").setExecutor(new GodCommand(this));
        getCommand("kits").setExecutor(new KitCommands(this));
        getCommand("freeze").setExecutor(new FreezeCommand(this));
        getCommand("workbench").setExecutor(new WorkbenchCommand(this));
        getCommand("enchantingtable").setExecutor(new EnchantingTableCommand(this));
        getCommand("balance").setExecutor(new BalanceCommand(this));
        getCommand("setunbreakable").setExecutor(new UnbreakableCommand(this));
        getCommand("cenchant").setExecutor(new UpgradedEnchantingCommand(this));
        getCommand("cenchant").setTabCompleter(new EnchantCompleter(this));
        getCommand("fix").setExecutor(new FixCommand(this));
        getCommand("money").setExecutor(new MoneyCommands(this));
        getCommand("money").setTabCompleter(new MoneyCompleter());
        getCommand("debugstick").setExecutor(new DebugStick(this));
        getCommand("barrier").setExecutor(new Barrier(this));
        getCommand("lightblock").setExecutor(new LightBlock(this));
        getCommand("gamemodecreative").setExecutor(new GamemodeCreative(this));
        getCommand("gamemodesurvival").setExecutor(new GamemodeSurvival(this));
        getCommand("gamemodespectator").setExecutor(new GamemodeSpectator(this));
        getCommand("gamemodeadventure").setExecutor(new GamemodeAdventure(this));
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("sudo").setExecutor(new SudoCommand(this));
        getServer().getPluginManager().registerEvents(new ScoreboardClass(this), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new GamemodeGUIClickListener(), this);
        getServer().getPluginManager().registerEvents(new PermissionsMenuClickListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
        getServer().getPluginManager().registerEvents(new BackCommand(this), this);
        getServer().getPluginManager().registerEvents(new InvSeeListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new VanishChecker(this), this);

        /*
        getCommand("setMotd").setExecutor(new setMotd(this));
        getCommand("motd").setExecutor(new motd(this));

         */

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        if (!setupEconomy()) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


        loadConfigValues();
        updateScoreboards();
    }

    public void loadConfigValues() {
        reloadConfig();
        this.notenoughmoneymessage = getConfig().getString("messages.notenoughmoney");
        this.fixmessage = getConfig().getString("messages.fix");
        this.vanishmessage = getConfig().getString("messages.vanish");
        this.unvanishmessage = getConfig().getString("messages.unvanish");
        this.youareafkmessage = getConfig().getString("messages.youareafk");
        this.youarenotafkmessage = getConfig().getString("messages.youarenotafk");
        this.playerafkmessage = getConfig().getString("messages.playerafk");
        this.nopermissionmessage = getConfig().getString("messages.nopermission");
        this.nonicknamegivenmessage = getConfig().getString("messages.nonicknamegiven");
        this.reloadpluginmessage = getConfig().getString("messages.reloadplugin");
        this.invalidcommandmessage = getConfig().getString("messages.invalidcommand");
        this.nomessagegiven = getConfig().getString("messages.nomessagegiven");
        this.playerofflinemessage = getConfig().getString("messages.playeroffline");
        this.invalidreasonmessage = getConfig().getString("messages.invalidreason");
        this.invalidusermessage = getConfig().getString("messages.invaliduser");
        this.nousermessage = getConfig().getString("messages.nouser");
        this.playernotafkmessage = getConfig().getString("messages.playernotafk");
        this.vanishmessage = getConfig().getString("messages.vanish");
        this.unvanishmessage = getConfig().getString("messages.unvanish");
        this.playervanishmessage = getConfig().getString("messages.playerjustvanished");
        this.playerunvanishmessage = getConfig().getString("messages.playerjustunvanished");
        this.scoreboardTitle = getConfig().getString("scoreboard.scoreboardtitle");
        this.scoreboardLine1 = getConfig().getString("scoreboard.scoreboardline1");
        this.scoreboardLine2 = getConfig().getString("scoreboard.scoreboardline2");
        this.scoreboardLine3 = getConfig().getString("scoreboard.scoreboardline3");
        this.scoreboardLine4 = getConfig().getString("scoreboard.scoreboardline4");
        this.scoreboardLine5 = getConfig().getString("scoreboard.scoreboardline5");
        this.scoreboardLine6 = getConfig().getString("scoreboard.scoreboardline6");
    }

    public void setupScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("ScoreBoard ", "heheheheh", Utils.color(scoreboardTitle));
        Score score = obj.getScore(Utils.color(scoreboardLine1.replace("%player%", player.getName())));
        Score score2 = obj.getScore(Utils.color(scoreboardLine2.replace("%balance%", "" + CoreIntegrals.getEconomy().getBalance(player))));
        Score score3 = obj.getScore(Utils.color(scoreboardLine3));
        Score score4 = obj.getScore(Utils.color(scoreboardLine4));
        Score score5 = obj.getScore(Utils.color(scoreboardLine5));
        Score score6 = obj.getScore(Utils.color(scoreboardLine6.replace("%motd%", Bukkit.getMotd())));
        score.setScore(5);
        score2.setScore(4);
        score3.setScore(3);
        score4.setScore(2);
        score5.setScore(1);
        score6.setScore(0);

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        player.setScoreboard(board);
    }

    public void updateScoreboards() {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    setupScoreboard(player);
                }
            }
        }, 40, 40);
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }
    public static Economy getEconomy() {
        return economy;
    }
}
