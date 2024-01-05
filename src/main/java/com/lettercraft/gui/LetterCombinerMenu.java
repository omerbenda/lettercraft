package com.lettercraft.gui;

import com.lettercraft.block.ModBlocks;
import com.lettercraft.data.slot.LetterCombinerResultSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LetterCombinerMenu extends AbstractContainerMenu {
  private final CraftingContainer craftSlots = new CraftingContainer(this, 9, 2);
  private final ResultContainer resultSlots = new ResultContainer();
  private final ContainerLevelAccess access;
  private final Player player;

  public LetterCombinerMenu(int pContainerId, Inventory pPlayerInventory) {
    this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
  }

  public LetterCombinerMenu(
      int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
    super(ModMenuTypes.LETTER_COMBINER_MENU.get(), pContainerId);

    this.access = pAccess;
    this.player = pPlayerInventory.player;
    addInventorySlots(pPlayerInventory);
    addHotbarSlots(pPlayerInventory);
    addCraftingSlots();
  }

  @Override
  public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
    return null;
  }

  @Override
  public boolean stillValid(Player pPlayer) {
    return stillValid(this.access, pPlayer, ModBlocks.LETTER_COMBINER.get());
  }

  @Override
  public void slotsChanged(Container pContainer) {
    super.slotsChanged(pContainer);

    this.access.execute((pLevel, pPos) -> setResultItem());
  }

  @Override
  public void removed(Player pPlayer) {
    super.removed(pPlayer);
    this.access.execute((p_39371_, p_39372_) -> this.clearContainer(pPlayer, this.craftSlots));
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

  private void addCraftingSlots() {
    int width = this.craftSlots.getWidth();
    int height = this.craftSlots.getHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        this.addSlot(new Slot(this.craftSlots, x + y * width, 8 + x * 18, 20 + y * 18));
      }
    }

    this.addSlot(
        new LetterCombinerResultSlot(player, this.craftSlots, this.resultSlots, 0, 80, 61));
  }

  private void setResultItem() {
    if (player.level.isClientSide()) {
    } else if (craftSlots.isEmpty()) {
      this.resultSlots.setItem(0, new ItemStack(Items.AIR));
    } else {
      int craftContainerSize = craftSlots.getContainerSize();
      StringBuilder builder = new StringBuilder();
      int startIndex = -1;
      int endIndex = -1;

      for (int index = 0; index < craftContainerSize; index++) {
        Item item = craftSlots.getItem(index).getItem();

        if (item != Items.AIR) {
          if (startIndex == -1) {
            startIndex = index;
          }

          endIndex = index;
        }
      }

      for (int index = startIndex; index <= endIndex; index++) {
        Item item = craftSlots.getItem(index).getItem();
        builder.append(item == Items.AIR ? '_' : ForgeRegistries.ITEMS.getKey(item).getPath());
      }

      String resultString = "minecraft:" + builder;

      if (ForgeRegistries.ITEMS.containsKey(new ResourceLocation(resultString))) {
        this.resultSlots.setItem(
            0,
            new ItemStack(
                RegistryObject.create(new ResourceLocation(resultString), ForgeRegistries.ITEMS)
                    .get()));
      } else {
        this.resultSlots.setItem(0, new ItemStack(Items.AIR));
      }
    }
  }
}
