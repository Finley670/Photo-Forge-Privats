package de.autumn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.world.level.block.Blocks;

public class AutumnBiomesClient implements ClientModInitializer {

    private static final int[] PALETTE = {
        0xD62828, 0xE63900, 0xF77F00, 0xFCBF49, 0xFFD60A,
        0xC1440E, 0x9D0208, 0xB5651D, 0x8F2D56, 0x7A9E1F
    };

    private static int colorFor(int x, int y, int z) {
        long h = x * 3129871L ^ z * 116129781L ^ y * 42317861L;
        h = h * h * 42317861L + h * 11L;
        h ^= (h >>> 16);
        int idx = (int) ((h & 0x7fffffff) % PALETTE.length);
        float factor = 0.88f + ((h >>> 8) & 0xFF) / 255f * 0.24f;
        int base = PALETTE[idx];
        int r = Math.min(255, (int) (((base >> 16) & 0xFF) * factor));
        int g = Math.min(255, (int) (((base >> 8) & 0xFF) * factor));
        int b = Math.min(255, (int) ((base & 0xFF) * factor));
        return (r << 16) | (g << 8) | b;
    }

    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (pos == null) return 0xD2691E;
            return colorFor(pos.getX(), pos.getY(), pos.getZ());
        },
            Blocks.OAK_LEAVES, Blocks.BIRCH_LEAVES, Blocks.SPRUCE_LEAVES,
            Blocks.JUNGLE_LEAVES, Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES,
            Blocks.MANGROVE_LEAVES, Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES);
    }
}
