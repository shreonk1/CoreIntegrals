package me.joeyessentials.guis;

import me.joeyessentials.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInventoryGui {
    public void createGui(Player player) {
        Inventory invseeGui = Bukkit.getServer().createInventory(null, 54, player.getName());
        String playerName = player.getName();
        ItemStack ec = new ItemStack(Material.ENDER_CHEST);

        ItemMeta ecmeta = ec.getItemMeta();
        ecmeta.setDisplayName(Utils.color("&6" + playerName + "'s Enderchest"));
        ec.setItemMeta(ecmeta);

        invseeGui.setItem(0, player.getInventory().getHelmet());
        invseeGui.setItem(1, player.getInventory().getChestplate());
        invseeGui.setItem(2, player.getInventory().getLeggings());
        invseeGui.setItem(3, player.getInventory().getBoots());
        invseeGui.setItem(4, player.getInventory().getItemInOffHand());
        invseeGui.setItem(5, ec);
    }
}
