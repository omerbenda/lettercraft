package com.lettercraft.data.slot;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
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
    ForgeHooks.setCraftingPlayer(pPlayer);
    Level level = pPlayer.level();
    NonNullList<ItemStack> remainingItems =
        level.getRecipeManager().getRemainingItemsFor(RecipeType.CRAFTING, this.craftSlots, level);
    ForgeHooks.setCraftingPlayer(null);

    for (int index = 0; index < remainingItems.size(); ++index) {
      ItemStack itemStack = this.craftSlots.getItem(index);
      ItemStack remainingStack = remainingItems.get(index);
      if (!itemStack.isEmpty()) {
        this.craftSlots.removeItem(index, 1);
        itemStack = this.craftSlots.getItem(index);
      }

      if (!remainingStack.isEmpty()) {
        if (itemStack.isEmpty()) {
          this.craftSlots.setItem(index, remainingStack);
        } else if (ItemStack.isSameItem(itemStack, remainingStack)
            && ItemStack.isSameItemSameComponents(itemStack, remainingStack)) {
        } else if (!this.player.getInventory().add(remainingStack)) {
          this.player.drop(remainingStack, false);
        }
      }
    }
  }
}
