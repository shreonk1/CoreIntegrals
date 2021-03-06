package me.shrob.kits.listeners;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import me.shrob.kits.kitguis.CreateKitsGui;
import me.shrob.kits.kitguis.EditKitsGui;
import me.shrob.kits.kitguis.ManageKitsGui;
import me.shrob.kits.kitguis.SelectKitGui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    CoreIntegrals main;
    public InventoryClickListener(CoreIntegrals main) {
        this.main = main;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Select your kit!")) {
            e.setCancelled(true);
            final ItemStack clickedItem = e.getCurrentItem();
            if (clickedItem == null || clickedItem.getType().isAir()) return;
            final Player player = (Player) e.getWhoClicked();

            if (clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&a&l&oManage your kits!"))) {
                if (player.hasPermission("coreintegrals.kits.managekits")) {
                    ManageKitsGui kitsmanagergui = new ManageKitsGui();
                    kitsmanagergui.createGui(player);
                } else {
                    player.closeInventory();
                    player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/kitmanager").replace("<red>", "§c"));
                }
            }
        }
        if(e.getView().getTitle().equalsIgnoreCase("Manage your kits!")) {
            e.setCancelled(true);
            final ItemStack clickedItem = e.getCurrentItem();
            if(clickedItem == null || clickedItem.getType().isAir()) return;
            final Player player = (Player) e.getWhoClicked();

            if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&c&lPrevious Page"))) {
                SelectKitGui kitselectiongui = new SelectKitGui();
                kitselectiongui.createGui(player);
            }
        }
        if(e.getView().getTitle().equalsIgnoreCase("Select your kit!")) {
            e.setCancelled(true);
            final ItemStack clickedItem = e.getCurrentItem();
            if(clickedItem == null || clickedItem.getType().isAir()) return;
            final Player player = (Player) e.getWhoClicked();

            if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&a&l&oEdit your kits!"))) {
                if(player.hasPermission("coreintegrals.kits.editkits")) {
                    EditKitsGui kiteditorgui = new EditKitsGui();
                    kiteditorgui.createGui(player);
                }else {
                    player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/kiteditor").replace("<red>","§c"));
                }
            }
        }
        if(e.getView().getTitle().equalsIgnoreCase("Edit your kits!")) {
            e.setCancelled(true);
            final ItemStack clickedItem = e.getCurrentItem();
            if(clickedItem == null || clickedItem.getType().isAir()) return;
            final Player player = (Player) e.getWhoClicked();

            if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&c&lPrevious Page"))) {
                SelectKitGui kitselectiongui = new SelectKitGui();
                kitselectiongui.createGui(player);
            }
        }
        if(e.getView().getTitle().equalsIgnoreCase("Select your kit!")) {
            e.setCancelled(true);
            final ItemStack clickedItem = e.getCurrentItem();
            if (clickedItem == null || clickedItem.getType().isAir()) return;
            final Player player = (Player) e.getWhoClicked();

            if (clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&a&l&oCreate your kits!"))) {
                if (player.hasPermission("coreintegrals.kits.createkits")) {
                    CreateKitsGui kitcreatorgui = new CreateKitsGui();
                    kitcreatorgui.createGui(player);
                }else {
                    player.sendMessage(main.getConfig().getString("messages.nopermission").replace("%command%", "/kitcreator").replace("<red>", "§c"));
                }
            }
        }
        if(e.getView().getTitle().equalsIgnoreCase("Create your kits!")) {
            e.setCancelled(true);
            final ItemStack clickedItem = e.getCurrentItem();
            if(clickedItem == null || clickedItem.getType().isAir()) return;
            final Player player = (Player) e.getWhoClicked();

            if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&c&lPrevious Page"))) {
                SelectKitGui kitselectiongui = new SelectKitGui();
                kitselectiongui.createGui(player);
            }

            if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&b&oClick here to create a kit!"))) {


                main.getConfig().options().copyDefaults(true);
                main.saveConfig();
            }
        }
    }
}
