package me.shrob;

import org.bukkit.Bukkit;

public class StartUpMessages {

    public static void onStartup() {

        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[COREINTEGRALS] has been loaded!!"));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[Broadcast] ."));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[ScreenBroadcast] "));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[BroadcastHelp] ."));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[Help] has been Disabled as per request."));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[ClearChat] ."));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[GamemodeGUI] "));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[PermissionsGUI] "));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[Tabcompleters] "));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[Feed, Heal] "));
        Bukkit.getConsoleSender().sendMessage(Utils.color("&aStaff perks ."));

    }

}
