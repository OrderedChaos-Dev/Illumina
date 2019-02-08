package illumina;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy implements ICommonProxy
{
	@Override
	public void registerItemRenderer(Item item)
	{
		//Item.getItemFromBlock() gives the air block for blocks that do not have an item form
		if(item != Item.getItemFromBlock(Blocks.AIR))
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Override
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, resource);
	}
	
	@Override
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties)
	{
		IStateMapper mapper = (new StateMap.Builder()).ignore(properties).build();
		ModelLoader.setCustomStateMapper(Block.getBlockFromItem(item), mapper);
	}
}
