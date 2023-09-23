package baguchan.bagus_cosmetic;

import baguchan.bagus_cosmetic.client.ClientRegistries;
import baguchan.bagus_cosmetic.registry.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BagusCosmetic.MODID)
public class BagusCosmetic
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "bagus_cosmetic";

    public BagusCosmetic()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        ModItems.ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientRegistries::setupClient));
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BagusConfigs.COMMON_SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
