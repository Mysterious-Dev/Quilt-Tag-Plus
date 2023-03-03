package fr.mysteriousdev.quilt_tag_plus.utils;

import fr.mysteriousdev.quilt_tag_plus.Main;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {

	public static final TagKey<Item> RESPAWN_ANCHOR_CHARGES = TagKey.of(RegistryKeys.ITEM, new Identifier(Main.MODID, "respawn_anchor_charges"));
	public static final TagKey<Item> IRON_GOLEM_HEALING = TagKey.of(RegistryKeys.ITEM, new Identifier(Main.MODID, "iron_golem_healing"));
	public static final TagKey<Item> MINECART_FURNACE_FUEL = TagKey.of(RegistryKeys.ITEM, new Identifier(Main.MODID, "minecart_furnace_fuel"));
	public static final TagKey<Item> ANIMAL_BREEDING = TagKey.of(RegistryKeys.ITEM, new Identifier(Main.MODID, "animal_breeding"));
	public static final TagKey<Item> TNT_IGNITERS = TagKey.of(RegistryKeys.ITEM, new Identifier(Main.MODID, "tnt_igniters"));

}
