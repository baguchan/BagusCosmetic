package baguchan.bagus_cosmetic.registry;

import baguchan.bagus_cosmetic.BagusCosmetic;
import baguchan.bagus_cosmetic.item.CosmeticItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.SlotTypePreset;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BagusCosmetic.MODID);

    public static final RegistryObject<Item> COSMETIC_BACK = ITEMS.register("cosmetic_back", () -> new CosmeticItem((new Item.Properties()), SlotTypePreset.BACK.getIdentifier()));
    public static final RegistryObject<Item> COSMETIC_HEAD = ITEMS.register("cosmetic_head", () -> new CosmeticItem((new Item.Properties()), SlotTypePreset.HEAD.getIdentifier()));
    public static final RegistryObject<Item> COSMETIC_BODY = ITEMS.register("cosmetic_body", () -> new CosmeticItem((new Item.Properties()), SlotTypePreset.BODY.getIdentifier()));

}
