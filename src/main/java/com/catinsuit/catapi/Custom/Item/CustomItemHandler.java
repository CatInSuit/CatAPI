package com.catinsuit.catapi.Custom.Item;

import com.catinsuit.catapi.CatAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class CustomItemHandler implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if(event.getAction().isRightClick() && isCustomItem(heldItem)) {
            CatAPI.customItemMap.get(getItemId(heldItem)).handleRightClick();
        }

        if(event.getAction().isLeftClick() && isCustomItem(heldItem)) {
            CatAPI.customItemMap.get(getItemId(heldItem)).handleLeftClick();
        }
    }

    public boolean isCustomItem(ItemStack itemStack) {
        return itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(CatAPI.ItemIdKey, PersistentDataType.STRING);
    }

    public String getItemId(ItemStack itemStack) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(CatAPI.ItemIdKey, PersistentDataType.STRING);
    }
}
