package com.RoseArmadillo.tieredprogression.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ShovelItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import com.RoseArmadillo.tieredprogression.ModTiers;
import com.RoseArmadillo.tieredprogression.TieredProgression;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(TieredProgression.MOD_ID, Registries.ITEM);

	// Items

	public static final RegistrySupplier<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(
				new Item.Properties()
					.arch$tab(CreativeModeTabs.INGREDIENTS))
    );

	// Tools

    public static final RegistrySupplier<Item> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModTiers.COPPER, 3, -2.4f,
                    new Item.Properties()
					.arch$tab(CreativeModeTabs.COMBAT))
    );

	public static final RegistrySupplier<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
	        () -> new ShovelItem(ModTiers.COPPER, 3, -2.4f,
	                new Item.Properties()
					.arch$tab(CreativeModeTabs.TOOLS_AND_UTILITIES))
	);

	public static final RegistrySupplier<Item> COPPER_HOE = ITEMS.register("copper_pickaxe",
	        () -> new CopperPickaxe()
	);

	public static final RegistrySupplier<Item> COPPER_AXE = ITEMS.register("copper_axe",
	        () -> new AxeItem(ModTiers.COPPER, 3, -2.4f,
	                new Item.Properties()
					.arch$tab(CreativeModeTabs.TOOLS_AND_UTILITIES))
	);

	public static final RegistrySupplier<Item> COPPER_PICKAXE = ITEMS.register("copper_hoe",
	        () -> new HoeItem(ModTiers.COPPER, 3, -2.4f,
	                new Item.Properties()
					.arch$tab(CreativeModeTabs.TOOLS_AND_UTILITIES))
	);

	// Armor

	private static final Item.Properties ARMOR_PROPERTIES = 
        new Item.Properties()
            .stacksTo(1)
            .arch$tab(CreativeModeTabs.COMBAT);

	public static final RegistrySupplier<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet", 
        () -> new ArmorItem(
            ModTiers.COPPER_ARMOR_MATERIAL, 
            ArmorItem.Type.HELMET, 
            ARMOR_PROPERTIES
        )
    );

    public static final RegistrySupplier<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", 
        () -> new ArmorItem(
            ModTiers.COPPER_ARMOR_MATERIAL, 
            ArmorItem.Type.CHESTPLATE, 
            ARMOR_PROPERTIES
        )
    );

    public static final RegistrySupplier<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings", 
        () -> new ArmorItem(
            ModTiers.COPPER_ARMOR_MATERIAL, 
            ArmorItem.Type.LEGGINGS, 
            ARMOR_PROPERTIES
        )
    );

    public static final RegistrySupplier<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots", 
        () -> new ArmorItem(
            ModTiers.COPPER_ARMOR_MATERIAL, 
            ArmorItem.Type.BOOTS, 
            ARMOR_PROPERTIES
        )
    );

    public static void register() {
        ITEMS.register();
    }
}
