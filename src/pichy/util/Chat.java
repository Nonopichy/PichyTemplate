package pichy.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Chat {
    public static void broadcast(String str){
        Bukkit.broadcastMessage(color(str));
    }
    public static void send(Player p, String str){
        p.sendMessage(color(str));
    }
    public static String color(String str){
        return str.replaceAll("&", "\u00A7");
    }
}
