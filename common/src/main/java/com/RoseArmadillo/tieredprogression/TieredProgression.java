package com.RoseArmadillo.tieredprogression;

import com.RoseArmadillo.tieredprogression.block.ModBlocks;
import com.RoseArmadillo.tieredprogression.item.ModItems;
import com.RoseArmadillo.tieredprogression.menu.ModMenus;
import com.RoseArmadillo.tieredprogression.particle.ModParticles;
import com.RoseArmadillo.tieredprogression.recipe.ModRecipes;

public class TieredProgression {

    public static final String MOD_ID = "tieredprogression";

    public static void init() {
        ModBlocks.register();
        ModItems.register();
        ModMenus.register();
        ModRecipes.register();
        ModParticles.register();
    }
}
