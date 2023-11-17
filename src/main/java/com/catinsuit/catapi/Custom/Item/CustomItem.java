package com.catinsuit.catapi.Custom.Item;

import com.catinsuit.catapi.CatAPI;
import com.catinsuit.catapi.Common;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomItem {
    public abstract String getName();

    public abstract Material getMaterial();

    public abstract List<String> getLore();

    public abstract void handleLeftClick();

    public abstract void handleRightClick();

    public String getId() {
        return getClass().getSimpleName();
    }

    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(getMaterial());
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();

        itemMeta.displayName(Common.asChatComponent(getName()));
        List<Component> lore = new ArrayList<>();
        getLore().forEach(l -> lore.add(Common.asChatComponent(l)));
        itemMeta.lore(lore);

        container.set(CatAPI.ItemIdKey, PersistentDataType.STRING, getId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
