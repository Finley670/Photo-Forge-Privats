package de.autumn;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

public class AutumnBiomes implements ModInitializer {
    public static final String MOD_ID = "autumnbiomes";

    @Override
    public void onInitialize() {
        BiomeModifications.create(net.minecraft.resources.Identifier.fromNamespaceAndPath(MOD_ID, "autumn_effects"))
            .add(net.fabricmc.fabric.api.biome.v1.ModificationPhase.POST_PROCESSING,
                 BiomeSelectors.all(),
                 (selection, ctx) -> {
                     var fx = ctx.getEffects();
                     fx.setGrassColor(0xB5651D);
                     fx.setFoliageColor(0xD2691E);
                     fx.setWaterColor(0x3A6E8F);
                     fx.setWaterFogColor(0x1F3D52);
                     fx.setSkyColor(0xE8A25C);
                     fx.setFogColor(0xF2C48D);
                 });
    }
}
