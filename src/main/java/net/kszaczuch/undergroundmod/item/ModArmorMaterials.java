package net.kszaczuch.undergroundmod.item;

import net.kszaczuch.undergroundmod.UndergroundMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    CHLOROPHYTE("chlorophyte", 35, new int[] {3, 8, 6, 3}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f, 0.2f, () -> Ingredient.ofItems(ModItems.CHLOROPHYTE_INGOT)),
    SHROOMITE("shroomite", 40, new int[] {3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5f, 0.3f, () -> Ingredient.ofItems(ModItems.SHROOMITE_INGOT)),
    SOLAR("solar", 50, new int[] {3, 8, 6, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.5f, 0.5f, () -> Ingredient.ofItems(ModItems.LUMINITE_INGOT)),
    NEBULA("nebula", 45, new int[] {3, 6, 8, 3}, 20,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,  4.0f, 0.2f, () -> Ingredient.ofItems(ModItems.LUMINITE_INGOT)),
    VORTEX("vortex", 47, new int[] {3, 6, 8, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.2f, 0.2f, () -> Ingredient.ofItems(ModItems.LUMINITE_INGOT))
    ;

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability,
                      SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return UndergroundMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
