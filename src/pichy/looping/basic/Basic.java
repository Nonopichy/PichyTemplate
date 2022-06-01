package pichy.looping.basic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import pichy.looping.Looping;
import pichy.player.players.SimplePlayer;
import pichy.util.Position;

public class Basic {
    public static void allPlayers(Looping looping){
        Bukkit.getOnlinePlayers().forEach(p -> looping.execute(new SimplePlayer(p)));
    }
    public static void allPlayersInRadius(Location location, double radius, Looping looping){
        Position.getNearbyEntities(location,radius).forEach(p ->{if(p instanceof Player) looping.execute(new SimplePlayer((Player) p));});
    }
}
