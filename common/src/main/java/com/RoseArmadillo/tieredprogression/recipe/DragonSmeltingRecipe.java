package com.RoseArmadillo.tieredprogression.recipe;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.core.registries.BuiltInRegistries;

public class DragonSmeltingRecipe extends AbstractCookingRecipe {
    public DragonSmeltingRecipe(ResourceLocation id, String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(ModRecipes.DRAGON_SMELTING_TYPE.get(), id, group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.DRAGON_SMELTING_SERIALIZER.get();
    }

    public static class Serializer implements RecipeSerializer<DragonSmeltingRecipe> {
        private final int defaultCookingTime;

        public Serializer(int defaultCookingTime) {
            this.defaultCookingTime = defaultCookingTime;
        }

        @Override
        public DragonSmeltingRecipe fromJson(ResourceLocation id, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            CookingBookCategory category = CookingBookCategory.CODEC.byName(GsonHelper.getAsString(json, "category", null), CookingBookCategory.MISC);
            Ingredient ingredient = json.has("ingredient") ? Ingredient.fromJson(json.get("ingredient")) : Ingredient.EMPTY;
            
            // Handle result item
            String resultStr = GsonHelper.getAsString(json, "result");
            ResourceLocation resourcelocation = new ResourceLocation(resultStr);
            ItemStack resultStack = new ItemStack(BuiltInRegistries.ITEM.getOptional(resourcelocation).orElseThrow(() -> new IllegalStateException("Item: " + resultStr + " does not exist")));
            
            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            int cookingTime = GsonHelper.getAsInt(json, "cookingtime", this.defaultCookingTime);
            
            return new DragonSmeltingRecipe(id, group, category, ingredient, resultStack, experience, cookingTime);
        }

        @Override
        public DragonSmeltingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            String group = buf.readUtf();
            CookingBookCategory category = buf.readEnum(CookingBookCategory.class);
            Ingredient ingredient = Ingredient.fromNetwork(buf);
            ItemStack result = buf.readItem();
            float experience = buf.readFloat();
            int cookingTime = buf.readVarInt();
            return new DragonSmeltingRecipe(id, group, category, ingredient, result, experience, cookingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, DragonSmeltingRecipe recipe) {
            buf.writeUtf(recipe.group);
            buf.writeEnum(recipe.category());
            recipe.ingredient.toNetwork(buf);
            buf.writeItem(recipe.result);
            buf.writeFloat(recipe.experience);
            buf.writeVarInt(recipe.cookingTime);
        }
    }
}