package com.nonopichy.pichylib.util;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;
import java.util.List;

public class Position {
    public static List<LivingEntity> getNearbyEntities(Entity entity, double radius){
        return getNearbyEntities(entity.getLocation(), radius);
    }
    public static List<LivingEntity> getNearbyEntities(Location location, double radius){
        List<LivingEntity> list = new ArrayList<>();
        for (Entity entity : location.getChunk().getEntities()) {
            if(entity instanceof LivingEntity && location.distance(entity.getLocation()) <= radius)
                list.add((LivingEntity) entity);
        }
        return list;
    }
}
