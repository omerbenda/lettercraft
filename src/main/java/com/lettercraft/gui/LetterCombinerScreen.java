package com.lettercraft.gui;

import com.lettercraft.LetterCraftMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LetterCombinerScreen extends AbstractContainerScreen<LetterCombinerMenu> {
  private static final ResourceLocation TEXTURE =
      new ResourceLocation(LetterCraftMod.MOD_ID, "textures/gui/letter_combiner_gui.png");

  public LetterCombinerScreen(
      LetterCombinerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
    super(pMenu, pPlayerInventory, pTitle);
  }

  @Override
  public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
    super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    renderTooltip(pGuiGraphics, pMouseX, pMouseY);
  }

  @Override
  protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
    int x = (width - imageWidth) / 2;
    int y = (height - imageHeight) / 2;
    pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
  }
}
