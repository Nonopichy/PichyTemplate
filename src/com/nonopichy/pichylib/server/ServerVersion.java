package com.nonopichy.pichylib.server;

import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public enum ServerVersion {

    vUnknown("Unknown"),
    v1_7("1.7"),
    v1_8("1.8"),
    v1_9("1.9"),
    v1_10("1.10"),
    v1_11("1.11"),
    v1_12("1.12"),
    v1_13("1.13"),
    v1_14("1.14"),
    v1_15("1.15"),
    v1_16("1.16"),
    v1_17("1.17"),
    v1_18("1.18");

    private static final Map<String, ServerVersion> Versions = new HashMap<>();
    public static ServerVersion getServerVersion(){
        return found(Bukkit.getVersion().split("MC: ")[1].replaceAll("\\)",""));
    }

    static {
        for (ServerVersion e: values())
            Versions.put(e.name(), e);
    }

    public static ServerVersion found(String in){
        for (Map.Entry<String, ServerVersion> e : Versions.entrySet()) {
            if(in.contains(e.getValue().getRaw()) || in.contains(e.getKey().replaceAll("_",".").replaceAll("v", "")))
                return e.getValue();
        }
        return ServerVersion.vUnknown;
    }

    @Getter private final String raw;
    ServerVersion(String raw) {
        this.raw = raw;
    }

}
