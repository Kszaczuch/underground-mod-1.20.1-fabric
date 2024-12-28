package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CHLOROPHYTE_HELMET,ModItems.CHLOROPHYTE_CHESTPLATE,ModItems.CHLOROPHYTE_LEGGINGS,ModItems.CHLOROPHYTE_BOOTS,
                        ModItems.SHROOMITE_HELMET,ModItems.SHROOMITE_CHESTPLATE,ModItems.SHROOMITE_LEGGINGS,ModItems.SHROOMITE_BOOTS,
                        ModItems.SOLAR_HELMET,ModItems.SOLAR_CHESTPLATE,ModItems.SOLAR_LEGGINGS,ModItems.SOLAR_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.CHLOROPHYTE_INGOT,ModItems.SHROOMITE_INGOT,ModItems.LAST_PRISM,ModItems.LUMINITE_INGOT,
                        ModItems.SOLAR_FRAGMENT,ModItems.NEBULA_FRAGMENT,ModItems.STARDUST_FRAGMENT,ModItems.VORTEX_FRAGMENT);
    }
}
