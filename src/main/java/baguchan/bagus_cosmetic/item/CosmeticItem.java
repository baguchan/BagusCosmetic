package baguchan.bagus_cosmetic.item;

import baguchan.bagus_cosmetic.BagusCosmetic;
import baguchan.bagus_cosmetic.client.render.item.ArmorBWLR;
import baguchan.bagus_cosmetic.util.CosmeticUtils;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotAttribute;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class CosmeticItem extends Item implements ICurioItem {
    public final String slotType;

    public CosmeticItem(Properties properties, String slotType) {
        super(properties);
        this.slotType = slotType;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag unused) {
        return CuriosApi.createCurioProvider(new ICurio() {

            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                // ticking logic here
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
                atts.put(SlotAttribute.getOrCreate(slotType),
                        new AttributeModifier(uuid, BagusCosmetic.MODID + ":slot_bonus", 1,
                                AttributeModifier.Operation.ADDITION));
                CuriosApi.addSlotModifier(atts, slotType, uuid, 1.0, AttributeModifier.Operation.ADDITION);
                return atts;
            }
        });
    }

    public void appendHoverText(ItemStack p_42880_, @Nullable Level p_42881_, List<Component> p_42882_, TooltipFlag p_42883_) {
        if (p_42880_.getTag() != null && p_42880_.getTag().contains("Cosmetic")) {
            p_42882_.add(Component.literal("Cosmetic ID :").withStyle(ChatFormatting.DARK_AQUA));
            p_42882_.add(Component.literal(CosmeticUtils.cosmeticLocation(p_42880_).toString()));
        }
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new ArmorBWLR();
            }
        });
    }
}