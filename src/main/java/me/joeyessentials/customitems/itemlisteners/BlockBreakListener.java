package me.joeyessentials.customitems.itemlisteners;

import me.joeyessentials.JoeyEssentials;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    JoeyEssentials main;
    public BlockBreakListener(JoeyEssentials main) {
        this.main = main;
    }

    @EventHandler
    public static void onBlockBreak(BlockBreakEvent event) {
    }
}
