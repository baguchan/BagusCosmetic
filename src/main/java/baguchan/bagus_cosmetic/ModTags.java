package baguchan.bagus_cosmetic;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> COSMETIC = tag("cosmetic");
        public static final TagKey<Item> BACK = tag("back");
        public static final TagKey<Item> HANDS = tag("hands");
        public static final TagKey<Item> HEAD = tag("head");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(BagusCosmetic.MODID, name));
        }

    }
}
