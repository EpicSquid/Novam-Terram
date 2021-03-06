package kipster.nt.biomes.icy;

import java.util.Iterator;
import java.util.Random;

import kipster.nt.biomes.BiomeInit;
import kipster.nt.biomes.cool.BiomePineForest.DiamondGenerator;
import kipster.nt.biomes.icy.BiomeIcyTundra.LapisGenerator;
import kipster.nt.world.gen.WorldGenPatches;
import kipster.nt.world.gen.trees.WorldGenTreeAutumnTaigaOrange;
import kipster.nt.world.gen.trees.WorldGenTreeAutumnTaigaYellow;
import kipster.nt.world.gen.trees.WorldGenTreePine;
import kipster.nt.world.gen.trees.WorldGenTreeShrubSpruce;
import kipster.nt.world.gen.trees.WorldGenTreeTallSpruce;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class BiomeSnowyPineForest extends Biome 
{	
	
	 protected static final WorldGenLakes LAKE = new WorldGenLakes(Blocks.WATER);
	 private final WorldGenTreePine pineGenerator = new WorldGenTreePine(true);
	 private final WorldGenMegaPineTree megaspruceGenerator= new WorldGenMegaPineTree(false, true);
	 private static final WorldGenTreeTallSpruce SPRUCE_GENERATOR = new WorldGenTreeTallSpruce(true);
	
	 public BiomeSnowyPineForest(BiomeProperties properties)
	  	{	
	  		super(properties);
	  	
		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();
		
       
       this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 8, 4, 4));
       this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
       this.decorator.treesPerChunk = 2;
       this.decorator.extraTreeChance = 0.1F;
       this.decorator.mushroomsPerChunk = 5;
       this.decorator.flowersPerChunk = 2;
       this.decorator.grassPerChunk = 7;
       Iterator<Biome.SpawnListEntry> iterator = this.spawnableMonsterList.iterator();

       while (iterator.hasNext())
       {
           Biome.SpawnListEntry biome$spawnlistentry = iterator.next();

           if (biome$spawnlistentry.entityClass == EntitySkeleton.class)
           {
               iterator.remove();
           }
       }

       this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 20, 4, 4));
       this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityStray.class, 80, 4, 4));
	
	}

	 @Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		if (rand.nextInt(5) > 0)
		{
			return this.pineGenerator;
		}
		if (rand.nextInt(4) > 0)
		{
			return SPRUCE_GENERATOR;
		}
		if (rand.nextInt(4) > 0)
		{
			return this.megaspruceGenerator;
		}
		
		else
		{
			return this.pineGenerator;
			
			}
		}

	public WorldGenerator getRandomWorldGenForGrass(Random rand)
   {
       return rand.nextInt(6) > 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
   }

   public void decorate(World worldIn, Random rand, BlockPos pos)
   {

       DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.FERN);

       if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS))
       for (int i1 = 0; i1 < 7; ++i1)
       {
           int j1 = rand.nextInt(16) + 8;
           int k1 = rand.nextInt(16) + 8;
           int l1 = rand.nextInt(worldIn.getHeight(pos.add(j1, 0, k1)).getY() + 32);
           DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j1, l1, k1));
       }
       
       net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Pre(worldIn, rand, pos));
       WorldGenerator lapis = new LapisGenerator();
       if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, rand, lapis, pos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS))
    	   lapis.generate(worldIn, rand, pos);
       
       if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
           int boulderChance = rand.nextInt(12);
           if (boulderChance == 0) {
            int k6 = rand.nextInt(16) + 8;
            int l = rand.nextInt(16) + 8;
             BlockPos blockpos = worldIn.getHeight(pos.add(k6, 0, l));
             LAKE.generate(worldIn, rand, blockpos);
           }
           net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Post(worldIn, rand, pos));

       super.decorate(worldIn, rand, pos);
       }
   }
   
	@Override
	public int getModdedBiomeGrassColor(int original) {
	    return super.getModdedBiomeGrassColor(0x567C48);
	}
	@Override
	public int getModdedBiomeFoliageColor(int original) {
	    return super.getModdedBiomeFoliageColor(0x567C48);
	}
	
	 public static class LapisGenerator extends WorldGenerator
	    {
	        @Override
	        public boolean generate(World worldIn, Random rand, BlockPos pos)
	        {
	            int count = 5 + rand.nextInt(6);
	            for (int i = 0; i < count; i++)
	            {
	                int offset = net.minecraftforge.common.ForgeModContainer.fixVanillaCascading ? 8 : 0; // MC-114332
	                BlockPos blockpos = pos.add(rand.nextInt(16) + offset, rand.nextInt(28) + 2, rand.nextInt(16) + offset);

	                net.minecraft.block.state.IBlockState state = worldIn.getBlockState(blockpos);
	                if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, net.minecraft.block.state.pattern.BlockMatcher.forBlock(Blocks.STONE)))
	                {
	                    worldIn.setBlockState(blockpos, Blocks.LAPIS_ORE.getDefaultState(), 16 | 2);
	                }
	                net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Post(worldIn, rand, pos));
	            }
	            return true;
	        }
	    }
}