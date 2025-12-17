package com.RoseArmadillo.tieredprogression.menu;

import com.RoseArmadillo.tieredprogression.recipe.ModRecipes;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.inventory.RecipeBookType;

public class NetherFurnaceMenu extends AbstractFurnaceMenu {
    public NetherFurnaceMenu(int id, Inventory playerInv) {
        super(ModMenus.NETHER_FURNACE_MENU.get(), ModRecipes.DRAGON_SMELTING_TYPE.get(), RecipeBookType.BLAST_FURNACE, id, playerInv);
    }

    public NetherFurnaceMenu(int id, Inventory playerInv, Container container, ContainerData data) {
        super(ModMenus.NETHER_FURNACE_MENU.get(), ModRecipes.DRAGON_SMELTING_TYPE.get(), RecipeBookType.BLAST_FURNACE, id, playerInv, container, data);
    }

    @Override
    protected boolean isFuel(ItemStack stack) {
        return stack.is(Items.DRAGON_BREATH);
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedContents contents) {
        // Leave empty; blinds the book
    }

    @Override
    public void clearCraftingContent() {
        // Leave empty
    }

    @Override
    public boolean recipeMatches(Recipe<? super Container> recipe) {
        return recipe.getType() == ModRecipes.DRAGON_SMELTING_TYPE.get();
    }
}