package baguchan.bagus_cosmetic.item;

import baguchan.bagus_cosmetic.util.CosmeticUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;
import java.util.List;

public class CosmeticItem extends Item implements ICurioItem {
    public CosmeticItem(Item.Properties properties) {
        super(properties);
    }

    public void appendHoverText(ItemStack p_42880_, @Nullable Level p_42881_, List<Component> p_42882_, TooltipFlag p_42883_) {
        if (!p_42880_.getTag().isEmpty() && p_42880_.getTag().contains("Cosmetic")) {
            p_42882_.add(Component.literal("Cosmetic ID :").withStyle(ChatFormatting.DARK_AQUA));
            p_42882_.add(Component.literal(CosmeticUtils.cosmeticLocation(p_42880_).toString()));
        }
    }
}