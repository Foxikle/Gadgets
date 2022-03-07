package me.foxikle.gadgets.Items;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

public class C4Item {
    public static ItemStack getC4Item() {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", "byUrE6hGFKvMWkXqJsQI3sZMmvvM0LBG+2NznQzPP03kUjK/kOCuwbC6uyNeuu+JxvUrVrtLr4MRkeq++J1xCnvSVfbgh/xtFsrj15/1e3oJEkv7VMvOBpjIXz75oTH5G6MIF3+tBZWIIoBl+oLIoMuTJO1rNipYQRgraZb0dwmo078dnTaaBh1g2IFIF7kxOeNOc4LdCud/NqHeKf+bVldxcLv1Nis2+F8Kxn28M8cJm6CxkiQvEHuPUZW7VsJT/vsJSyhxkAFOaL87OiuKjuQ/30ozw0ZNtXclqE2ML4JiGCAzaYNukGY2yuGbTTsm8DlIQ+amJZrYg7Ergr2VbPF3OiGaZhR/U0Lm97+8XCZsWSDSJWKCD7gtyl8rucrWncA4gaWd3L8YqgHiHGaJ9F87LuznQaibbXDxYAuVNrPreYMC0soO5aAzM1E0UNtC6B2wmW3NKMpj9Q3OQoJMJy10OqZ+oiUAKMLS+OM+KENr91okFhLBYV9xD3xsvVkDnbhbzFUCDq0EEr/8y+7xbq2nl2JnejYCwq6EXKOkyIAmHa7yuVUAT3AyUt4sAUizFGAJVJlRbAnhtwnvPkwBEW+GbtAVL3lFZV22aG4++DK8gWpdhUwK6wREqyIbjO93Bq9gVUzr0fqlHJjTCKEIQjh0zemuRsMDoXAdzGCMwlQ="));
        Field profileField;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ignored) {

        }
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GOLD + "Item Ability: GameTime! " + ChatColor.BOLD + "" + ChatColor.YELLOW + "RIGHT CLICK");
        lore.add(ChatColor.GRAY + "Right click a player to challenge them!");
        headMeta.setLore(lore);
        headMeta.setDisplayName(ChatColor.GREEN + "Connect four");
        head.setItemMeta(headMeta);
        return head;
    }
}
