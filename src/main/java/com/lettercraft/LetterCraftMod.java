package com.lettercraft;

import com.lettercraft.block.ModBlocks;
import com.lettercraft.gui.LetterCombinerScreen;
import com.lettercraft.gui.ModMenuTypes;
import com.lettercraft.item.ModItems;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LetterCraftMod.MOD_ID)
public class LetterCraftMod {
  public static final String MOD_ID = "lettercraft";

  public LetterCraftMod() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    ModItems.register(modEventBus);
    ModBlocks.register(modEventBus);
    ModMenuTypes.register(modEventBus);
    modEventBus.addListener(this::commonSetup);
    MinecraftForge.EVENT_BUS.register(this);
    //modEventBus.addListener(this::addCreative);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {}

  //private void addCreative(CreativeModeTabEvent.BuildContents event) {
  //  if (event.getTab().equals(ModCreativeModeTabs.LETTERCRAFT_TAB)) {
  //    event.accept(ModBlocks.LETTER_EXTRACTOR);
  //    event.accept(ModBlocks.LETTER_COMBINER);
  //    event.accept(ModItems.LETTER_A);
  //    event.accept(ModItems.LETTER_B);
  //    event.accept(ModItems.LETTER_C);
  //    event.accept(ModItems.LETTER_D);
  //    event.accept(ModItems.LETTER_E);
  //    event.accept(ModItems.LETTER_F);
  //    event.accept(ModItems.LETTER_G);
  //    event.accept(ModItems.LETTER_H);
  //    event.accept(ModItems.LETTER_I);
  //    event.accept(ModItems.LETTER_J);
  //    event.accept(ModItems.LETTER_K);
  //    event.accept(ModItems.LETTER_L);
  //    event.accept(ModItems.LETTER_M);
  //    event.accept(ModItems.LETTER_N);
  //    event.accept(ModItems.LETTER_O);
  //    event.accept(ModItems.LETTER_P);
  //    event.accept(ModItems.LETTER_Q);
  //    event.accept(ModItems.LETTER_R);
  //    event.accept(ModItems.LETTER_S);
  //    event.accept(ModItems.LETTER_T);
  //    event.accept(ModItems.LETTER_U);
  //    event.accept(ModItems.LETTER_V);
  //    event.accept(ModItems.LETTER_W);
  //    event.accept(ModItems.LETTER_X);
  //    event.accept(ModItems.LETTER_Y);
  //    event.accept(ModItems.LETTER_Z);
  //  }
  //}

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {}

  @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
      MenuScreens.register(ModMenuTypes.LETTER_COMBINER_MENU.get(), LetterCombinerScreen::new);
    }
  }
}
