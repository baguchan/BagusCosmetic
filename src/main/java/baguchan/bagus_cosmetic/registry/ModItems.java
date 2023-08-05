package baguchan.bagus_cosmetic.registry;

import baguchan.bagus_cosmetic.BagusCosmetic;
import baguchan.bagus_cosmetic.item.CosmeticItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BagusCosmetic.MODID);

    public static final RegistryObject<Item> BACK_COSMETIC = ITEMS.register("back_cosmetic", () -> new CosmeticItem((new Item.Properties())));
    public static final RegistryObject<Item> HEAD_COSMETIC = ITEMS.register("head_cosmetic", () -> new CosmeticItem((new Item.Properties())));

}
