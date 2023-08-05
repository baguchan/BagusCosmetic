package baguchan.bagus_cosmetic.util;

import baguchan.bagus_cosmetic.BagusCosmetic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class CosmeticUtils {
    public static void setCosmeticLocation(ItemStack stack, ResourceLocation resourceLocation){
        CompoundTag compoundTag = stack.getOrCreateTag();
        compoundTag.putString("Cosmetic", resourceLocation.toString());
    }
    public static ResourceLocation cosmeticLocation(ItemStack stack){
        CompoundTag compoundTag = stack.getOrCreateTag();
        if(compoundTag.contains("Cosmetic")){
            return  ResourceLocation.tryParse(compoundTag.getString("Cosmetic"));
        }

        return new ResourceLocation(BagusCosmetic.MODID, "bagu");
    }


    public static ResourceLocation modelLocationFromItem(ItemStack stack){
        return cosmeticLocation(stack);
    }

    public static ResourceLocation textureLocationFromItem(ItemStack stack){
        String nameSpace= cosmeticLocation(stack).getNamespace();
        String path = cosmeticLocation(stack).getPath();
        return new ResourceLocation(nameSpace, "textures/cosmetic/"+path + ".png");
    }
}
