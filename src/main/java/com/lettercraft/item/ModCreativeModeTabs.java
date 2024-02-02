package com.lettercraft.item;

import com.lettercraft.LetterCraftMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LetterCraftMod.MOD_ID);

  public static final RegistryObject<CreativeModeTab> LETTERCRAFT_TAB =
      CREATIVE_MODE_TABS.register(
          "lettercrafttab",
          () ->
              CreativeModeTab.builder()
                  .title(Component.translatable("creativetab.lettercraft.lettercrafttab_title"))
                  .icon(() -> new ItemStack(ModItems.LETTER_A.get()))
                  .build());

  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
