package com.RoseArmadillo.tieredprogression.particle;

import com.RoseArmadillo.tieredprogression.TieredProgression;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = 
        DeferredRegister.create(TieredProgression.MOD_ID, Registries.PARTICLE_TYPE);

    public static final RegistrySupplier<SimpleParticleType> DRAGON_FLAME = 
        PARTICLES.register("dragon_flame", () -> new SimpleParticleType(false) {});

    public static void register() {
        PARTICLES.register();
    }
}