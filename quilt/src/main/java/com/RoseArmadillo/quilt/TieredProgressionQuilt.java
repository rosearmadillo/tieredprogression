package com.RoseArmadillo.quilt;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import com.RoseArmadillo.fabriclike.TieredProgressionFabricLike;

public final class TieredProgressionQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        // Run the Fabric-like setup.
    	TieredProgressionFabricLike.init();
    }
}
