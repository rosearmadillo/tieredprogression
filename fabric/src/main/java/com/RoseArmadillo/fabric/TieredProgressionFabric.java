package com.RoseArmadillo.fabric;

import net.fabricmc.api.ModInitializer;

import com.RoseArmadillo.fabriclike.TieredProgressionFabricLike;

public final class TieredProgressionFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run the Fabric-like setup.
    	TieredProgressionFabricLike.init();
    }
}
