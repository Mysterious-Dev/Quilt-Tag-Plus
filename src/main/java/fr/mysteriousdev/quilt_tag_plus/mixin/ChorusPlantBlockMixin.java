package fr.mysteriousdev.quilt_tag_plus.mixin;

import fr.mysteriousdev.quilt_tag_plus.utils.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChorusPlantBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChorusPlantBlock.class)
public class ChorusPlantBlockMixin {

	@Redirect(method = "withConnectionProperties", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 2))
	private boolean withConnectionProperties(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.CHORUS_PLANTABLE_ON);
	}

	@Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 4))
	private boolean canPlaceAt1(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.CHORUS_PLANTABLE_ON);
	}
	@Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 2))
	private boolean canPlaceAt2(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.CHORUS_PLANTABLE_ON);
	}

	@Redirect(method = "getStateForNeighborUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 2))
	private boolean getStateForNeighborUpdate(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.CHORUS_PLANTABLE_ON);
	}
}
