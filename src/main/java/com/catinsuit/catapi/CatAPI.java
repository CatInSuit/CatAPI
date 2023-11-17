package com.catinsuit.catapi;

import com.catinsuit.catapi.Custom.Item.CustomItem;
import com.catinsuit.catapi.Custom.Item.CustomItemHandler;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class CatAPI extends JavaPlugin {

    public static NamespacedKey ItemIdKey;
    public static Map<String, CustomItem> customItemMap;

    @Override
    public void onEnable() {
        ItemIdKey = new NamespacedKey(this, "item-id");
        customItemMap = new HashMap<>();
        registerListeners(new CustomItemHandler());
    }

    public void registerItems(CustomItem... items) {
        Arrays.asList(items).forEach(ci -> customItemMap.put(ci.getId(), ci));
    }

    private void registerListeners(Listener... listeners) {
        Arrays.asList(listeners).forEach(l -> Bukkit.getPluginManager().registerEvents(l, this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
