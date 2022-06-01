package com.nonopichy.pichylib.looping.basic;

import com.nonopichy.pichylib.looping.Looping;
import com.nonopichy.pichylib.player.players.SimplePlayer;
import com.nonopichy.pichylib.util.Position;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Basic {
    public static void allPlayers(Looping looping){
        Bukkit.getOnlinePlayers().forEach(p -> looping.execute(new SimplePlayer(p)));
    }
    public static void allPlayersInRadius(Location location, double radius, Looping looping){
        Position.getNearbyEntities(location,radius).forEach(p ->{if(p instanceof Player) looping.execute(new SimplePlayer((Player) p));});
    }
}
