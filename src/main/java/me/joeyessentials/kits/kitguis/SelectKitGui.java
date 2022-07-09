package me.joeyessentials.kits.kitguis;

import me.joeyessentials.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SelectKitGui {

    public void createGui(Player player) {
        Inventory kitselectiongui = Bukkit.getServer().createInventory(null, 54, "Select your kit!");

        ItemStack edges = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack createkit = new ItemStack(Material.GOLDEN_SWORD);
        ItemStack editkit = new ItemStack(Material.CRAFTING_TABLE);
        ItemStack managekit = new ItemStack(Material.WOODEN_PICKAXE);

        ItemMeta edgemetas = edges.getItemMeta();
        edgemetas.setDisplayName(" ");
        edges.setItemMeta(edgemetas);

        ItemMeta createkitmeta = createkit.getItemMeta();
        createkitmeta.setDisplayName(Utils.color("&a&l&oCreate your kits!"));
        ArrayList<String> createkitlore = new ArrayList<>();
        createkitlore.add(Utils.color("&b&oClick here to create your kits."));;
        createkitmeta.addEnchant(Enchantment.DAMAGE_ALL,1, true);
        createkitmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        createkitmeta.setLore(createkitlore);
        createkit.setItemMeta(createkitmeta);

        ItemMeta editkitmeta = editkit.getItemMeta();
        editkitmeta.setDisplayName(Utils.color("&a&l&oEdit your kits!"));
        ArrayList<String> editkitlore = new ArrayList<>();
        editkitlore.add(Utils.color("&b&oClick here to edit your kits."));
        editkitmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        editkitmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        editkitmeta.setLore(editkitlore);
        editkit.setItemMeta(editkitmeta);

        ItemMeta managekitmeta = managekit.getItemMeta();
        managekitmeta.setDisplayName(Utils.color("&a&l&oManage your kits!"));
        ArrayList<String> managekitlore = new ArrayList<>();
        managekitlore.add(Utils.color("&b&oClick here to manage your kits."));
        managekitmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        managekitmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        managekitmeta.setLore(managekitlore);
        managekit.setItemMeta(managekitmeta);


        kitselectiongui.setItem(0, edges);
        kitselectiongui.setItem(1, edges);
        kitselectiongui.setItem(2, edges);
        kitselectiongui.setItem(3, edges);
        kitselectiongui.setItem(4, edges);
        kitselectiongui.setItem(5, edges);
        kitselectiongui.setItem(6, edges);
        kitselectiongui.setItem(7, edges);
        kitselectiongui.setItem(8, edges);
        kitselectiongui.setItem(9, edges);
        kitselectiongui.setItem(17, edges);
        kitselectiongui.setItem(18, edges);
        kitselectiongui.setItem(26, edges);
        kitselectiongui.setItem(27, edges);
        kitselectiongui.setItem(35, edges);
        kitselectiongui.setItem(36, edges);
        kitselectiongui.setItem(44, edges);
        kitselectiongui.setItem(45, edges);
        kitselectiongui.setItem(46, edges);
        kitselectiongui.setItem(47, createkit);
        kitselectiongui.setItem(48, edges);
        kitselectiongui.setItem(49, editkit);
        kitselectiongui.setItem(50, edges);
        kitselectiongui.setItem(51, managekit);
        kitselectiongui.setItem(52, edges);
        kitselectiongui.setItem(53, edges);

        player.openInventory(kitselectiongui);
    }
}
