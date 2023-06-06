package com.shanedev.ultradeathmessages;

import com.shanedev.ultradeathmessages.commands.ReloadCommand;
import com.shanedev.ultradeathmessages.commands.UDMCommand;
import com.shanedev.ultradeathmessages.events.DeathEvent;
import com.shanedev.ultradeathmessages.events.ShaneJoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class UltraDeathMessages extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        config.setup();
        config.get().addDefault("Prefix", "&f&lUltraDeathMessages &8&l» ");
        config.get().addDefault("DeathByBow", "&e&lDEATH &8&l» %victim% was shot to death by %killer%");
        config.get().addDefault("DeathBySelf", "&e&lDEATH &8&l» %victim% Killed themselves.");

        config.get().options().copyDefaults(true);

        getServer().getPluginManager().registerEvents(new ShaneJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        getCommand("udm").setExecutor(new UDMCommand());
        getCommand("udmreload").setExecutor(new ReloadCommand());





        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "==================================================");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage("§cPlugin: §7UltraDeathMessages");
        getServer().getConsoleSender().sendMessage("§cAuthor: §7ShaneDev");
        getServer().getConsoleSender().sendMessage("§cVersion: §71.0");
        getServer().getConsoleSender().sendMessage("§cDiscord: §7https://discord.gg/T5sR62MnCX");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "==================================================");
    }


    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[UltraDeathMessages]: Disabled");
    }
}
