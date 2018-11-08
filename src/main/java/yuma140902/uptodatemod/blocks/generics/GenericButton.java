package yuma140902.uptodatemod.blocks.generics;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import yuma140902.uptodatemod.IRegisterable;
import yuma140902.uptodatemod.ModUpToDateMod;

public class GenericButton extends BlockButtonWood implements IRegisterable {
	private int texture_plank_meta;
	private String name;
	
	public GenericButton(int texture_plank_meta, String name) {
		this.texture_plank_meta = texture_plank_meta;
		this.setHardness(0.5F);
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.name = name;
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return Blocks.planks.getIcon(1, texture_plank_meta);
	}

	@Override
	public void register() {
		this.setBlockName(ModUpToDateMod.MOD_ID + "." + name);
		this.setBlockTextureName(ModUpToDateMod.MOD_ID + ":" + name);
		GameRegistry.registerBlock(this, name);
	}
}