package com.redewand.proxyserver.registry;

import com.redewand.proxyserver.ProxyPlugin;
import com.redewand.proxyserver.manager.Motd;
import com.redewand.proxyserver.manager.PostLogin;
import lombok.Data;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.PluginManager;

@Data(staticConstructor = "of")
public class ListenerRegistry {

    public ProxyPlugin plugin;

    public void register() {
            PluginManager pluginManager = ProxyServer.getInstance().getPluginManager();
            pluginManager.registerListener(
                    plugin,
                    new Motd()
            );
            pluginManager.registerListener(
                    plugin,
                    new PostLogin()
            );
    }

}
