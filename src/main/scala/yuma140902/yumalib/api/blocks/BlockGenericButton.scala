package yuma140902.yumalib.api.blocks

import yuma140902.uptodatemod.registry.RecipeRegister
import yuma140902.yumalib.api.registry.Contexts
import yuma140902.yumalib.api.util.NameExtensions._
import yuma140902.yumalib.api.util.{BlockWithMetadata, GameRegistryEx, Name}
import yuma140902.yumalib.api.{IHasRecipes, IRegisterable}

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.block.{Block, BlockButtonWood}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import net.minecraft.util.IIcon;

class BlockGenericButton(
                          /** ベースとなるブロック */
                          val baseBlock: BlockWithMetadata,

                          /** 名前 */
                          val name: Name
                        )
  extends BlockButtonWood with IRegisterable with IHasRecipes {

  this.setHardness(0.5F);
  this.setStepSound(Block.soundTypeWood);
  this.setCreativeTab(CreativeTabs.tabRedstone);

  @SideOnly(Side.CLIENT)
  override def getIcon(side: Int, meta: Int): IIcon =
    baseBlock.block.getIcon(1, baseBlock.meta)

  override def register(): Unit = {
    this.setBlockName(Contexts.current.nameProvider.domainedUnlocalized(name.str))
    this.setBlockTextureName(Contexts.current.nameProvider.domainedTexture(name))
    GameRegistryEx.registerBlock(this, name)
  }


  override def registerRecipes(): Unit = {
    RecipeRegister.addShapeless(new ItemStack(this), new ItemStack(baseBlock.block, 1, baseBlock.meta))
  }
}
