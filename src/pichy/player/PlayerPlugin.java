package pichy.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import pichy.util.Chat;
import pichy.util.Position;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public abstract class PlayerPlugin {
    public static final HashMap<String, Object> temp = new HashMap<>();
    public Object getTemp(String key){return PlayerPlugin.temp.get(player.getName()+":"+key);}
    public void setTemp(String key, Object o){PlayerPlugin.temp.put(player.getName()+":"+key, o);};

    @Getter public Player player;

    /**
     * Send messages with converted colors using the & character.
     */
    public void sendMessage(String str){
        Chat.send(player, str);
    }
    public List<LivingEntity> getNearbyEntities(double radius){ return Position.getNearbyEntities(player.getLocation(), radius); }
}
