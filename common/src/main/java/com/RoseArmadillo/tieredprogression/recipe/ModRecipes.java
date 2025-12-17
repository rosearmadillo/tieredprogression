package com.RoseArmadillo.tieredprogression.recipe;

import com.RoseArmadillo.tieredprogression.TieredProgression;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = 
            DeferredRegister.create(TieredProgression.MOD_ID, Registries.RECIPE_TYPE);
    
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = 
            DeferredRegister.create(TieredProgression.MOD_ID, Registries.RECIPE_SERIALIZER);

    // FIX: Using a simple anonymous class or the specific cast to satisfy the register method
    public static final RegistrySupplier<RecipeType<DragonSmeltingRecipe>> DRAGON_SMELTING_TYPE = 
            RECIPE_TYPES.register("dragon_smelting", () -> new RecipeType<DragonSmeltingRecipe>() {
                @Override
                public String toString() {
                    return "dragon_smelting";
                }
            });

    public static final RegistrySupplier<RecipeSerializer<DragonSmeltingRecipe>> DRAGON_SMELTING_SERIALIZER = 
        SERIALIZERS.register("dragon_smelting", () -> new DragonSmeltingRecipe.Serializer(100));

    public static void register() {
        RECIPE_TYPES.register();
        SERIALIZERS.register();
    }
}