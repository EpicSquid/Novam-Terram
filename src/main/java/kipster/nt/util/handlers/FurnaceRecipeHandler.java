package kipster.nt.util.handlers;

import kipster.nt.blocks.BlockInit;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class FurnaceRecipeHandler 
{

public static void registerFurnaceRecipes() {
	GameRegistry.addSmelting(BlockInit.WHITESAND, new ItemStack(Blocks.GLASS), 1.0F);
	GameRegistry.addSmelting(BlockInit.HOTSAND, new ItemStack(Blocks.GLASS), 1.0F);
	GameRegistry.addSmelting(BlockInit.COLDSAND, new ItemStack(Blocks.GLASS), 1.0F);

	System.out.println("Furnace Recipes Registered");
}
}