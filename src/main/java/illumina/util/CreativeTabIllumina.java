package illumina.util;

import illumina.init.IlluminaBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabIllumina extends CreativeTabs
{
	public static final CreativeTabs instance = new CreativeTabIllumina();
	
	public CreativeTabIllumina()
	{
		super(CreativeTabs.getNextID(), "tabIllumina");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(IlluminaBlocks.lantern_candle);
	}
}
