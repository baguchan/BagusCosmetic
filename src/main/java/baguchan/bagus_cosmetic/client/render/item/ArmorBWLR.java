package baguchan.bagus_cosmetic.client.render.item;

import baguchan.bagus_cosmetic.util.CosmeticUtils;
import cn.mcmod_mmf.mmlib.client.model.SimpleBedrockModel;
import cn.mcmod_mmf.mmlib.client.model.pojo.BedrockModelPOJO;
import cn.mcmod_mmf.mmlib.utils.ClientUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class ArmorBWLR extends BlockEntityWithoutLevelRenderer {

    public ArmorBWLR() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());

    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pOverlay) {
        BedrockModelPOJO bedrockModelPOJO = ClientUtil.getModelPOJO(CosmeticUtils.modelLocationFromItem(pStack));
        if (bedrockModelPOJO != null) {
            SimpleBedrockModel base_model = new SimpleBedrockModel(
                    bedrockModelPOJO);
            VertexConsumer vertexconsumer = pBuffer
                    .getBuffer(RenderType.entityTranslucent(CosmeticUtils.textureLocationFromItem(pStack)));

            pPoseStack.scale(1.0F, -1.0F, -1.0F);
            pPoseStack.translate(0.65F, -0.65F, 0);
            base_model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, pOverlay, 1, 1, 1, 1);
        }
    }
}