
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thewatermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.thewatermod.item.PurifiedWaterBottleItem;
import net.mcreator.thewatermod.item.DirtyWaterBottleItem;
import net.mcreator.thewatermod.item.AcceptableWaterBottleItem;
import net.mcreator.thewatermod.TheWaterModMod;

public class TheWaterModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TheWaterModMod.MODID);
	public static final RegistryObject<Item> PURIFIED_WATER_BOTTLE = REGISTRY.register("purified_water_bottle", () -> new PurifiedWaterBottleItem());
	public static final RegistryObject<Item> ACCEPTABLE_WATER_BOTTLE = REGISTRY.register("acceptable_water_bottle", () -> new AcceptableWaterBottleItem());
	public static final RegistryObject<Item> DIRTY_WATER_BOTTLE = REGISTRY.register("dirty_water_bottle", () -> new DirtyWaterBottleItem());
	// Start of user code block custom items
	// End of user code block custom items
}
