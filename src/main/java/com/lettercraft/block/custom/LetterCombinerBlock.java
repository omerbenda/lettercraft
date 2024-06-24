package com.lettercraft.block.custom;

import com.lettercraft.gui.LetterCombinerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class LetterCombinerBlock extends Block {
  private static final Component CONTAINER_TITLE =
      Component.translatable("container.lettercraft.letter_combiner_title");

  public LetterCombinerBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public InteractionResult useWithoutItem(
      BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHit) {
    if (pLevel.isClientSide) {
      return InteractionResult.SUCCESS;
    }

    pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));

    return InteractionResult.CONSUME;
  }

  @Nullable
  @Override
  public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
    return new SimpleMenuProvider(
        (pContainerId, pPlayerInventory, pPlayer) ->
            new LetterCombinerMenu(
                pContainerId, pPlayerInventory, ContainerLevelAccess.create(pLevel, pPos)),
        CONTAINER_TITLE);
  }
}
