package fr.mysteriousdev.quilt_tag_plus.tests;

import fr.mysteriousdev.quilt_tag_plus.Main;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.test.GameTest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.quiltmc.qsl.testing.api.game.QuiltGameTest;
import org.quiltmc.qsl.testing.api.game.QuiltTestContext;
import org.quiltmc.qsl.testing.api.game.TestStructureNamePrefix;

@TestStructureNamePrefix(Main.MODID + ":")
public class BlockTagTests implements QuiltGameTest {
	@GameTest(structureName = "wither_rose_plantable_on")
	public void witherRosePlantableOn(QuiltTestContext context) {

		PlayerEntity player = context.createMockPlayer();

		ItemStack witherRoseStack = new ItemStack(Items.WITHER_ROSE);

		context.useStackOnBlockAt(player, witherRoseStack, new BlockPos(1, 3, 2), Direction.UP);
		context.useStackOnBlockAt(player, witherRoseStack, new BlockPos(2, 3, 2), Direction.UP);
		context.useStackOnBlockAt(player, witherRoseStack, new BlockPos(3, 3, 2), Direction.UP);

		context.succeedWhen(()-> {
			context.expectBlock(Blocks.WITHER_ROSE, new BlockPos(1,3,2));
			context.expectBlock(Blocks.WITHER_ROSE, new BlockPos(2,3,2));
			context.expectBlock(Blocks.WITHER_ROSE, new BlockPos(3,3,2));
		});
	}

	@GameTest(structureName = "cactus_plantable_on")
	public void cactusPlantableOn(QuiltTestContext context) {

		PlayerEntity player = context.createMockPlayer();

		ItemStack cactusStack = new ItemStack(Items.CACTUS);

		context.useStackOnBlockAt(player, cactusStack, new BlockPos(1, 3, 2), Direction.UP);
		context.useStackOnBlockAt(player, cactusStack, new BlockPos(3, 3, 2), Direction.UP);

		context.succeedWhen(()-> {
			context.expectBlock(Blocks.CACTUS, new BlockPos(1,3,2));
			context.expectBlock(Blocks.CACTUS, new BlockPos(3,3,2));
		});
	}

	@GameTest(structureName = "sugar_cane_plantable_on")
	public void sugarCanePlantableOn(QuiltTestContext context) {

		PlayerEntity player = context.createMockPlayer();

		ItemStack sugarCaneStack = new ItemStack(Items.SUGAR_CANE);

		context.useStackOnBlockAt(player, sugarCaneStack, new BlockPos(2, 3, 1), Direction.UP);
		context.useStackOnBlockAt(player, sugarCaneStack, new BlockPos(3, 3, 1), Direction.UP);

		context.succeedWhen(()-> {
			context.expectBlock(Blocks.SUGAR_CANE, new BlockPos(2,3,1));
			context.expectBlock(Blocks.SUGAR_CANE, new BlockPos(3,3,1));
		});
	}

	@GameTest(structureName = "nether_wart_plantable_on")
	public void netherWartPlantableOn(QuiltTestContext context) {

		PlayerEntity player = context.createMockPlayer();

		context.useStackOnBlockAt(player, new ItemStack(Items.NETHER_WART), new BlockPos(1, 3, 1), Direction.UP);

		context.succeedWhen(()-> {
			context.expectBlock(Blocks.NETHER_WART, new BlockPos(1,3,1));
		});
	}

	@GameTest(structureName = "chorus_plantable_on")
	public void chorusPlantableOn(QuiltTestContext context) {

		PlayerEntity player = context.createMockPlayer();

		context.useStackOnBlockAt(player, new ItemStack(Items.CHORUS_FLOWER), new BlockPos(1, 3, 1), Direction.UP);

		context.succeedWhen(()-> {
			context.expectBlock(Blocks.CHORUS_FLOWER, new BlockPos(1,3,1));
		});
	}
}
