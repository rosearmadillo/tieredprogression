package com.RoseArmadillo.tieredprogression;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;

public class ModTiers {
    public static final Tier COPPER = new Tier() {
        @Override
        public int getUses() {
            return 200;
        }

        @Override
        public float getSpeed() {
            return 5.0f;
        }

        @Override
        public float getAttackDamageBonus() {
            return 2.0f;
        }

        @Override
        public int getLevel() {
            return 1;
        }

        @Override
        public int getEnchantmentValue() {
            return 13;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.COPPER_INGOT);
        }
    };

    public static final ArmorMaterial COPPER_ARMOR_MATERIAL = new ArmorMaterial() {
        private static final EnumMap<ArmorItem.Type, Integer> PROTECTION_VALUES = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 3);
            map.put(ArmorItem.Type.CHESTPLATE, 4);
            map.put(ArmorItem.Type.HELMET, 2);
        });
        
        private static final EnumMap<ArmorItem.Type, Integer> DURABILITY = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 143);
            map.put(ArmorItem.Type.LEGGINGS, 165);
            map.put(ArmorItem.Type.CHESTPLATE, 176);
            map.put(ArmorItem.Type.HELMET, 121);
        });

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return PROTECTION_VALUES.get(type);
        }

        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return DURABILITY.get(type); 
        }

        @Override
        public int getEnchantmentValue() {
            return 8;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_IRON;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.0f;
        }

        @Override
        public String getName() {
            return TieredProgression.MOD_ID+":copper";
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.COPPER_INGOT);
        }

        @Override
        public float getToughness() {
            return 0.0f;
        }
        
    };
}
