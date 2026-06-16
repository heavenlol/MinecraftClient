package com.client.client;

import com.client.client.gui.MenuScreen;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class MinecraftclientClient implements ClientModInitializer {
    private static KeyMapping guiKeyMapping;

    @Override
    public void onInitializeClient() {
        guiKeyMapping = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.minecraftclient.open_menu",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.minecraftclient.general"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (guiKeyMapping.consumeClick()) {
                client.setScreen(new MenuScreen());
            }
        });
    }
}
