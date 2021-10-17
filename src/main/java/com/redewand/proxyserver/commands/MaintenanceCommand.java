package com.redewand.proxyserver.commands;

import com.redewand.proxyserver.ProxyPlugin;
import com.redewand.proxyserver.utils.MaintenanceUtils;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MaintenanceCommand {


    @Command(
            name = "manutencao",
            permission = "wand.staff.hight"

    )
    public void handleMaintenance(Context<ProxiedPlayer> context) {
        val sender = (CommandSender) context.getSender();
        if(MaintenanceUtils.Motd==false) {
            MaintenanceUtils.Motd=true;
                for (ProxiedPlayer allplayers : ProxyPlugin.getInstance().getProxy().getPlayers()) {
                    sender.sendMessage(
                            "§cManutenção habilitada com êxito."
                    );
                    allplayers.disconnect(
                            "§c§lWAND" +
                                     "\n§r" +
                                     "\n" +
                                     "§cO servidor iniciou uma manutenção, voltamos em breve!" +
                                     "\n§r" +
                                     "\n" +
                                     "§cFique por dentro de tudo que está acontecendo!" +
                                     "\n " +
                                     "§cAcesse o nosso twitter @ServidorWand!"
                    );
            }
        } else {
            if(MaintenanceUtils.Motd==true) {
                MaintenanceUtils.Motd = false;
                sender.sendMessage(
                        "§cManutenção desabilitada com êxito."
                );
            }
        }
    }
}
