package net.mcreator.thewatermod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thewatermod.network.TheWaterModModVariables;

public class Water2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheWaterModModVariables.PlayerVariables())).water > 668
				&& (entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheWaterModModVariables.PlayerVariables())).water < 834;
	}
}
