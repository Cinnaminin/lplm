package dev.cinnaminin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class lplmConfig {

    public int maxPlayers = 8;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Path path;
    public static lplmConfig INSTANCE;
    public static void load(Path configDir) {
        path = configDir.resolve("lplm.json");
        if (Files.exists(path)) {
            try {
                INSTANCE = GSON.fromJson(Files.readString(path), lplmConfig.class);
            } catch (Exception e) {
                INSTANCE = new lplmConfig();
                save();
            }
        } else {
            INSTANCE = new lplmConfig();
            save();
        }
    }

    public static void save() {
        try {
            Files.writeString(path, GSON.toJson(INSTANCE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}