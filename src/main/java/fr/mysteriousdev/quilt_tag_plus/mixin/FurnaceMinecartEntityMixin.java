package fr.mysteriousdev.quilt_tag_plus.mixin;

import fr.mysteriousdev.quilt_tag_plus.utils.ModItemTags;
import net.minecraft.entity.vehicle.FurnaceMinecartEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FurnaceMinecartEntity.class)
public class FurnaceMinecartEntityMixin {
	@Redirect(method = "interact", at = @At(value = "INVOKE", target = "Lnet/minecraft/recipe/Ingredient;test(Lnet/minecraft/item/ItemStack;)Z"))
	private boolean interactMob(Ingredient instance, ItemStack itemStack) {
		return itemStack.isIn(ModItemTags.MINECART_FURNACE_FUEL);
	}
}
