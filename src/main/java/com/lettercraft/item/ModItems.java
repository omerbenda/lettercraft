package com.lettercraft.item;

import com.lettercraft.LetterCraftMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, LetterCraftMod.MOD_ID);

  public static final RegistryObject<Item> LETTER_A =
      ITEMS.register(
          "a", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_B =
      ITEMS.register(
          "b", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_C =
      ITEMS.register(
          "c", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_D =
      ITEMS.register(
          "d", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_E =
      ITEMS.register(
          "e", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_F =
      ITEMS.register(
          "f", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_G =
      ITEMS.register(
          "g", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_H =
      ITEMS.register(
          "h", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_I =
      ITEMS.register(
          "i", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_J =
      ITEMS.register(
          "j", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_K =
      ITEMS.register(
          "k", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_L =
      ITEMS.register(
          "l", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_M =
      ITEMS.register(
          "m", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_N =
      ITEMS.register(
          "n", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_O =
      ITEMS.register(
          "o", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_P =
      ITEMS.register(
          "p", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_Q =
      ITEMS.register(
          "q", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_R =
      ITEMS.register(
          "r", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_S =
      ITEMS.register(
          "s", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_T =
      ITEMS.register(
          "t", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_U =
      ITEMS.register(
          "u", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_V =
      ITEMS.register(
          "v", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_W =
      ITEMS.register(
          "w", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_X =
      ITEMS.register(
          "x", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_Y =
      ITEMS.register(
          "y", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));
  public static final RegistryObject<Item> LETTER_Z =
      ITEMS.register(
          "z", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.LETTERCRAFT_TAB)));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
