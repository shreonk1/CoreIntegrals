package me.shrob.listeners;

import me.shrob.commands.staff.punishments.FreezeCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(FreezeCommand.frozenplayers.contains(player)) {
            event.setCancelled(true);
        }
    }
}
