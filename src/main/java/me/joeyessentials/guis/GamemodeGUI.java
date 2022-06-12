package me.joeyessentials.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GamemodeGUI implements Listener {

    public final Inventory inv;

    public GamemodeGUI() {
        inv = Bukkit.createInventory(null, 27, "Select Your Gamemode!");

        initializeItems();
    }

    public void initializeItems() {
        inv.addItem(createGuiItem(Material.DIAMOND_SWORD, "Survival mode", "select this to go into, gamemode survival"));
        inv.addItem(createGuiItem(Material.GRASS_BLOCK, "Creative mode", "select this to go into, gamemode creative"));
        inv.addItem(createGuiItem(Material.SPYGLASS, "Adventure mode", "select this to go into, gamemode adventure"));
        inv.addItem(createGuiItem(Material.ENDER_EYE, "Spectator mode", "select this to go into, gamemode spectator"));
    }
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    @EventHandler
    public void onInventory(final InventoryClickEvent e) {
        if(!e.getInventory().equals(inv)) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        if(clickedItem == null || clickedItem.getType().isAir()) return ;

        final Player p = (Player) e.getWhoClicked();
        p.sendMessage("You clicked at slot " + e.getRawSlot());
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if(e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}
