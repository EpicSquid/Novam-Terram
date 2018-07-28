package kipster.nt.biomes;

import java.util.ArrayList;
import java.util.Set;

import kipster.nt.biomes.icy.*;
import kipster.nt.Config;
import kipster.nt.biomes.cool.*;
import kipster.nt.biomes.desert.*;
import kipster.nt.biomes.warm.*;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
	
	public static Set<Biome> presentBiomes;
	
	public static Biome oakForestBiome = new BiomeOakForest();
	public static Biome tallOakforestBiome = new BiomeOakForestTall();
	public static Biome sandDunesBiome = new BiomeSandDunes();
	public static Biome redsandDunesBiome = new BiomeRedSandDunes();
	public static Biome greenSwampBiome = new BiomeGreenSwamp();
	public static Biome taigaPlainsBiome = new BiomeTaigaPlains();
	public static Biome autumnTaigaBiome = new BiomeAutumnTaiga();
	public static Biome autumntaigaHillsBiome = new BiomeAutumnTaigaHills();
	public static Biome cliffsBiome = new BiomeCliffs();
	public static Biome megaautumnTaigaBiome = new BiomeMegaAutumnTaiga();
	public static Biome shrublandBiome = new BiomeShrubland();
	public static Biome denseShrublandBiome = new BiomeDenseShrubland();
	public static Biome highlandsBiome = new BiomeHighlands();
	public static Biome pinelandsBiome = new BiomePinelands();
	public static Biome lowlandsBiome = new BiomeLowlands();
	public static Biome sahelBiome = new BiomeSahel();
	public static Biome bogBiome = new BiomeBog();
	public static Biome dryForestBiome = new BiomeDryForest();
	public static Biome dryforestHillsBiome = new BiomeDryForestHills();
	public static Biome springsBiome = new BiomeSprings();
	public static Biome tundraBiome = new BiomeTundra();
	public static Biome icyTundraBiome = new BiomeIcyTundra();
	public static Biome mixedForestBiome = new BiomeMixedForest();
	public static Biome densemixedForestBiome = new BiomeDenseMixedForest();
	public static Biome pineForestBiome = new BiomePineForest();
	public static Biome snowypineForestBiome = new BiomeSnowyPineForest();
	public static Biome coldForestBiome = new BiomeColdForest(BiomeForest.Type.NORMAL, "Cold Forest");
	public static Biome coldbirchForestBiome = new BiomeColdForest(BiomeForest.Type.BIRCH, "Cold Birch Forest");
	public static Biome coldroofedForestBiome = new BiomeColdForest(BiomeForest.Type.ROOFED, "Cold Roofed Forest");
	public static Biome coldmegaTaigaBiome = new BiomeColdMegaTaiga(BiomeTaiga.Type.MEGA, "Cold Mega Taiga");
	public static Biome coldmegaSpruceBiome = new BiomeColdMegaTaiga(BiomeTaiga.Type.MEGA_SPRUCE, "Cold Mega Spruce Taiga");
	public static Biome alpsBiome = new BiomeAlps();
	public static Biome blossomForestBiome = new BiomeBlossomForest();
	public static Biome blossomforestHillsBiome = new BiomeBlossomForestHills();
	public static Biome outbackBiome = new BiomeOutback();
	public static Biome estuaryBiome = new BiomeEstuary();
	public static Biome meadowBiome = new BiomeMeadow();
	
	public static void registerBiomes() {
		
		//WARM
		initBiome(oakForestBiome, "Oak_Forest", 8, Config.disableOakForest, false, BiomeType.WARM, Type.FOREST);
		initBiome(tallOakforestBiome, "Tall_Oak_Forest", 2, Config.disableTallOakForest, false, BiomeType.WARM, Type.FOREST);
		initBiome(greenSwampBiome, "Green_Swamp", 8, Config.disableGreenSwamp, false, BiomeType.WARM, Type.SWAMP);
		initBiome(bogBiome, "Bog", 4, Config.disableBog, false, BiomeType.WARM, Type.SWAMP);
		initBiome(shrublandBiome, "Shrubland", 8, Config.disableShrubland, false, BiomeType.WARM, Type.PLAINS);
		initBiome(denseShrublandBiome, "Dense_Shrubland", 2, Config.disableDenseShrubland, false, BiomeType.WARM, Type.PLAINS);
		initBiome(highlandsBiome, "Highlands", 8, Config.disableHighlands, false, BiomeType.WARM, Type.HILLS);
		initBiome(pinelandsBiome, "Pinelands", 4, Config.disablePinelands, false, BiomeType.WARM, Type.HILLS);
		initBiome(lowlandsBiome, "Lowlands", 6, Config.disableLowlands, false, BiomeType.WARM, Type.PLAINS);
		initBiome(dryForestBiome, "Dry_Forest", 5, Config.disableDryForest, false, BiomeType.WARM, Type.FOREST);
		initBiome(dryforestHillsBiome, "Dry_Forest_Hills", 2, Config.disableDryForestHills, false, BiomeType.WARM, Type.FOREST);
		initBiome(springsBiome, "Springs", 1, Config.disableSprings, false, BiomeType.WARM, Type.WET);
		initBiome(mixedForestBiome, "Mixed_Forest", 6, Config.disableMixedForest, false, BiomeType.WARM, Type.FOREST);
		initBiome(densemixedForestBiome, "Dense_Mixed_Forest", 2, Config.disableDenseMixedForest, false, BiomeType.WARM, Type.FOREST);
		initBiome(blossomForestBiome, "Blossom Forest", 7, Config.disableBlossomForest, false, BiomeType.WARM, Type.FOREST);
		initBiome(blossomforestHillsBiome, "Blossom Forest Hills", 2, Config.disableBlossomForestHills, false, BiomeType.WARM, Type.FOREST);
		initBiome(estuaryBiome, "Estuary", 4, Config.disableEstuary, false, BiomeType.WARM, Type.SWAMP);
		initBiome(meadowBiome, "Meadow", 8, Config.disableMeadow, false, BiomeType.WARM, Type.PLAINS);
		
		//DESERT
		initBiome(sandDunesBiome, "Sand_Dunes", 5, Config.disableSandDunes, true, BiomeType.DESERT, Type.SANDY);
		initBiome(redsandDunesBiome, "Red_Sand_Dunes", 5, Config.disableRedSandDunes, true, BiomeType.DESERT, Type.SANDY);
		initBiome(sahelBiome, "Sahel", 7, Config.disableSahel, true, BiomeType.DESERT, Type.SANDY);
		initBiome(outbackBiome, "Outback", 6, Config.disableOutback, true, BiomeType.DESERT, Type.SANDY);
		
		//COOL
		initBiome(taigaPlainsBiome, "Taiga_Plains", 6, Config.disableTaigaPlains, true, BiomeType.COOL, Type.PLAINS);
		initBiome(autumnTaigaBiome, "Autumn_Taiga", 7, Config.disableAutumnTaiga ,true, BiomeType.COOL, Type.CONIFEROUS);
		initBiome(autumntaigaHillsBiome, "Autumn_Taiga_Hills", 2, Config.disableAutumnTaigaHills, true, BiomeType.COOL, Type.CONIFEROUS);
		initBiome(cliffsBiome, "Cliffs", 7, Config.disableCliffs, true, BiomeType.COOL, Type.HILLS);
		initBiome(megaautumnTaigaBiome, "Mega_Autumn_Taiga", 2, Config.disableMegaAutumnTaiga ,true, BiomeType.COOL, Type.CONIFEROUS);
		initBiome(pineForestBiome, "Pine_Forest", 6, Config.disablePineForest ,true, BiomeType.COOL, Type.CONIFEROUS);
		
		//ICY
		initBiome(tundraBiome, "Tundra", 6, Config.disableTundra, true, BiomeType.ICY, Type.COLD);
		initBiome(coldForestBiome, "Cold_Forest", 6, Config.disableColdForest, true, BiomeType.ICY, Type.FOREST);
		initBiome(coldbirchForestBiome, "Cold_Birch_Forest", 6, Config.disableColdBirchForest, true, BiomeType.ICY, Type.FOREST);
		initBiome(coldroofedForestBiome, "Cold_Roofed_Forest", 6, Config.disableColdRoofedForest, true, BiomeType.ICY, Type.FOREST);
		initBiome(coldmegaTaigaBiome, "Cold_Mega_Taiga", 4, Config.disableColdMegaTaiga, true, BiomeType.ICY, Type.CONIFEROUS);
		initBiome(coldmegaSpruceBiome, "Cold_Mega_Spruce_Taiga", 4, Config.disableColdMegaSpruceTaiga, true, BiomeType.ICY, Type.CONIFEROUS);
		initBiome(icyTundraBiome, "Tundra_Icy", 2, Config.disableIcyTundra, true, BiomeType.ICY, Type.COLD);
		initBiome(snowypineForestBiome, "Snowy_Pine_Forest", 3, Config.disableSnowyPineForest ,true, BiomeType.ICY, Type.CONIFEROUS);
		initBiome(alpsBiome, "Alps", 5, Config.disableAlps, true, BiomeType.ICY, Type.MOUNTAIN);
	}
	
	private static Biome initBiome(Biome biome, String name, int weight, boolean disabled, boolean canSpawn, BiomeType biomeType, Type... types)	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Registered");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, weight));
		BiomeManager.addVillageBiome(biome, canSpawn);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addStrongholdBiome(biome);

		System.out.println("Biome Added");
		
		return biome;

	}
	
}
