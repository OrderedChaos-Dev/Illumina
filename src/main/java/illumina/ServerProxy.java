package illumina;

import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ServerProxy implements ICommonProxy
{
	@Override
	public void registerItemRenderer(Item item) {}
	
	@Override
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource){}
	
	@Override
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties){}
}
