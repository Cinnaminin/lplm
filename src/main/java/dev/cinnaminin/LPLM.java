package dev.cinnaminin;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class LPLM implements ModInitializer {

    public static lplmConfig CONFIG;

    @Override
    public void onInitialize() {
        lplmConfig.load(FabricLoader.getInstance().getConfigDir());
        CONFIG = lplmConfig.INSTANCE;
    }
}