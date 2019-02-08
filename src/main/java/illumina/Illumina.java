package illumina;

import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;

import illumina.blocks.BlockCeilingLamp;
import illumina.init.IlluminaBlocks;
import illumina.init.IlluminaItems;
import illumina.util.GuiHandler;
import illumina.util.IPropertyHelper;
import illumina.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Illumina
{
    public static Logger logger;
    
    @Instance(Reference.MOD_ID)
    public static Illumina instance;
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
    public static ICommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        IlluminaBlocks.initBlocks();
        IlluminaItems.initItems();
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    }
    
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();
		for(Block block : IlluminaBlocks.BLOCKS)
		{
			registry.register(block);
		}
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();
		for(Item item : IlluminaItems.ITEMS)
		{
			registry.register(item);
		}
	}
	@SubscribeEvent
	public void registerItemModels(ModelRegistryEvent event)
	{
		for(Block block : IlluminaBlocks.BLOCKS)
		{
			proxy.registerItemRenderer(Item.getItemFromBlock(block));
			
			if(block instanceof IPropertyHelper)
			{
				IPropertyHelper PVJBlock = (IPropertyHelper)block;
				ImmutableList<IBlockState> properties = PVJBlock.getProperties();
				for(IBlockState state : properties)
				{
					int meta = block.getMetaFromState(state);
					ModelResourceLocation resource = new ModelResourceLocation(block.getRegistryName(), "inventory");
					proxy.registerItemVariantRenderer(Item.getItemFromBlock(block), meta, resource);
				}
			}
		}
		
		for(Item item : IlluminaItems.ITEMS)
		{
			proxy.registerItemRenderer(item);
		}
		
		proxy.setIgnoredPropertiesForModel(Item.getItemFromBlock(IlluminaBlocks.ceiling_lamp), BlockCeilingLamp.POWERED);
	}
}
