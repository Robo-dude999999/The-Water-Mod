package net.mcreator.thewatermod.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.thewatermod.init.TheWaterModModGameRules;

public class ShowWaterDebugProcedureProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(TheWaterModModGameRules.SHOW_WATER_DEBUG);
	}
}
