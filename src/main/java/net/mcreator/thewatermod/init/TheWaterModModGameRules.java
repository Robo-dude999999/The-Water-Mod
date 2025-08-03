
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thewatermod.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheWaterModModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> USE_WATER_BAR = GameRules.register("useWaterBar", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> SHOW_WATER_DEBUG = GameRules.register("showWaterDebug", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
