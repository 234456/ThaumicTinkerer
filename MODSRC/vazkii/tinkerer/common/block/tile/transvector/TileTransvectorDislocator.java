/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the ThaumicTinkerer Mod.
 *
 * ThaumicTinkerer is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * ThaumicTinkerer is a Derivative Work on Thaumcraft 4.
 * Thaumcraft 4 (c) Azanor 2012
 * (http://www.minecraftforum.net/topic/1585216-)
 *
 * File Created @ [Nov 24, 2013, 6:48:04 PM (GMT)]
 */
package vazkii.tinkerer.common.block.tile.transvector;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.common.ForgeDirection;
import vazkii.tinkerer.common.lib.LibFeatures;

public class TileTransvectorDislocator extends TileTransvector {

	private static final String TAG_ORIENTATION = "orientation";

	public int orientation;

	public void receiveRedstonePulse() {
		ChunkCoordinates target = getBlockTarget();
		worldObj.setBlock(target.posX, target.posY, target.posZ, Block.bedrock.blockID); // debug
	}
	
	public ChunkCoordinates getBlockTarget() {
		ForgeDirection dir = ForgeDirection.getOrientation(orientation);
		return new ChunkCoordinates(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
	}
	
	@Override
	public void readCustomNBT(NBTTagCompound cmp) {
		super.readCustomNBT(cmp);

		orientation = cmp.getInteger(TAG_ORIENTATION);
	}

	@Override
	public void writeCustomNBT(NBTTagCompound cmp) {
		super.writeCustomNBT(cmp);

		cmp.setInteger(TAG_ORIENTATION, orientation);
	}

	@Override
	public int getMaxDistance() {
		return LibFeatures.DISLOCATOR_DISTANCE;
	}

	@Override
	boolean tileRequiredAtLink() {
		return false;
	}

}