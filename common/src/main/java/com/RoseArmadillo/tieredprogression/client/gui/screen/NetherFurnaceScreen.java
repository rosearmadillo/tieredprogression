package com.RoseArmadillo.tieredprogression.client.gui.screen;

import com.RoseArmadillo.tieredprogression.TieredProgression;
import com.RoseArmadillo.tieredprogression.menu.NetherFurnaceMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class NetherFurnaceScreen extends AbstractContainerScreen<NetherFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TieredProgression.MOD_ID, "textures/gui/container/nether_furnace.png");

    public NetherFurnaceScreen(NetherFurnaceMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics); 
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY); 
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = this.leftPos;
        int y = this.topPos;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

        if (this.menu.isLit()) {
            int litProgress = this.menu.getLitProgress(); 
            guiGraphics.blit(TEXTURE, x + 56, y + 36 + 12 - litProgress, 176, 12 - litProgress, 14, litProgress + 1);
        }

        int burnProgress = this.menu.getBurnProgress(); 
        guiGraphics.blit(TEXTURE, x + 79, y + 34, 176, 14, burnProgress + 1, 16);
    }
}