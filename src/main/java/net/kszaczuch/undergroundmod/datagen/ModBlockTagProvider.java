package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CHLOROPHYTE_BLOCK)
                .add(ModBlocks.SHROOMITE_BLOCK)
                .add(ModBlocks.LUMINITE_BRICKS)
                .add(ModBlocks.CHLOROPHYTE_ORE)
                .add(ModBlocks.LUMINITE_ORE)
                .add(ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CHLOROPHYTE_BLOCK)
                .add(ModBlocks.CHLOROPHYTE_ORE)
                .add(ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.SHROOMITE_BLOCK)
                .add(ModBlocks.LUMINITE_ORE)
                .add(ModBlocks.LUMINITE_BRICKS);
    }
}
