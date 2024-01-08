package com.lettercraft.item;

import com.lettercraft.LetterCraftMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LetterCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
  public static CreativeModeTab LETTERCRAFT_TAB =
      new CreativeModeTab("lettercraft_tab") {
        @Override
        public ItemStack makeIcon() {
          return new ItemStack(ModItems.LETTER_A.get());
        }
      };
}
