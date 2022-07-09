package me.shrob.customitems.pickaxes;

import me.shrob.CoreIntegrals;
import me.shrob.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ThreeByThreePickaxe {

    CoreIntegrals main;
    public ThreeByThreePickaxe(CoreIntegrals main) {
        this.main = main;
    }

    public static void giveItem(Player player) {
        ItemStack threebythreepickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta pickaxemeta = threebythreepickaxe.getItemMeta();
        pickaxemeta.setDisplayName(Utils.color("&b3x3 &b&lPickaxe"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Utils.color("&7Mine blocks in a 3x3 radius!"));
        pickaxemeta.setLore(lore);
        threebythreepickaxe.setItemMeta(pickaxemeta);
        player.getInventory().addItem(threebythreepickaxe);
    }
}
