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
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.IModInfo;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

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
    addCraftingSlots();
    addInventorySlots(pPlayerInventory);
    addHotbarSlots(pPlayerInventory);
  }

  @Override
  public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
    ItemStack itemStack = ItemStack.EMPTY;
    Slot slot = this.slots.get(pIndex);

    if (slot.hasItem()) {
      ItemStack slotItemStack = slot.getItem();
      itemStack = slotItemStack.copy();

      if (pIndex == 0) {
        this.access.execute(
            (pLevel, pPos) -> slotItemStack.getItem().onCraftedBy(slotItemStack, pLevel, pPlayer));

        if (!this.moveItemStackTo(slotItemStack, 19, 55, true)) {
          return ItemStack.EMPTY;
        }
      } else if (pIndex >= 19 && pIndex < 55) {
        if (!this.moveItemStackTo(slotItemStack, 1, 19, false)) {
          if (pIndex < 37) {
            if (!this.moveItemStackTo(slotItemStack, 46, 55, false)) {
              return ItemStack.EMPTY;
            }
          } else if (!this.moveItemStackTo(slotItemStack, 19, 46, false)) {
            return ItemStack.EMPTY;
          }
        }
      } else if (!this.moveItemStackTo(slotItemStack, 19, 55, false)) {
        return ItemStack.EMPTY;
      }

      if (slotItemStack.isEmpty()) {
        slot.set(ItemStack.EMPTY);
      } else {
        slot.setChanged();
      }

      if (slotItemStack.getCount() == itemStack.getCount()) {
        return ItemStack.EMPTY;
      }

      slot.onTake(pPlayer, slotItemStack);
      if (pIndex == 0) {
        pPlayer.drop(slotItemStack, false);
      }
    }

    return itemStack;
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
    this.access.execute((pLevel, pPos) -> this.clearContainer(pPlayer, this.craftSlots));
  }

  private void addCraftingSlots() {
    this.addSlot(
        new LetterCombinerResultSlot(player, this.craftSlots, this.resultSlots, 0, 80, 61));

    int width = this.craftSlots.getWidth();
    int height = this.craftSlots.getHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        this.addSlot(new Slot(this.craftSlots, x + y * width, 8 + x * 18, 20 + y * 18));
      }
    }
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

  private void setResultItem() {
    if (player.level.isClientSide()) {
    } else if (craftSlots.isEmpty()) {
      this.resultSlots.setItem(0, ItemStack.EMPTY);
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

      String resultString = builder.toString();
      Item resultItem = getItemInMods(resultString);
      this.resultSlots.setItem(0, new ItemStack(resultItem));
    }
  }

  private Item getItemInMods(String resourceName) {
    List<IModInfo> mods = ModList.get().getMods();

    for (IModInfo modInfo : mods) {
      ResourceLocation location = new ResourceLocation(modInfo.getModId(), resourceName);

      if (ForgeRegistries.ITEMS.containsKey(location)) {
        return RegistryObject.create(location, ForgeRegistries.ITEMS).get();
      }
    }

    return Items.AIR;
  }
}
