package com.RoseArmadillo.tieredprogression.menu;

import com.RoseArmadillo.tieredprogression.TieredProgression;
import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = 
        DeferredRegister.create(TieredProgression.MOD_ID, Registries.MENU);

    public static final RegistrySupplier<MenuType<NetherFurnaceMenu>> NETHER_FURNACE_MENU = 
        MENUS.register("nether_furnace_menu", () -> 
            MenuRegistry.ofExtended((id, inv, data) -> new NetherFurnaceMenu(id, inv)));

    public static void register() {
        MENUS.register();
    }
}