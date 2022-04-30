
package net.mcreator.marmelade.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.marmelade.item.ItemMarmeladenglas3;
import net.mcreator.marmelade.ElementsMarmeladeMod;

@ElementsMarmeladeMod.ModElement.Tag
public class TabMarmeladenmod extends ElementsMarmeladeMod.ModElement {
	public TabMarmeladenmod(ElementsMarmeladeMod instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabmarmeladenmod") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemMarmeladenglas3.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
