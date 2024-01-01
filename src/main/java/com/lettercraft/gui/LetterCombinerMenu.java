package com.lettercraft.gui;

import com.lettercraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LetterCombinerMenu extends AbstractContainerMenu {
  private final Level level;
  private final BlockPos blockPos;

  public LetterCombinerMenu(
      int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf pExtraData) {
    this(pContainerId, pPlayerInventory, pExtraData.readBlockPos());
  }

  public LetterCombinerMenu(int pContainerId, Inventory pPlayerInventory, BlockPos pBlockPos) {
    super(ModMenuTypes.LETTER_COMBINER_MENU.get(), pContainerId);

    this.level = pPlayerInventory.player.level;
    this.blockPos = pBlockPos;

    addInventorySlots(pPlayerInventory);
    addHotbarSlots(pPlayerInventory);
  }

  @Override
  public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
    return null;
  }

  @Override
  public boolean stillValid(Player pPlayer) {
    return stillValid(
        ContainerLevelAccess.create(level, blockPos), pPlayer, ModBlocks.LETTER_COMBINER.get());
  }

  private void addInventorySlots(Inventory pPlayerInventory) {
    for (int y = 0; y < 3; ++y) {
      for (int x = 0; x < 9; ++x) {
        this.addSlot(new Slot(pPlayerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
      }
    }
  }

  private void addHotbarSlots(Inventory pPlayerInventory) {
    for (int x = 0; x < 9; ++x) {
      this.addSlot(new Slot(pPlayerInventory, x, 8 + x * 18, 142));
    }
  }
}
