package me.joeyessentials.kits.kitguis;

import me.joeyessentials.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EditKitsGui {
    public void createGui(Player player) {
        Inventory editkitsinventory =  Bukkit.getServer().createInventory(null, 54, "Edit your kits!");

        ItemStack edges = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack editkit = new ItemStack(Material.FIRE_CHARGE);
        ItemStack previouspage = new ItemStack(Material.FIREWORK_STAR);

        ItemMeta edgesmeta = edges.getItemMeta();
        edgesmeta.setDisplayName(" ");
        edges.setItemMeta(edgesmeta);

        ItemMeta editkitmeta = editkit.getItemMeta();
        editkitmeta.setDisplayName(Utils.color("&a&lEdit your kits!"));
        ArrayList<String> editkitlore = new ArrayList<>();
        editkitlore.add(Utils.color("&b&oShift-right click to edit a kit!"));
        editkitmeta.setLore(editkitlore);
        editkit.setItemMeta(editkitmeta);

        ItemMeta previouspagemeta = previouspage.getItemMeta();
        previouspagemeta.setDisplayName(Utils.color("&c&lPrevious Page"));
        previouspage.setItemMeta(previouspagemeta);

        editkitsinventory.setItem(0, previouspage);
        editkitsinventory.setItem(1, edges);
        editkitsinventory.setItem(2, edges);
        editkitsinventory.setItem(3, edges);
        editkitsinventory.setItem(4, edges);
        editkitsinventory.setItem(5, edges);
        editkitsinventory.setItem(6, edges);
        editkitsinventory.setItem(7, edges);
        editkitsinventory.setItem(8, previouspage);
        editkitsinventory.setItem(9, edges);
        editkitsinventory.setItem(17, edges);
        editkitsinventory.setItem(18, edges);
        editkitsinventory.setItem(26, edges);
        editkitsinventory.setItem(27, edges);
        editkitsinventory.setItem(35, edges);
        editkitsinventory.setItem(36, edges);
        editkitsinventory.setItem(44, edges);
        editkitsinventory.setItem(45, previouspage);
        editkitsinventory.setItem(46, edges);
        editkitsinventory.setItem(47, edges);
        editkitsinventory.setItem(48, edges);
        editkitsinventory.setItem(49, editkit);
        editkitsinventory.setItem(50, edges);
        editkitsinventory.setItem(51, edges);
        editkitsinventory.setItem(52, edges);
        editkitsinventory.setItem(53, previouspage);

        player.openInventory(editkitsinventory);
    }
}
