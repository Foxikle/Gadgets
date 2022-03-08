package me.foxikle.gadgets;

import org.bukkit.plugin.java.JavaPlugin;

public final class Gadgets extends JavaPlugin {

    public static Gadgets instance;

    @Override
    public void onEnable() {
        this.saveResource("config.yml", false);
        instance = this;
    }

    @Override
    public void onDisable() {
    }
    public static Gadgets getInstance(){
        return instance;
    }
}
