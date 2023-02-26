package fr.mysteriousdev.quilt_tag_plus.mixin;

import fr.mysteriousdev.quilt_tag_plus.utils.ModItemTags;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RespawnAnchorBlock.class)
public class RespawnAnchorBlockMixin {
	@Redirect(method = "isChargeItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
	private static boolean isChargeItem(ItemStack instance, Item item) {
		return instance.isIn(ModItemTags.RESPAWN_ANCHOR_CHARGES);
	}
}
