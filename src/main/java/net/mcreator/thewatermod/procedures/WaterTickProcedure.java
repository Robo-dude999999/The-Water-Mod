package net.mcreator.thewatermod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.thewatermod.network.TheWaterModModVariables;
import net.mcreator.thewatermod.init.TheWaterModModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WaterTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(TheWaterModModGameRules.USE_WATER_BAR)) {
			{
				double _setval = (entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheWaterModModVariables.PlayerVariables())).water - 0.1;
				entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.water = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheWaterModModVariables.PlayerVariables())).water < 100 && Math.round(Mth.nextInt(RandomSource.create(), 1, 2)) == 1) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_water_mod:thirst")))), 1);
			}
			if (entity.isUnderWater()) {
				{
					double _setval = 1000;
					entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.water = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity instanceof LivingEntity _entUseItem5 ? _entUseItem5.getUseItem() : ItemStack.EMPTY).getItem() == Items.POTION && (entity instanceof LivingEntity _entUseTicks7 ? _entUseTicks7.getTicksUsingItem() : 0) > 28) {
				{
					double _setval = (entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheWaterModModVariables.PlayerVariables())).water + 400;
					entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.water = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheWaterModModVariables.PlayerVariables())).water > 1000) {
					{
						double _setval = 1000;
						entity.getCapability(TheWaterModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
