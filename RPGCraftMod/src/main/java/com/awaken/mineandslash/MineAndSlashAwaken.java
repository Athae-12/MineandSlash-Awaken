package com.awaken.mineandslash;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;

@Mod(MineAndSlashAwaken.MOD_ID)
public class MineAndSlashAwaken {
    public static final String MOD_ID = "mineandslashawaken";

    public MineAndSlashAwaken() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addListener(this::doServerStuff);
        modEventBus.addListener(this::onLoadComplete);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Common setup code
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Client setup code
    }

    private void doServerStuff(final FMLDedicatedServerSetupEvent event) {
        // Server setup code
    }

    private void onLoadComplete(final FMLLoadCompleteEvent event) {
        // Load complete code
    }
}
