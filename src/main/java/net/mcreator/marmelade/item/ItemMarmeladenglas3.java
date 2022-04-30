
package net.mcreator.marmelade.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.marmelade.procedure.ProcedureMarmeladenglas3FoodEaten;
import net.mcreator.marmelade.creativetab.TabMarmeladenmod;
import net.mcreator.marmelade.ElementsMarmeladeMod;

import java.util.Map;
import java.util.HashMap;

@ElementsMarmeladeMod.ModElement.Tag
public class ItemMarmeladenglas3 extends ElementsMarmeladeMod.ModElement {
	@GameRegistry.ObjectHolder("marmelade:marmeladenglas3")
	public static final Item block = null;
	public ItemMarmeladenglas3(ElementsMarmeladeMod instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("marmelade:marmeladenglas3", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(4, 0.3f, false);
			setUnlocalizedName("marmeladenglas3");
			setRegistryName("marmeladenglas3");
			setCreativeTab(TabMarmeladenmod.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.DRINK;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureMarmeladenglas3FoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
