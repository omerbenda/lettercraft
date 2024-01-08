package com.lettercraft.block;

import com.lettercraft.LetterCraftMod;
import com.lettercraft.block.custom.LetterCombinerBlock;
import com.lettercraft.block.custom.LetterExtractorBlock;
import com.lettercraft.item.ModCreativeModeTabs;
import com.lettercraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, LetterCraftMod.MOD_ID);

  public static final RegistryObject<LetterExtractorBlock> LETTER_EXTRACTOR =
      registerBlock(
          "letter_extractor",
          () ->
              new LetterExtractorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(6.0f)),
          ModCreativeModeTabs.LETTERCRAFT_TAB);

  public static final RegistryObject<LetterCombinerBlock> LETTER_COMBINER =
      registerBlock(
          "letter_combiner",
          () -> new LetterCombinerBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(6.0f)),
          ModCreativeModeTabs.LETTERCRAFT_TAB);

  private static <T extends Block> RegistryObject<T> registerBlock(
      String name, Supplier<T> block, CreativeModeTab tab) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn, tab);

    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(
      String name, RegistryObject<T> block, CreativeModeTab tab) {
    return ModItems.ITEMS.register(
        name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
