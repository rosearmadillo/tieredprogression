package com.RoseArmadillo.fabric.client;

import com.RoseArmadillo.tieredprogression.TieredProgressionClient;

import net.fabricmc.api.ClientModInitializer;

public final class TieredProgressionFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TieredProgressionClient.init();
    }
}
