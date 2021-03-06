package me.shrob.listeners;

import me.shrob.CoreIntegrals;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    CoreIntegrals main;
    public JoinListener(CoreIntegrals main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(null);
        if(player.hasPlayedBefore()) {
            Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + player.getName());
        } else
            Bukkit.getServer().broadcastMessage(ChatColor.BLUE + main.getConfig().getString("newplayerwelcomemessage") + " " + player.getName());

        player.setGameMode(GameMode.CREATIVE);
    }
}
