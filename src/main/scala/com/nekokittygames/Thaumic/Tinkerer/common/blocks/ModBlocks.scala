package com.nekokittygames.Thaumic.Tinkerer.common.blocks

import com.nekokittygames.Thaumic.Tinkerer.common.ThaumicTinkerer
import com.nekokittygames.Thaumic.Tinkerer.common.blocks.quartz.{BlockDarkQuartz, BlockDarkQuartzPatterned}
import com.nekokittygames.Thaumic.Tinkerer.common.items.ItemBlocks.ItemBlockMeta
import com.nekokittygames.Thaumic.Tinkerer.common.libs.LibNames
import com.nekokittygames.Thaumic.api.IMetaBlockName
import net.minecraft.block.Block
import net.minecraftforge.fml.common.registry.GameRegistry

/**
 * Created by Katrina on 17/05/2015.
 */
object ModBlocks {
  val Blocks=scala.collection.mutable.Map[Block,String]()


  def registerBlocks()=
  {
    def registerBlock(block:Block,name:String)=
    {
      block match {
        case s: IMetaBlockName => GameRegistry.registerBlock(block, classOf[ItemBlockMeta], name)
        case _ => GameRegistry.registerBlock(block,name)
      }
      block match
      {
        case s: ModBlockContainer => GameRegistry.registerTileEntity(s.getTileClass, name)
        case _=>{}
      }
      Blocks(block)=name
    }
    registerBlock(BlockDarkQuartz,LibNames.DARK_QUARTZ_BLOCK)
    registerBlock(BlockDarkQuartzPatterned,LibNames.DARK_QUARTZ_PATTERNED)
    registerBlock(BlockFunnel,LibNames.FUNNEL)
    registerBlock(BlockRepairer,LibNames.REPAIRER)
  }




  def registerBlocksInventory(): Unit =
  {
    ThaumicTinkerer.proxy.registerInventoryBlock(BlockDarkQuartz,LibNames.DARK_QUARTZ_BLOCK)
    ThaumicTinkerer.proxy.registerInventoryBlock(BlockDarkQuartzPatterned,LibNames.DARK_QUARTZ_PATTERNED)
    ThaumicTinkerer.proxy.registerInventoryBlock(BlockDarkQuartzPatterned,LibNames.DARK_QUARTZ_PATTERNED+"_Pillar",3)
    ThaumicTinkerer.proxy.registerInventoryBlock(BlockFunnel,LibNames.FUNNEL)
    ThaumicTinkerer.proxy.registerInventoryBlock(BlockRepairer,LibNames.REPAIRER)
  }

}
