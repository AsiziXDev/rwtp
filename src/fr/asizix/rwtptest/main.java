package fr.asizix.rwtptest;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        System.out.println(" RW TP BY ASIZIX EN CHARGEMENT... ");

        getCommand("rtp").setExecutor(new CommandRTP());

    }
}
