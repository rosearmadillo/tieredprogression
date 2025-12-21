package com.RoseArmadillo.tieredprogression.block.entity;

import org.jetbrains.annotations.Nullable;

import com.RoseArmadillo.tieredprogression.menu.NetherFurnaceMenu;
import com.RoseArmadillo.tieredprogression.recipe.ModRecipes;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherFurnaceBlockEntity extends AbstractFurnaceBlockEntity implements ExtendedMenuProvider  {
    public NetherFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.NETHER_FURNACE_BLOCK_ENTITY.get(), pos, state, ModRecipes.DRAGON_SMELTING_TYPE.get());
    }

    public static boolean isFuel(ItemStack stack) {
      return stack.is(Items.DRAGON_BREATH);
   }

   public static void serverTick(Level level, BlockPos pos, BlockState state, NetherFurnaceBlockEntity blockEntity) {
        ItemStack fuelBefore = blockEntity.items.get(1).copy();
        int countBefore = fuelBefore.getCount();

        AbstractFurnaceBlockEntity.serverTick(level, pos, state, blockEntity);

        ItemStack fuelAfter = blockEntity.items.get(1);
        
        if (fuelAfter.is(Items.GLASS_BOTTLE)) {
            if (countBefore > 1) {
                fuelBefore.shrink(1);
                blockEntity.items.set(1, fuelBefore);
            } else {
                blockEntity.items.set(1, ItemStack.EMPTY);
            }
        }
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.tieredprogression.nether_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new NetherFurnaceMenu(id, player, this, this.dataAccess);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.tieredprogression.nether_furnace");
    }

    @Override
    public int getBurnDuration(ItemStack fuel) {
        return isFuel(fuel) ? 400 : 0;
    }

    // Override this to prevent the furnace from seeing the Glass Bottle as a remainder
    @Override
    public void setChanged() {
        ItemStack fuelStack = this.items.get(1);
        if (fuelStack.is(Items.GLASS_BOTTLE)) {
            this.items.set(1, ItemStack.EMPTY);
        }
        super.setChanged();
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else if (index == 1) {
            return isFuel(stack);
        } else {
            return true;
        }
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        if (index == 1 && stack.is(Items.GLASS_BOTTLE)) {
            // Just ignore the bottle it'll probably be fine
            return; 
        } else{
            super.setItem(index, stack);
        }
    }
    
    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.NETHER_FURNACE_BLOCK_ENTITY.get();
    }



    @Override
    public void saveExtraData(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.getBlockPos());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new NetherFurnaceMenu(containerId, playerInventory, this, this.dataAccess);
    }
}