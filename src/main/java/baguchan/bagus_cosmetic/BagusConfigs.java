package baguchan.bagus_cosmetic;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

@Mod.EventBusSubscriber(modid = BagusCosmetic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BagusConfigs {
    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }


    public static class Common {
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> MOB_WEARABLE_HEAD_MODEL;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> MOB_WEARABLE_BODY_MODEL;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> MOB_WEARABLE_BACK_MODEL;

        public Common(ForgeConfigSpec.Builder builder) {

            MOB_WEARABLE_HEAD_MODEL = builder
                    .comment("Whitelist the wearable head for monster. Use the full name the model id(eg: bagus_cosmetic:bagu.")
                    .define("whitelist Mob Wearable Head Model", Lists.newArrayList("bagus_cosmetic:bagu"));
            MOB_WEARABLE_BODY_MODEL = builder
                    .comment("Whitelist the wearable body for monster. Use the full name the model id(eg: bagus_cosmetic:bagu.")
                    .define("whitelist Mob Wearable Body Model", Lists.newArrayList());
            MOB_WEARABLE_BACK_MODEL = builder
                    .comment("Whitelist the wearable back for monster. Use the full name the model id(eg: bagus_cosmetic:bagu.")
                    .define("whitelist Mob Wearable Back Model", Lists.newArrayList());
        }
    }

}