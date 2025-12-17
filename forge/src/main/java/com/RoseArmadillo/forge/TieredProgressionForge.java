package com.RoseArmadillo.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraft.client.particle.FlameParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

import com.RoseArmadillo.tieredprogression.TieredProgression;
import com.RoseArmadillo.tieredprogression.TieredProgressionClient;
import com.RoseArmadillo.tieredprogression.particle.ModParticles;

@Mod("tieredprogression")
public final class TieredProgressionForge {
    public TieredProgressionForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(TieredProgression.MOD_ID, eventBus);

        TieredProgression.init();

        if (FMLEnvironment.dist == Dist.CLIENT) {
            eventBus.addListener(this::onClientSetup);
            eventBus.addListener(this::onRegisterParticleProviders);
        }
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        TieredProgressionClient.initScreens(); 
    }

    private void onRegisterParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.DRAGON_FLAME.get(), FlameParticle.Provider::new);
    }
}