package baguchan.bagus_cosmetic.client;


import baguchan.bagus_cosmetic.client.render.BackCosmeticRenderer;
import baguchan.bagus_cosmetic.client.render.BodyCosmeticRenderer;
import baguchan.bagus_cosmetic.client.render.HeadCosmeticRenderer;
import baguchan.bagus_cosmetic.client.render.layer.EntityAccessoryLayer;
import baguchan.bagus_cosmetic.registry.ModItems;
import cn.mcmod_mmf.mmlib.client.model.BedrockModelResourceLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistries {
    public static void setupClient(final FMLClientSetupEvent event) {
        CuriosRendererRegistry.register(ModItems.COSMETIC_BACK.get(), BackCosmeticRenderer::new);
        CuriosRendererRegistry.register(ModItems.COSMETIC_HEAD.get(), HeadCosmeticRenderer::new);
        CuriosRendererRegistry.register(ModItems.COSMETIC_BODY.get(), BodyCosmeticRenderer::new);

    }

    @SubscribeEvent
    public static void resourceLoadingListener(final RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new BedrockModelResourceLoader("bagus_cosmetics"));
    }

    @SubscribeEvent
    public static void addEntityLayers(EntityRenderersEvent.AddLayers event) {
        Minecraft.getInstance().getEntityRenderDispatcher().renderers.values().forEach(r -> {

            if (r instanceof LivingEntityRenderer) {
                if (r != null) {
                    ((LivingEntityRenderer) r).addLayer(new EntityAccessoryLayer((LivingEntityRenderer) r));
                }
            }
        });
    }
}
