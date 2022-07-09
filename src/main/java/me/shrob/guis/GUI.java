package me.shrob.guis;

import me.shrob.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUI {

    public void createGUI(Player player) {
        Inventory gamemodechangegui = Bukkit.getServer().createInventory(null, 27, "Change your gamemode!");

        ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack item2 = new ItemStack(Material.GRASS_BLOCK);
        ItemStack item3 = new ItemStack(Material.SPYGLASS);
        ItemStack item4 = new ItemStack(Material.ENDER_EYE);

        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(Utils.color("&b&l&oSurvival Mode"));
        ArrayList<String> lore1 = new ArrayList<String>();
        lore1.add(Utils.color("&d&oChange your gamemode to Survival Mode!"));
        meta1.setLore(lore1);
        item1.setItemMeta(meta1);


        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(Utils.color("&b&l&oCreative Mode"));
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add(Utils.color("&d&oChange your gamemode to Creative Mode!"));
        meta2.setLore(lore2);
        item2.setItemMeta(meta2);


        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName(Utils.color("&b&l&oAdventure Mode"));
        ArrayList<String> lore3 = new ArrayList<String>();
        lore3.add(Utils.color("&d&oChange your gamemode to Adventure Mode!"));
        meta3.setLore(lore3);
        item3.setItemMeta(meta3);


        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName(Utils.color("&b&l&oSpectator Mode"));
        ArrayList<String> lore4 = new ArrayList<String>();
        lore4.add(Utils.color("&d&oChange your gamemode to Spectator Mode!"));
        meta4.setLore(lore4);
        item4.setItemMeta(meta4);




        gamemodechangegui.setItem(10, item1);
        gamemodechangegui.setItem(12, item2);
        gamemodechangegui.setItem(14, item3);
        gamemodechangegui.setItem(16, item4);

        player.openInventory(gamemodechangegui);

    }

}
