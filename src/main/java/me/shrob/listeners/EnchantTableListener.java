package me.shrob.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.inventory.InventoryView;

public class EnchantTableListener implements Listener {

    @EventHandler
    public void onOpenEnchantTable(PrepareItemEnchantEvent event) {
        InventoryView view = event.getView();
        view.setProperty(InventoryView.Property.ENCHANT_BUTTON1, 1);
        view.setProperty(InventoryView.Property.ENCHANT_BUTTON2, 15);
        view.setProperty(InventoryView.Property.ENCHANT_BUTTON3, 30);

        event.getExpLevelCostsOffered()[0] = 1;
        event.getExpLevelCostsOffered()[1] = 15;
        event.getExpLevelCostsOffered()[2] = 30;
    }
}
