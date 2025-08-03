package net.mcreator.thewatermod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thewatermod.network.TheWaterModModVariables;

public class AcceptableWaterBottlePlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheWaterModModVariables.PlayerVariables())).water + 300;
			entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.water = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
