package fun.mcbee.api.honeyapi.BungeeSendPlayer;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fun.mcbee.api.honeyapi.HoneyAPI;
import org.bukkit.entity.Player;

public class Bungee {
    public static void sendPlayerToServer(Player player, String server) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeUTF("Connect");
        byteArrayDataOutput.writeUTF(server);
        player.sendPluginMessage(HoneyAPI.instance, "BungeeCord", byteArrayDataOutput.toByteArray());
    }
}
