package com.redewand.proxyserver.manager;

import com.redewand.proxyserver.utils.MaintenanceUtils;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PostLogin implements Listener {
    @EventHandler
    public void onLogin(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
            if (MaintenanceUtils.Motd==true) {
            if (!player.hasPermission("wand.staff.hight")) {
                player.disconnect(
                        "§cServidor está em fase de desenvolvimento mais informações em: §e§ndiscord.redewand.com"
                );
            }
        }
    }
}
