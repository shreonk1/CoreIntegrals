package me.shrob.customitems.itemlisteners;

import me.shrob.CoreIntegrals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    CoreIntegrals main;
    public BlockBreakListener(CoreIntegrals main) {
        this.main = main;
    }

    @EventHandler
    public static void onBlockBreak(BlockBreakEvent event) {
    }
}
