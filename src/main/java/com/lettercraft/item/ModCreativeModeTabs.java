package com.lettercraft.item;

import com.lettercraft.LetterCraftMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LetterCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
  public static CreativeModeTab LETTERCRAFT_TAB;

  //@SubscribeEvent
  //public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
  //  LETTERCRAFT_TAB =
  //      event.registerCreativeModeTab(
  //          new ResourceLocation(LetterCraftMod.MOD_ID, "lettercrafttab"),
  //          builder ->
  //              builder
  //                  .icon(() -> new ItemStack(ModItems.LETTER_A.get()))
  //                  .title(Component.translatable("creativetab.lettercraft.lettercrafttab_title")));
  //}
}
