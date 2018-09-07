package yuma140902.uptodatemod.blocks;

import java.util.Random;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import yuma140902.uptodatemod.IRegisterable;
import yuma140902.uptodatemod.ModUpToDateMod;
import yuma140902.uptodatemod.MyItems;

public class DoorSpruce extends net.minecraft.block.BlockDoor implements IRegisterable {
	
	public DoorSpruce() {
		super(Material.wood);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeWood);
		this.disableStats();
	}
	
	public void register() {
		this.setBlockName(ModUpToDateMod.MOD_ID + ".door_spruce");
		this.setBlockTextureName(ModUpToDateMod.MOD_ID + ":door_spruce");
		GameRegistry.registerBlock(this, "door_spruce");
	}
	

	@Override
	public Item getItemDropped(int meta, Random rand, int p_149650_3_)
  {
		return (meta & 8) != 0 ? null : MyItems.itemDoorSpruce;
  }

	@Override
	@SideOnly(Side.CLIENT)
  public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
  {
      return MyItems.itemDoorSpruce;
  }
}
