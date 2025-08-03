
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thewatermod.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.thewatermod.TheWaterModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheWaterModModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheWaterModMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(TheWaterModModItems.PURIFIED_WATER_BOTTLE.get());
			tabData.accept(TheWaterModModItems.ACCEPTABLE_WATER_BOTTLE.get());
			tabData.accept(TheWaterModModItems.DIRTY_WATER_BOTTLE.get());
		}
	}
}
