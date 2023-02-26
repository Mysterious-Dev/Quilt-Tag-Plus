package fr.mysteriousdev.quilt_tag_plus.mixin;

import fr.mysteriousdev.quilt_tag_plus.utils.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChorusFlowerBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
@Mixin(ChorusFlowerBlock.class)
public class ChorusFlowerBlockMixin {

	@Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 1))
	private boolean canPlaceAt(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.CHORUS_PLANTABLE_ON);
	}

	@Redirect(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 0))
	private boolean randomTick1(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.CHORUS_PLANTABLE_ON);
	}

	@Redirect(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 3))
	private boolean randomTick2(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.CHORUS_PLANTABLE_ON);
	}
}
