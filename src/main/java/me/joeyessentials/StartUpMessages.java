package me.joeyessentials;

import org.bukkit.Bukkit;

public class StartUpMessages {

    public static void onStartup() {
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
        Bukkit.getConsoleSender().sendMessage(Utils.color("&aStaff perks are working fine."));

    }

}
