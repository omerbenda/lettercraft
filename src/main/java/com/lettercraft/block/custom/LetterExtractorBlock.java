package com.lettercraft.block.custom;

import com.lettercraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LetterExtractorBlock extends Block {
  public LetterExtractorBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public InteractionResult use(
      BlockState pState,
      Level pLevel,
      BlockPos pPos,
      Player pPlayer,
      InteractionHand pHand,
      BlockHitResult pHit) {
    if (pHand == InteractionHand.MAIN_HAND) {
      ItemStack useItemStack = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);
      Item useItem = useItemStack.getItem();

      if (useItem != Items.AIR) {
        String itemName = ForgeRegistries.ITEMS.getKey(useItem).getPath();
        SpawnLetters(pLevel, pPos, countLetters(itemName));

        if (!pPlayer.isCreative()) {
          useItemStack.setCount(useItemStack.getCount() - 1);
        }

        return InteractionResult.SUCCESS;
      }
    }

    return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
  }

  private HashMap<Character, Integer> countLetters(String word) {
    HashMap<Character, Integer> lettersList = new HashMap<>();

    for (int index = 0; index < word.length(); index++) {
      char letter = word.charAt(index);

      if (letter != '_') {
        lettersList.put(letter, lettersList.getOrDefault(letter, 0) + 1);
      }
    }

    return lettersList;
  }

  private void SpawnLetters(Level level, BlockPos pos, Map<Character, Integer> letterCounts) {
    Set<Character> letters = letterCounts.keySet();

    for (char letter : letters) {
      Item letterItem =
          switch (letter) {
            case 'a':
              yield ModItems.LETTER_A.get();
            case 'b':
              yield ModItems.LETTER_B.get();
            case 'c':
              yield ModItems.LETTER_C.get();
            case 'd':
              yield ModItems.LETTER_D.get();
            case 'e':
              yield ModItems.LETTER_E.get();
            case 'f':
              yield ModItems.LETTER_F.get();
            case 'g':
              yield ModItems.LETTER_G.get();
            case 'h':
              yield ModItems.LETTER_H.get();
            case 'i':
              yield ModItems.LETTER_I.get();
            case 'j':
              yield ModItems.LETTER_J.get();
            case 'k':
              yield ModItems.LETTER_K.get();
            case 'l':
              yield ModItems.LETTER_L.get();
            case 'm':
              yield ModItems.LETTER_M.get();
            case 'n':
              yield ModItems.LETTER_N.get();
            case 'o':
              yield ModItems.LETTER_O.get();
            case 'p':
              yield ModItems.LETTER_P.get();
            case 'q':
              yield ModItems.LETTER_Q.get();
            case 'r':
              yield ModItems.LETTER_R.get();
            case 's':
              yield ModItems.LETTER_S.get();
            case 't':
              yield ModItems.LETTER_T.get();
            case 'u':
              yield ModItems.LETTER_U.get();
            case 'v':
              yield ModItems.LETTER_V.get();
            case 'w':
              yield ModItems.LETTER_W.get();
            case 'x':
              yield ModItems.LETTER_X.get();
            case 'y':
              yield ModItems.LETTER_Y.get();
            case 'z':
              yield ModItems.LETTER_Z.get();
            default:
              yield null;
          };

      if (letterItem != null) {
        level.addFreshEntity(
            new ItemEntity(
                level,
                pos.getX(),
                pos.getY(),
                pos.getZ(),
                new ItemStack(letterItem, letterCounts.get(letter))));
      }
    }
  }
}
