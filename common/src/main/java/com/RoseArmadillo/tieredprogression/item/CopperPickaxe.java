package com.RoseArmadillo.tieredprogression.item;

import com.RoseArmadillo.tieredprogression.ModTags;
import com.RoseArmadillo.tieredprogression.ModTiers;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;

public class CopperPickaxe extends PickaxeItem {
    public CopperPickaxe(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    public CopperPickaxe() {
        super(ModTiers.COPPER, 3, -2.4f, new Item.Properties().arch$tab(CreativeModeTabs.TOOLS_AND_UTILITIES));
    }
    
    /**
     * Overrides the default PickaxeItem logic to also check for if the block is tagged with NEEDS_COPPER_TOOL
     * * @param state The BlockState being checked.
     * @return True if the tool is correct for the block.
     */
    @Override
    public boolean isCorrectToolForDrops(BlockState state) {

        if (state.is(ModTags.NEEDS_COPPER_TOOL)) {
            return true;
        }

        return super.isCorrectToolForDrops(state);
    }
}
