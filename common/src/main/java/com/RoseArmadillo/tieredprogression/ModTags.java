package com.RoseArmadillo.tieredprogression;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static final TagKey<Block> NEEDS_COPPER_TOOL = TagKey.create(
        Registries.BLOCK, new ResourceLocation("tieredprogression", "needs_copper_tool")
    );
}
