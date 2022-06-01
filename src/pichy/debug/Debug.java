package pichy.debug;

import org.bukkit.Bukkit;
import pichy.util.Chat;

import java.lang.reflect.Field;

public class Debug {

    public static void anyObject(Object o){
        Field[] fields = o.getClass().getDeclaredFields();
        print("&c&m-------------- &6&l"+o.getClass().getName()+" &c&m---------------");
        for (int i=0; i<fields.length; i++) {
            Field current = fields[i];
            try {
                current.setAccessible(true);
                print(" &aName -> ("+current.getName()+")");
                print("  &2Value -> ("+current.get(o)+")");
            } catch (Exception e){
                print("&4Exception! Index -> ("+i+")");
            }
        }
        print("&c&m------------------------------");
    }

    public static void anyObject(Object... o){
        for (Object o1 : o) {
            anyObject(o1);
        }
    }

    public static void print(String str){
        Bukkit.getConsoleSender().sendMessage(Chat.color(str));
    }
}
