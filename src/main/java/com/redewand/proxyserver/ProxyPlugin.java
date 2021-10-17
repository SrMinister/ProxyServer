package com.redewand.proxyserver;

import com.redewand.proxyserver.configuration.manager.ConfigurationManager;
import com.redewand.proxyserver.registry.CommandRegistry;
import com.redewand.proxyserver.registry.ListenerRegistry;
import com.redewand.proxyserver.utils.MaintenanceUtils;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;

public class ProxyPlugin extends Plugin {

    public static ProxyPlugin instance;
    public static ConfigurationManager configurationManager;

    public void onEnable() {
        System.out.println("[WandProxy] Habilitado com sucesso.");
        ServerInfo server = ProxyServer.getInstance().getServerInfo("saguao-1");
        registerAll();
        MaintenanceUtils.Motd=false;
        ProxyPlugin.instance = this;
        ProxyPlugin.configurationManager = new ConfigurationManager();
        super.onEnable();
    }

    public void onDisable() {
        System.out.println("[WandProxy] Desabilitado com sucesso.");
        instance = null;
    }

    public static ProxyPlugin getInstance() {
        return ProxyPlugin.instance;
    }

    public void registerAll() {
        CommandRegistry.of().register();
        ListenerRegistry.of().register();
    }
}
