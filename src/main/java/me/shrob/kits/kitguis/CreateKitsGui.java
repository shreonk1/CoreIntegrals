package me.shrob.kits.kitguis;

import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CreateKitsGui {
    public void createGui(Player player) {
        Inventory createkitsgui =  Bukkit.getServer().createInventory(null, 54, "Create your kits!");

        ItemStack edges = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack createkit = new ItemStack(Material.FIRE_CHARGE);
        ItemStack previouspage = new ItemStack(Material.FIREWORK_STAR);

        ItemMeta edgesmeta = edges.getItemMeta();
        edgesmeta.setDisplayName(" ");
        edges.setItemMeta(edgesmeta);

        ItemMeta createkitmeta = createkit.getItemMeta();
        createkitmeta.setDisplayName(Utils.color("&a&lCreate your kits!"));
        ArrayList<String> createkitlore = new ArrayList<>();
        createkitlore.add(Utils.color("&b&oClick here to create a kit!"));
        createkitmeta.setLore(createkitlore);
        createkit.setItemMeta(createkitmeta);

        ItemMeta previouspagemeta = previouspage.getItemMeta();
        previouspagemeta.setDisplayName(Utils.color("&c&lPrevious Page"));
        previouspage.setItemMeta(previouspagemeta);

        createkitsgui.setItem(0, previouspage);
        createkitsgui.setItem(1, edges);
        createkitsgui.setItem(2, edges);
        createkitsgui.setItem(3, edges);
        createkitsgui.setItem(4, edges);
        createkitsgui.setItem(5, edges);
        createkitsgui.setItem(6, edges);
        createkitsgui.setItem(7, edges);
        createkitsgui.setItem(8, previouspage);
        createkitsgui.setItem(9, edges);
        createkitsgui.setItem(17, edges);
        createkitsgui.setItem(18, edges);
        createkitsgui.setItem(26, edges);
        createkitsgui.setItem(27, edges);
        createkitsgui.setItem(35, edges);
        createkitsgui.setItem(36, edges);
        createkitsgui.setItem(44, edges);
        createkitsgui.setItem(45, previouspage);
        createkitsgui.setItem(46, edges);
        createkitsgui.setItem(47, edges);
        createkitsgui.setItem(48, edges);
        createkitsgui.setItem(49, createkit);
        createkitsgui.setItem(50, edges);
        createkitsgui.setItem(51, edges);
        createkitsgui.setItem(52, edges);
        createkitsgui.setItem(53, previouspage);

        player.openInventory(createkitsgui);
    }
}
