package com.lettercraft.data.slot;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;

public class LetterCombinerResultSlot extends Slot {
  private final CraftingContainer craftSlots;
  private final Player player;
  private int removeCount;

  public LetterCombinerResultSlot(
      Player pPlayer,
      CraftingContainer pCraftSlots,
      Container pContainer,
      int pSlot,
      int pXPosition,
      int pYPosition) {
    super(pContainer, pSlot, pXPosition, pYPosition);
    this.player = pPlayer;
    this.craftSlots = pCraftSlots;
  }

  @Override
  public boolean mayPlace(ItemStack pStack) {
    return false;
  }

  @Override
  public ItemStack remove(int pAmount) {
    if (this.hasItem()) {
      this.removeCount += Math.min(pAmount, this.getItem().getCount());
    }

    return super.remove(pAmount);
  }

  @Override
  protected void onQuickCraft(ItemStack pStack, int pAmount) {
    this.removeCount += pAmount;
    this.checkTakeAchievements(pStack);
  }

  @Override
  protected void onSwapCraft(int pNumItemsCrafted) {
    this.removeCount += pNumItemsCrafted;
  }

  @Override
  protected void checkTakeAchievements(ItemStack pStack) {
    if (this.removeCount > 0) {
      pStack.onCraftedBy(this.player.level(), this.player, this.removeCount);
      net.minecraftforge.event.ForgeEventFactory.firePlayerCraftingEvent(
          this.player, pStack, this.craftSlots);
    }

    Container container = this.container;
    if (container instanceof RecipeCraftingHolder recipecraftingholder) {
      recipecraftingholder.awardUsedRecipes(this.player, this.craftSlots.getItems());
    }

    this.removeCount = 0;
  }

  @Override
  public void onTake(Player pPlayer, ItemStack pStack) {
    this.checkTakeAchievements(pStack);
    CraftingInput.Positioned positionedCraftInput = this.craftSlots.asPositionedCraftInput();
    CraftingInput craftinginput = positionedCraftInput.input();
    int i = positionedCraftInput.left();
    int j = positionedCraftInput.top();
    ForgeHooks.setCraftingPlayer(pPlayer);
    NonNullList<ItemStack> nonnulllist =
        pPlayer
            .level()
            .getRecipeManager()
            .getRemainingItemsFor(RecipeType.CRAFTING, craftinginput, pPlayer.level());
    ForgeHooks.setCraftingPlayer(null);

    for (int k = 0; k < craftinginput.height(); ++k) {
      for (int l = 0; l < craftinginput.width(); ++l) {
        int i1 = l + i + (k + j) * this.craftSlots.getWidth();
        ItemStack slotItem = this.craftSlots.getItem(i1);
        ItemStack listItem = nonnulllist.get(l + k * craftinginput.width());

        if (!slotItem.isEmpty()) {
          this.craftSlots.removeItem(i1, 1);
          slotItem = this.craftSlots.getItem(i1);
        }

        if (!listItem.isEmpty()) {
          if (slotItem.isEmpty()) {
            this.craftSlots.setItem(i1, listItem);
          } else if (ItemStack.isSameItemSameComponents(slotItem, listItem)) {
            this.craftSlots.setItem(i1, listItem);
          } else if (!this.player.getInventory().add(listItem)) {
            this.player.drop(listItem, false);
          }
        }
      }
    }
  }
}
