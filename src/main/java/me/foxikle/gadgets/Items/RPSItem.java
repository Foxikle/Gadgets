package me.foxikle.gadgets.Items;

import me.foxikle.gadgets.Gadgets;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.Material.SHEARS;

public class RPSItem {

    public static ItemStack getRPSItem() {
        ItemStack head = new ItemStack(SHEARS);

        ItemMeta headMeta =  head.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GOLD + "Item Ability: GameTime! " + ChatColor.BOLD + "" + ChatColor.YELLOW + "RIGHT CLICK");
        lore.add(ChatColor.GRAY + "Right click a player to challenge them!");
        headMeta.setLore(lore);
        headMeta.getPersistentDataContainer().getKeys().add(new NamespacedKey(Gadgets.getInstance(), "RPS"));
        headMeta.setDisplayName(ChatColor.GREEN + "Rock Paper Scissors");
        head.setItemMeta(headMeta);
        return head;
    }
}
