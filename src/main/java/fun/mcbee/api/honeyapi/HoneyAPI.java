package fun.mcbee.api.honeyapi;

import fun.mcbee.api.honeyapi.JSONManager.JsonManager;
import fun.mcbee.api.honeyapi.Regions.BukkitPlayerMoveEvent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.io.File;

public final class HoneyAPI extends JavaPlugin {

    public static HoneyAPI instance;

    @Override
    public void onEnable() {
        instance = this;
        createFolder();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getPluginManager().registerEvents(new BukkitPlayerMoveEvent(), instance);
    }

    private void createFolder() {
        String dir = instance.getServer().getWorldContainer().getAbsolutePath();
        if (dir.endsWith(".")) {
            dir = dir.substring(0, dir.length() - 1);
        }
        File tempFile = new File(dir + "HoneyAPI");
        if (!tempFile.exists()) {
            new File(dir + "HoneyAPI").mkdirs();
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(255, 119, 0)) + "HoneyAPI §7- " + ChatColor.of(new Color(255, 68, 0)) + "HoneyAPI" + " folder was created.");
        }
    }

    private static void defaultFile() {
        JsonManager.createJsonFile("HoneyAPI");
    }
    public static HoneyAPI getInstance(){
        return instance;
    }

    public static void createPluginConfig(Plugin plugin) {
        JsonManager.createJsonFile(plugin.getName());
    }

}
