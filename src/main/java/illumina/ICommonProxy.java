package illumina;

import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public interface ICommonProxy
{
	public void registerItemRenderer(Item item);
	
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource);
	
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties);
}
