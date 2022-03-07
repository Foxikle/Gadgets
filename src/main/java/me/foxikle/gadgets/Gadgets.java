package me.foxikle.gadgets;

import org.bukkit.plugin.java.JavaPlugin;

public final class Gadgets extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveResource("config.yml", false);
    }

    @Override
    public void onDisable() {
    }
}
