package me.shrob.kits.kitguis;

import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ManageKitsGui {
    public void createGui(Player player) {
        Inventory kitmanagergui = Bukkit.getServer().createInventory(null, 54, "Manage your kits!");

        ItemStack edges = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack deletekit = new ItemStack(Material.FIRE_CHARGE);
        ItemStack previouspage = new ItemStack(Material.FIREWORK_STAR);

        ItemMeta edgesmeta = edges.getItemMeta();
        edgesmeta.setDisplayName(" ");
        edges.setItemMeta(edgesmeta);

        ItemMeta deletekitmeta = deletekit.getItemMeta();
        deletekitmeta.setDisplayName(Utils.color("&a&l&oDelete your kits!"));
        ArrayList<String> deletekitlore = new ArrayList<>();
        deletekitlore.add(Utils.color("&b&oShift-Right click to delete a kit!"));
        deletekitmeta.setLore(deletekitlore);
        deletekit.setItemMeta(deletekitmeta);

        ItemMeta previouspagemeta = previouspage.getItemMeta();
        previouspagemeta.setDisplayName(Utils.color("&c&lPrevious Page"));
        previouspage.setItemMeta(previouspagemeta);

        kitmanagergui.setItem(0, previouspage);
        kitmanagergui.setItem(1, edges);
        kitmanagergui.setItem(2, edges);
        kitmanagergui.setItem(3, edges);
        kitmanagergui.setItem(4, edges);
        kitmanagergui.setItem(5, edges);
        kitmanagergui.setItem(6, edges);
        kitmanagergui.setItem(7, edges);
        kitmanagergui.setItem(8, previouspage);
        kitmanagergui.setItem(9, edges);
        kitmanagergui.setItem(17, edges);
        kitmanagergui.setItem(18, edges);
        kitmanagergui.setItem(26, edges);
        kitmanagergui.setItem(27, edges);
        kitmanagergui.setItem(35, edges);
        kitmanagergui.setItem(36, edges);
        kitmanagergui.setItem(44, edges);
        kitmanagergui.setItem(45, previouspage);
        kitmanagergui.setItem(46, edges);
        kitmanagergui.setItem(47, edges);
        kitmanagergui.setItem(48, edges);
        kitmanagergui.setItem(49, deletekit);
        kitmanagergui.setItem(50, edges);
        kitmanagergui.setItem(51, edges);
        kitmanagergui.setItem(52, edges);
        kitmanagergui.setItem(53, previouspage);

        player.openInventory(kitmanagergui);
    }
}
