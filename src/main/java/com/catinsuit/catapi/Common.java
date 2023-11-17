package com.catinsuit.catapi;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;

public class Common {

    public static String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static Component asChatComponent(String text) {
        return Component.text(colorize(text));
    }
}
