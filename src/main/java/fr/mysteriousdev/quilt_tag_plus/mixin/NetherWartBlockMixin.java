package fr.mysteriousdev.quilt_tag_plus.mixin;

import fr.mysteriousdev.quilt_tag_plus.utils.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherWartBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NetherWartBlock.class)
public class NetherWartBlockMixin {
	@Redirect(method = "canPlantOnTop", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
	private boolean canPlantOnTop(BlockState instance, Block block) {
		return instance.isIn(ModBlockTags.NETHER_WART_PLANTABLE_ON);
	}
}
