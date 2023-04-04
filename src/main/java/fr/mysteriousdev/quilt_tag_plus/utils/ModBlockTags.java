package fr.mysteriousdev.quilt_tag_plus.utils;

import fr.mysteriousdev.quilt_tag_plus.Main;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {

	public static final TagKey<Block> AZALEA_PLANTABLE_ON = TagKey.of(RegistryKeys.BLOCK, new Identifier(Main.MODID, "azalea_plantable_on"));
	public static final TagKey<Block> CACTUS_PLANTABLE_ON = TagKey.of(RegistryKeys.BLOCK, new Identifier(Main.MODID, "cactus_plantable_on"));
	public static final TagKey<Block> CHORUS_PLANTABLE_ON = TagKey.of(RegistryKeys.BLOCK, new Identifier(Main.MODID, "chorus_plantable_on"));
	public static final TagKey<Block> END_CRYSTAL_USE_ON = TagKey.of(RegistryKeys.BLOCK, new Identifier(Main.MODID, "end_crystal_use_on"));
	public static final TagKey<Block> NETHER_WART_PLANTABLE_ON = TagKey.of(RegistryKeys.BLOCK, new Identifier(Main.MODID, "nether_wart_plantable_on"));
	public static final TagKey<Block> NOT_PUSHABLE_BY_PISTON = TagKey.of(RegistryKeys.BLOCK, new Identifier(Main.MODID, "not_pushable_by_piston"));
	public static final TagKey<Block> SUGAR_CANE_PLANTABLE_ON = TagKey.of(RegistryKeys.BLOCK, new Identifier(Main.MODID, "sugar_cane_plantable_on"));
	public static final TagKey<Block> WITHER_ROSE_PLANTABLE_ON = TagKey.of(RegistryKeys.BLOCK, new Identifier(Main.MODID, "wither_rose_plantable_on"));

}
