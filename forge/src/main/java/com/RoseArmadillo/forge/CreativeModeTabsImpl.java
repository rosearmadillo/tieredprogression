package com.RoseArmadillo.forge;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.RoseArmadillo.tieredprogression.item.ModItems;

@Mod.EventBusSubscriber(modid = "tieredprogression", bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeModeTabsImpl {
    @SubscribeEvent
    public static void addItems(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
        	event.accept(ModItems.COPPER_SWORD.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
        	event.accept(ModItems.COPPER_SHOVEL.get());
        	event.accept(ModItems.COPPER_PICKAXE.get());
        	event.accept(ModItems.COPPER_AXE.get());
        	event.accept(ModItems.COPPER_HOE.get());
        }
    }
}
