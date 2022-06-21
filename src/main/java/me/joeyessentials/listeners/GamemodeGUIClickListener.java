package me.joeyessentials.listeners;

import me.joeyessentials.Utils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GamemodeGUIClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equalsIgnoreCase("Change your gamemode!")) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&b&l&oSurvival Mode"))) {
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(Utils.color("&6Updated Gamemode to Survival Mode!"));
        } else if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&b&l&oCreative Mode"))) {
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(Utils.color("&6Updated Gamemode to Creative Mode!"));
        } else if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&b&l&oAdventure Mode"))) {
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage(Utils.color("&6Updated Gamemode to Adventure Mode!"));
        } else if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&b&l&oSpectator Mode"))) {
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage(Utils.color("&6Updated Gamemode to Adventure Mode!"));
        }
        }
    }
