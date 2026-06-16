package com.client.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MenuScreen extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = Identifier.of("minecraftclient", "textures/gui/menu_bg.png");

    public MenuScreen() {
        super(Text.literal("Menu"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        int x = (this.width - 200) / 2;
        int y = (this.height - 200) / 2;
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, 200, 200, 200, 200);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        this.applyBlur(delta);
        this.renderDarkening(context);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
