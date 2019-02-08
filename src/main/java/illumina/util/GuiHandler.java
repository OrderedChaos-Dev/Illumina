package illumina.util;

import illumina.blocks.TileEntityCampfire;
import illumina.inventory.ContainerCampfire;
import illumina.inventory.GuiCampfire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if(te instanceof TileEntityCampfire)
		{
			return new ContainerCampfire(player.inventory, (TileEntityCampfire)te);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if(te instanceof TileEntityCampfire)
		{
			return new GuiCampfire(player.inventory, (TileEntityCampfire)te);
		}
		return null;
	}
}
