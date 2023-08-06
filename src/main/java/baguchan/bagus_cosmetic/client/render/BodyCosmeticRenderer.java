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

public class BodyCosmeticRenderer implements ICurioRenderer {

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

                iArmor.rightHandArmors().forEach(part -> {
                    if (base_model.rightArm != null) {
                        matrixStack.pushPose();
                        base_model.rightArm.x = 0;
                        base_model.rightArm.y = 0;
                        base_model.rightArm.z = 0;
                        base_model.rightArm.offsetX = 0;
                        base_model.rightArm.offsetY = 0;
                        base_model.rightArm.offsetZ = 0;
                        iArmor.translateToChestPat(part, matrixStack);
                        base_model.rightArm.render(matrixStack, vertexconsumer, light,
                                LivingEntityRenderer.getOverlayCoords(living, 0.0F), 1, 1, 1, 1);
                        matrixStack.popPose();
                    }
                });
                iArmor.leftHandArmors().forEach(part -> {
                    if (base_model.leftArm != null) {
                        matrixStack.pushPose();
                        base_model.leftArm.x = 0;
                        base_model.leftArm.y = 0;
                        base_model.leftArm.z = 0;
                        base_model.leftArm.offsetX = 0;
                        base_model.leftArm.offsetY = 0;
                        base_model.leftArm.offsetZ = 0;
                        iArmor.translateToChestPat(part, matrixStack);
                        base_model.leftArm.render(matrixStack, vertexconsumer, light,
                                LivingEntityRenderer.getOverlayCoords(living, 0.0F), 1, 1, 1, 1);
                        matrixStack.popPose();
                    }
                });

                iArmor.rightLegPartArmors().forEach(part -> {
                    if (base_model.rightLeg != null) {
                        matrixStack.pushPose();
                        base_model.rightLeg.x = 0;
                        base_model.rightLeg.y = 0;
                        base_model.rightLeg.z = 0;
                        base_model.rightLeg.offsetX = 0;
                        base_model.rightLeg.offsetY = 0;
                        base_model.rightLeg.offsetZ = 0;
                        iArmor.translateToLeg(part, matrixStack);
                        base_model.rightLeg.render(matrixStack, vertexconsumer, light,
                                LivingEntityRenderer.getOverlayCoords(living, 0.0F), 1, 1, 1, 1);
                        matrixStack.popPose();
                    }
                });
                iArmor.leftLegPartArmors().forEach(part -> {
                    if (base_model.leftLeg != null) {
                        matrixStack.pushPose();
                        base_model.leftLeg.x = 0;
                        base_model.leftLeg.y = 0;
                        base_model.leftLeg.z = 0;
                        base_model.leftLeg.offsetX = 0;
                        base_model.leftLeg.offsetY = 0;
                        base_model.leftLeg.offsetZ = 0;
                        iArmor.translateToLeg(part, matrixStack);
                        base_model.leftLeg.render(matrixStack, vertexconsumer, light,
                                LivingEntityRenderer.getOverlayCoords(living, 0.0F), 1, 1, 1, 1);
                        matrixStack.popPose();
                    }
                });
                iArmor.headPartArmors().forEach(part -> {
                    if (base_model.head != null) {
                        matrixStack.pushPose();
                        base_model.head.x = 0;
                        base_model.head.y = 0;
                        base_model.head.z = 0;
                        base_model.head.offsetX = 0;
                        base_model.head.offsetY = 0;
                        base_model.head.offsetZ = 0;
                        iArmor.translateToHead(part, matrixStack);
                        base_model.head.render(matrixStack, vertexconsumer, light,
                                LivingEntityRenderer.getOverlayCoords(living, 0.0F), 1, 1, 1, 1);
                        matrixStack.popPose();
                    }
                });
                iArmor.bodyPartArmors().forEach(part -> {
                    if (base_model.body != null) {
                        matrixStack.pushPose();
                        base_model.body.x = 0;
                        base_model.body.y = 0;
                        base_model.body.z = 0;
                        base_model.body.offsetX = 0;
                        base_model.body.offsetY = 0;
                        base_model.body.offsetZ = 0;
                        iArmor.translateToChest(part, matrixStack);
                        base_model.body.render(matrixStack, vertexconsumer, light,
                                LivingEntityRenderer.getOverlayCoords(living, 0.0F), 1, 1, 1, 1);
                        matrixStack.popPose();
                    }
                });

            }

        }
    }
}
