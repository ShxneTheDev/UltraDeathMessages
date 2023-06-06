package com.shanedev.ultradeathmessages.events;

import com.shanedev.ultradeathmessages.config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class DeathEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        String victim = event.getEntity().getPlayer().getName();
        String killer = event.getEntity().getKiller().getName();


        if(event.getDeathMessage().contains(victim + " was shot by " + victim)) {
            String SelfDeathMessage = config.get().getString("DeathBySelf").replace("%killer%", victim).replace("%victim%", victim).replace("&", "§");
            event.setDeathMessage(SelfDeathMessage);

        }


        if(event.getDeathMessage().contains("was slain by")) {
            String SwordDeathMessage = config.get().getString("DeathBySword").replace("%killer%", killer).replace("%victim%", victim).replace("&", "§");
            event.setDeathMessage(SwordDeathMessage);
        }

        if(event.getDeathMessage().contains("was shot by")) {
            String BowDeathMessage = config.get().getString("DeathByBow").replace("%killer%", killer).replace("%victim%", victim).replace("&", "§");
            event.setDeathMessage(BowDeathMessage);
        }

        if(event.getDeathMessage().contains("took their own")) {
            event.setDeathMessage("");
        }

        if(event.getDeathMessage().contains("died")) {
            event.setDeathMessage("");
        }

        if(event.getDeathMessage().contains("fell out of the world")) {
            event.setDeathMessage("");
        }
    }


}
