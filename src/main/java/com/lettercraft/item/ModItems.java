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
      ITEMS.register("letter_a", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_B =
      ITEMS.register("letter_b", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_C =
      ITEMS.register("letter_c", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_D =
      ITEMS.register("letter_d", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_E =
      ITEMS.register("letter_e", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_F =
      ITEMS.register("letter_f", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_G =
      ITEMS.register("letter_g", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_H =
      ITEMS.register("letter_h", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_I =
      ITEMS.register("letter_i", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_J =
      ITEMS.register("letter_j", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_K =
      ITEMS.register("letter_k", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_L =
      ITEMS.register("letter_l", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_M =
      ITEMS.register("letter_m", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_N =
      ITEMS.register("letter_n", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_O =
      ITEMS.register("letter_o", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_P =
      ITEMS.register("letter_p", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_Q =
      ITEMS.register("letter_q", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_R =
      ITEMS.register("letter_r", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_S =
      ITEMS.register("letter_s", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_T =
      ITEMS.register("letter_t", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_U =
      ITEMS.register("letter_u", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_V =
      ITEMS.register("letter_v", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_W =
      ITEMS.register("letter_w", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_X =
      ITEMS.register("letter_x", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_Y =
      ITEMS.register("letter_y", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LETTER_Z =
      ITEMS.register("letter_z", () -> new Item(new Item.Properties()));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
