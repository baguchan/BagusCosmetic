package baguchan.bagus_cosmetic.client.render;

import bagu_chan.bagus_lib.client.layer.IArmor;
import baguchan.bagus_cosmetic.util.CosmeticUtils;
import cn.mcmod_mmf.mmlib.client.model.BedrockHumanoidModel;
import cn.mcmod_mmf.mmlib.client.model.bedrock.BedrockVersion;
import cn.mcmod_mmf.mmlib.client.model.pojo.BedrockModelPOJO;
import cn.mcmod_mmf.mmlib.utils.ClientUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class HeadCosmeticRenderer implements ICurioRenderer {

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        LivingEntity living = slotContext.entity();
        if (renderLayerParent.getModel() instanceof IArmor iArmor) {
            VertexConsumer vertexconsumer = renderTypeBuffer
                    .getBuffer(RenderType.entityTranslucent(CosmeticUtils.textureLocationFromItem(stack)));

            BedrockModelPOJO bedrockModelPOJO = ClientUtil.getModelPOJO(CosmeticUtils.modelLocationFromItem(stack));
            if (bedrockModelPOJO != null) {
                BedrockHumanoidModel<T> base_model = new BedrockHumanoidModel<>(
                        bedrockModelPOJO, BedrockVersion.NEW);
                iArmor.headPartArmors().forEach(part -> {
                    matrixStack.pushPose();
                    iArmor.translateToHead(part, matrixStack);
                    base_model.renderToBuffer(matrixStack, vertexconsumer, light,
                            LivingEntityRenderer.getOverlayCoords(living, 0.0F), 1, 1, 1, 1);
                    matrixStack.popPose();
                });
            }
        }
    }
}
