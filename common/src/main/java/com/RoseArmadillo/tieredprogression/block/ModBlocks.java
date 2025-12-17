package com.RoseArmadillo.tieredprogression.block;

import com.RoseArmadillo.tieredprogression.TieredProgression;
import com.RoseArmadillo.tieredprogression.block.entity.ModBlockEntities;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(TieredProgression.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(TieredProgression.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Block> NETHER_FURNACE = BLOCKS.register("nether_furnace", () -> 
        new NetherFurnaceBlock(BlockBehaviour.Properties.of()
            .strength(5.0f)
            .explosionResistance(6.0f)
            .sound(SoundType.COPPER)
            .requiresCorrectToolForDrops()
        )
    );
    
    public static final RegistrySupplier<Item> NETHER_FURNACE_ITEM = ITEMS.register("nether_furnace", () ->
        new BlockItem(NETHER_FURNACE.get(), 
            new Item.Properties()
			.arch$tab(CreativeModeTabs.FUNCTIONAL_BLOCKS)
        )
    );

    public static void register() {
        BLOCKS.register();
        ITEMS.register();
        ModBlockEntities.register();
    }
}