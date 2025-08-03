
package net.mcreator.thewatermod.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.thewatermod.procedures.WaterEmptyProcedure;
import net.mcreator.thewatermod.procedures.WaterBarDisplayOverlayIngameProcedure;
import net.mcreator.thewatermod.procedures.Water5Procedure;
import net.mcreator.thewatermod.procedures.Water4Procedure;
import net.mcreator.thewatermod.procedures.Water3Procedure;
import net.mcreator.thewatermod.procedures.Water2Procedure;
import net.mcreator.thewatermod.procedures.FullwaterProcedure;
import net.mcreator.thewatermod.procedures.DebugProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class WaterBarOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (WaterBarDisplayOverlayIngameProcedure.execute(world)) {
			if (FullwaterProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_water_mod:textures/screens/fullbottle.png"), w / 2 + 95, h / 2 + 101, 0, 0, 16, 16, 16, 16);
			}
			if (Water2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_water_mod:textures/screens/bottle2.png"), w / 2 + 95, h / 2 + 101, 0, 0, 16, 16, 16, 16);
			}
			if (Water3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_water_mod:textures/screens/bottle3.png"), w / 2 + 95, h / 2 + 101, 0, 0, 16, 16, 16, 16);
			}
			if (Water4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_water_mod:textures/screens/bottle4.png"), w / 2 + 95, h / 2 + 101, 0, 0, 16, 16, 16, 16);
			}
			if (Water5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_water_mod:textures/screens/bottle5.png"), w / 2 + 95, h / 2 + 101, 0, 0, 16, 16, 16, 16);
			}
			if (WaterEmptyProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_water_mod:textures/screens/bottleempty.png"), w / 2 + 95, h / 2 + 101, 0, 0, 16, 16, 16, 16);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DebugProcedure.execute(entity), w / 2 + 121, h / 2 + 104, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
