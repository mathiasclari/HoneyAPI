package fun.mcbee.api.honeyapi.BungeeSendPlayer;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fun.mcbee.api.honeyapi.HoneyAPI;
import org.bukkit.entity.Player;

public class SendPlayerToServer {
    public SendPlayerToServer(Player player, String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);
        player.sendPluginMessage(HoneyAPI.instance, "BungeeCord", out.toByteArray());
    }
}
