package baguchan.bagus_cosmetic;

import baguchan.bagus_cosmetic.registry.ModItems;
import baguchan.bagus_cosmetic.util.CosmeticUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;

@Mod.EventBusSubscriber(modid = BagusCosmetic.MODID)
public class CommonEvents {
    @SubscribeEvent
    public static void spawnWithCosmetic(MobSpawnEvent.FinalizeSpawn event) {
        Mob mob = event.getEntity();
        if (event.getEntity().getRandom().nextFloat() < 0.01F + event.getDifficulty().getEffectiveDifficulty() * 0.01F && mob.level() instanceof ServerLevel) {
            if (!BagusConfigs.COMMON.MOB_WEARABLE_BACK_MODEL.get().isEmpty()) {
                List<? extends String> list = BagusConfigs.COMMON.MOB_WEARABLE_BACK_MODEL.get();
                String name = list.get(Mth.clamp(event.getEntity().getRandom().nextInt(list.size()), 0, list.size() - 1));
                equipAccessory(mob, "back", new ItemStack(ModItems.COSMETIC_BACK.get()), name);
            }
            if (!BagusConfigs.COMMON.MOB_WEARABLE_BODY_MODEL.get().isEmpty()) {
                List<? extends String> list = BagusConfigs.COMMON.MOB_WEARABLE_BODY_MODEL.get();
                String name = list.get(Mth.clamp(event.getEntity().getRandom().nextInt(list.size()), 0, list.size() - 1));
                equipAccessory(mob, "body", new ItemStack(ModItems.COSMETIC_BODY.get()), name);

            }
            if (!BagusConfigs.COMMON.MOB_WEARABLE_HEAD_MODEL.get().isEmpty()) {
                List<? extends String> list = BagusConfigs.COMMON.MOB_WEARABLE_HEAD_MODEL.get();
                String name = list.get(Mth.clamp(event.getEntity().getRandom().nextInt(list.size()), 0, list.size() - 1));
                equipAccessory(mob, "head", new ItemStack(ModItems.COSMETIC_HEAD.get()), name);
            }
        }
    }

    private static void equipAccessory(Mob mob, String identifier, ItemStack stack, String s) {
        CuriosApi.getCuriosInventory(mob).ifPresent((handler) -> {
            boolean empty = true;
            for (SlotResult slotResult : handler.findCurios(identifier)) {
                if (!slotResult.stack().isEmpty()) {
                    empty = false;
                }
            }
            if (empty) {
                CosmeticUtils.setCosmeticLocation(stack, ResourceLocation.tryParse(s));
                handler.setEquippedCurio(identifier, 0, stack);
            }
        });
    }
}
