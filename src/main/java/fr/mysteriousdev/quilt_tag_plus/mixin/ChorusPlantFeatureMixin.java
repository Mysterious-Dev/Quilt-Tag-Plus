package fr.mysteriousdev.quilt_tag_plus.mixin;

import fr.mysteriousdev.quilt_tag_plus.utils.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.ChorusPlantFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChorusPlantFeature.class)
public class ChorusPlantFeatureMixin {
	@Redirect(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 0))
	private boolean getStateForNeighborUpdate(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.CHORUS_PLANTABLE_ON);
	}
}
