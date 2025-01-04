package net.kszaczuch.undergroundmod.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    CHLOROPHYTE(MiningLevels.DIAMOND, 1800, 9.0f, 3.5f, 12,
            () -> Ingredient.ofItems(ModItems.CHLOROPHYTE_INGOT)),
    SHROOMITE(MiningLevels.NETHERITE, 2500, 11.0f, 5.0f, 15,
            () -> Ingredient.ofItems(ModItems.SHROOMITE_INGOT)),
    SOLAR(MiningLevels.NETHERITE, 3000, 14.0f, 8.0f, 10,
            () -> Ingredient.ofItems(ModItems.LUMINITE_INGOT)),
    NEBULA(MiningLevels.NETHERITE, 3250, 13.0f, 7.0f, 20,
            () -> Ingredient.ofItems(ModItems.LUMINITE_INGOT)),
    VORTEX(MiningLevels.NETHERITE, 3100, 16.0f, 7.0f, 15,
            () -> Ingredient.ofItems(ModItems.LUMINITE_INGOT))
    ;


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
