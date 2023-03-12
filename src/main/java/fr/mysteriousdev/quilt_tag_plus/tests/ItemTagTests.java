package fr.mysteriousdev.quilt_tag_plus.tests;

import fr.mysteriousdev.quilt_tag_plus.Main;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.test.GameTest;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
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

		player.getInventory().setStack(0, new ItemStack(Items.FIRE_CHARGE));
		context.useBlock(new BlockPos(4,2,2), player);

		context.succeedWhen(()-> {
			context.expectBlock(Blocks.AIR, new BlockPos(2,2,2));
			context.expectBlock(Blocks.AIR, new BlockPos(4,2,2));
		});
	}

	@GameTest(structureName = "respawn_anchor_charges")
	public void respawnAnchorCharges(QuiltTestContext context) {

		PlayerEntity player = context.createMockSurvivalPlayer();

		player.getInventory().selectedSlot = 0;
		player.getInventory().setStack(0, new ItemStack(Items.GLOWSTONE));
		context.useBlock(new BlockPos(1,2,1), player);

		context.succeedWhen(()-> {
			context.expectBlockProperty(new BlockPos(1,2,1), Properties.CHARGES, 1);
		});
	}

	@GameTest(structureName = "minecart_furnace_fuel")
	public void minecartFurnaceFuel(QuiltTestContext context) {

		PlayerEntity player = context.createMockPlayer();

		BlockPos actualPos = context.getAbsolutePos(new BlockPos(2,2,0));

		player.setPos(actualPos.getX(), actualPos.getY(), actualPos.getZ());
		player.setHeadYaw(0);

		Entity minecraftOne = context.spawnEntity(EntityType.FURNACE_MINECART, new BlockPos(1,2,1));

		player.getInventory().selectedSlot = 0;
		player.getInventory().setStack(0, new ItemStack(Items.COAL));
		context.useBlock(new BlockPos(1,2,1), player);
		minecraftOne.interact(player, Hand.MAIN_HAND);

		Entity minecraftTwo = context.spawnEntity(EntityType.FURNACE_MINECART, new BlockPos(3,2,1));

		player.getInventory().setStack(0, new ItemStack(Items.CHARCOAL));
		context.useBlock(new BlockPos(3,2,1), player);
		minecraftTwo.interact(player, Hand.MAIN_HAND);

		context.succeedWhen(()-> {
			context.expectEntityAt(EntityType.FURNACE_MINECART, new BlockPos(1,2,3));
			context.expectEntityAt(EntityType.FURNACE_MINECART, new BlockPos(3,2,3));
		});
	}
}
