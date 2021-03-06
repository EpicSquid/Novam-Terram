package kipster.nt.util.handlers;

import java.io.File;

import kipster.nt.biomes.BiomeInit;
import kipster.nt.blocks.BlockInit;
import kipster.nt.items.ItemInit;
import kipster.nt.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

  public static Configuration config;

  @SubscribeEvent
  public static void onItemRegister(RegistryEvent.Register<Item> event) {
    event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
  }

  @SubscribeEvent
  public static void onBlockRegister(RegistryEvent.Register<Block> event) {
    event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
  }

  @SubscribeEvent
  public static void onModelRegister(ModelRegistryEvent event) {
    for (Item item : ItemInit.ITEMS) {
      if (item instanceof IHasModel) {
        ((IHasModel) item).registerModels();
      }
    }

    for (Block block : BlockInit.BLOCKS) {
      if (block instanceof IHasModel) {
        ((IHasModel) block).registerModels();
      }
    }
  }

  @SubscribeEvent
  public static void onBiomeRegister(RegistryEvent.Register<Biome> event) {
    BiomeInit.initBiomes(event);
  }

  public static void preInitRegistries(FMLPreInitializationEvent e) {
    File directory = e.getModConfigurationDirectory();
    config = new Configuration(new File(directory.getPath(), "novamterram.cfg"));
  }

  public static void initRegistries() {
    OreDictionaryHandler.registerOreDictionary();
    FurnaceRecipeHandler.registerFurnaceRecipes();
  }

  public static void postInitRegistries() {
    if (config.hasChanged()) {
      config.save();
    }

  }
}