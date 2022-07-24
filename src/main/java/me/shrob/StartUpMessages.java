package me.shrob;

import org.bukkit.Bukkit;

public class StartUpMessages {

    public static void onStartup() {

        Bukkit.getConsoleSender().sendMessage(Utils.color("&a[COREINTEGRALS] has been loaded!!"));
    }

}
