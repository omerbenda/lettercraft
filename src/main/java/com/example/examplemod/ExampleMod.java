package com.example.examplemod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ExampleMod.MOD_ID)
public class ExampleMod {
  public static final String MOD_ID = "lettercraft";
  private static final Logger LOGGER = LogUtils.getLogger();

  public ExampleMod() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void setup(final FMLCommonSetupEvent event) {}

  private void enqueueIMC(final InterModEnqueueEvent event) {}

  private void processIMC(final InterModProcessEvent event) {}

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {}

  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {}
  }
}
