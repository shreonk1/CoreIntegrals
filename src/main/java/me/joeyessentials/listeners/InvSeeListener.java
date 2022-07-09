package me.joeyessentials.listeners;

import me.joeyessentials.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvSeeListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(player.getInventory() == player.getInventory()) {
            final ItemStack clickedItem = event.getCurrentItem();
            String playerName = player.getName();
            if (clickedItem == null || clickedItem.getType().isAir()) return;

            if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&6" + playerName + "'s Enderchest"))) {
                Inventory enderchest = player.getEnderChest();
                player.openInventory(enderchest);
            }
        }
    }
}
