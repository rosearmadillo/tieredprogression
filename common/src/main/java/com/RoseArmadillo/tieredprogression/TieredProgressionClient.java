package com.RoseArmadillo.tieredprogression;

import com.RoseArmadillo.tieredprogression.menu.ModMenus;
import com.RoseArmadillo.tieredprogression.particle.ModParticles;
import com.RoseArmadillo.tieredprogression.client.gui.screen.NetherFurnaceScreen;

import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.client.particle.FlameParticle;

public class TieredProgressionClient {
    public static void init() {
        initScreens();
        initParticles();
    }

    public static void initParticles() {
        ParticleProviderRegistry.register(ModParticles.DRAGON_FLAME.get(), FlameParticle.Provider::new);
    }

    public static void initScreens() {
        MenuRegistry.registerScreenFactory(ModMenus.NETHER_FURNACE_MENU.get(), NetherFurnaceScreen::new);
    }
}