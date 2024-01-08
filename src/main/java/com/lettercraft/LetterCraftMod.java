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
  }

  private void commonSetup(final FMLCommonSetupEvent event) {}

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
