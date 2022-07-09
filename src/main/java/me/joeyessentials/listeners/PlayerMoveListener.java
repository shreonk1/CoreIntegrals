package me.joeyessentials.listeners;

import me.joeyessentials.commands.staff.punishments.FreezeCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;
import java.util.UUID;

public class PlayerMoveListener implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(FreezeCommand.frozenplayers.contains(player)) {
            event.setCancelled(true);
        }
    }
}
