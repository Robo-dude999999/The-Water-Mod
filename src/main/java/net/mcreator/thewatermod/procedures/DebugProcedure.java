package net.mcreator.thewatermod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thewatermod.network.TheWaterModModVariables;

public class DebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + (entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheWaterModModVariables.PlayerVariables())).water;
	}
}
