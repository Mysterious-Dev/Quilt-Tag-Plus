package fr.mysteriousdev.quilt_tag_plus.mixin;

import fr.mysteriousdev.quilt_tag_plus.utils.ModItemTags;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IronGolemEntity.class)
public class IronGolemEntityMixin {
	@Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
	private boolean interactMob(ItemStack instance, Item item) {
		return instance.isIn(ModItemTags.IRON_GOLEM_HEALING);
	}
}
