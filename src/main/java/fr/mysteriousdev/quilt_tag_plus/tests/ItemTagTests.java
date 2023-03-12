package fr.mysteriousdev.quilt_tag_plus.tests;

import fr.mysteriousdev.quilt_tag_plus.Main;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.test.GameTest;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.qsl.testing.api.game.QuiltGameTest;
import org.quiltmc.qsl.testing.api.game.QuiltTestContext;
import org.quiltmc.qsl.testing.api.game.TestStructureNamePrefix;

@TestStructureNamePrefix(Main.MODID + ":")
public class ItemTagTests implements QuiltGameTest {
	@GameTest(structureName = "tnt_igniters")
	public void tntIgniters(QuiltTestContext context) {

		PlayerEntity player = context.createMockSurvivalPlayer();

		player.getInventory().selectedSlot = 0;
		player.getInventory().setStack(0, new ItemStack(Items.FLINT_AND_STEEL));
		context.useBlock(new BlockPos(2,2,2), player);

		player.getInventory().selectedSlot = 0;
		player.getInventory().setStack(0, new ItemStack(Items.FIRE_CHARGE));
		context.useBlock(new BlockPos(4,2,2), player);

		context.succeedWhen(()-> {
			context.expectBlock(Blocks.AIR, new BlockPos(2,2,2));
			context.expectBlock(Blocks.AIR, new BlockPos(4,2,2));
		});
	}
}
