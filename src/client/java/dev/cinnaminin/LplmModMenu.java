package dev.cinnaminin;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class LplmModMenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return this::createConfigScreen;
    }

    private Screen createConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("LAN Player Limit Modifier"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        builder.getOrCreateCategory(Component.literal("General"))
                .addEntry(entryBuilder.startIntField(
                                Component.literal("Max Players"),
                                lplmConfig.INSTANCE.maxPlayers)
                        .setDefaultValue(8)
                        .setMin(1)
                        .setSaveConsumer(value -> {
                            lplmConfig.INSTANCE.maxPlayers = value;
                            lplmConfig.save();
                        })
                        .build()
                );

        return builder.build();
    }
}
