package com.RoseArmadillo.tieredprogression.block.entity;

import com.RoseArmadillo.tieredprogression.TieredProgression;
import com.RoseArmadillo.tieredprogression.block.ModBlocks;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
        DeferredRegister.create(TieredProgression.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<NetherFurnaceBlockEntity>> NETHER_FURNACE_BLOCK_ENTITY = 
        BLOCK_ENTITIES.register("nether_furnace_block_entity", () -> 
            BlockEntityType.Builder.of(NetherFurnaceBlockEntity::new, ModBlocks.NETHER_FURNACE.get()).build(null));

    public static void register() {
        BLOCK_ENTITIES.register();
    }
}