package me.joeyessentials.customitems.pickaxes;

import me.joeyessentials.JoeyEssentials;
import me.joeyessentials.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ThreeByThreePickaxe {

    JoeyEssentials main;
    public ThreeByThreePickaxe(JoeyEssentials main) {
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
