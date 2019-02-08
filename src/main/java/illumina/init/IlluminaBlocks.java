package illumina.init;

import java.util.ArrayList;

import illumina.blocks.BlockCampfire;
import illumina.blocks.BlockCandle;
import illumina.blocks.BlockCeilingLamp;
import illumina.blocks.BlockCircuitBreaker;
import illumina.blocks.BlockGlowstoneLamp;
import illumina.blocks.BlockLantern;
import illumina.blocks.BlockLightbulb;
import illumina.blocks.TileEntityCampfire;
import illumina.items.ItemIlluminaBlock;
import illumina.util.CreativeTabIllumina;
import illumina.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IlluminaBlocks
{
	public static final ArrayList<Block> BLOCKS = new ArrayList<Block>();
	
	public static Block campfire;
	public static Block candle;
	public static Block glowstone_lamp_wood, glowstone_lamp_stone, glowstone_lamp_iron;
	public static Block lantern;
	public static Block lantern_candle;
	public static Block lava_lamp;
	public static Block paper_lantern;
	public static Block lightbulb;
	public static Block ceiling_lamp;
	public static Block circuit_breaker;
	
	public static void initBlocks()
	{
		campfire = registerBlock(new BlockCampfire(), "campfire");
		candle = registerBlock(new BlockCandle(), "candle");
		glowstone_lamp_wood = registerBlock(new BlockGlowstoneLamp(Material.WOOD), "glowstone_lamp_wood");
		glowstone_lamp_stone = registerBlock(new BlockGlowstoneLamp(Material.ROCK), "glowstone_lamp_stone");
		glowstone_lamp_iron = registerBlock(new BlockGlowstoneLamp(Material.IRON), "glowstone_lamp_iron");
		lantern = registerBlock(new BlockLantern(BlockLantern.Type.NORMAL), "lantern");
		lantern_candle = registerBlock(new BlockLantern(BlockLantern.Type.CANDLE), "lantern_candle");
		lava_lamp = registerBlock(new BlockLantern(BlockLantern.Type.LAVA), "lava_lamp");
		paper_lantern = registerBlock(new BlockLantern(BlockLantern.Type.PAPER), "paper_lantern");
		lightbulb = registerBlock(new BlockLightbulb(), "lightbulb");
		ceiling_lamp = registerBlock(new BlockCeilingLamp(), "ceiling_lamp");
		circuit_breaker = registerBlock(new BlockCircuitBreaker(), "circuit_breaker");
		
		GameRegistry.registerTileEntity(TileEntityCampfire.class, new ResourceLocation(Reference.MOD_ID, "campfire"));
	}
	
	public static Block registerBlock(Block block, String name)
	{
		block.setUnlocalizedName(name);
		block.setCreativeTab(CreativeTabIllumina.instance);

		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		
		Item itemBlock = new ItemIlluminaBlock(block);
		itemBlock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));

		BLOCKS.add(block);
		IlluminaItems.ITEMS.add(itemBlock);
		
		return block;
	}
}
