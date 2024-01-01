package com.lettercraft.gui;

import com.lettercraft.LetterCraftMod;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
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
  protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
    RenderSystem.setShader(GameRenderer::getPositionTexShader);
    RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    RenderSystem.setShaderTexture(0, TEXTURE);
    int x = (width - imageWidth) / 2;
    int y = (height - imageHeight) / 2;
    blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
  }
}
