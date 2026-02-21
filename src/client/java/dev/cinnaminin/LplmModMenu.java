package dev.cinnaminin;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class LplmModMenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return this::createConfigScreen;
    }

    private Screen createConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("LAN Player Limit Modifier"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        builder.getOrCreateCategory(Text.literal("General"))
                .addEntry(entryBuilder.startIntField(
                                Text.literal("Max Players"),
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