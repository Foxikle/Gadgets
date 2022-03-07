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

public class TTTitem {
    public static ItemStack getTTTItem() {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY0NjY5NjIxOTUxMiwKICAicHJvZmlsZUlkIiA6ICI0OTVlYTMyM2E0N2U0ODk0OWRjZmJmNDQxZmFhODM4YSIsCiAgInByb2ZpbGVOYW1lIiA6ICJDb29sZVZlbnQxNjgiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBmOTMxYWVhMzJiOGFkNzQyNTRjNjljMGU4ZTljMDdhZTY5NzliN2Y1ZGJlOGRmZTYwZTBlMmYwOWI1MzVjZSIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9"));
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
        headMeta.setDisplayName(ChatColor.GREEN + "Tic Tac Toe");
        head.setItemMeta(headMeta);
        return head;
    }
}
