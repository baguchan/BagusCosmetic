package baguchan.bagus_cosmetic.cap;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosCapability;

public class CosmeticCuriosCapProvider implements ICapabilityProvider {
    private final ItemStack stack;
    private final CosmeticCuriosWrapper curiosInstance;

    public CosmeticCuriosCapProvider(ItemStack stack) {
        this.stack = stack;
        this.curiosInstance = new CosmeticCuriosWrapper(stack);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return LazyOptional.of(this::getCuriosInstance).cast();
    }

    public ItemStack getItemStack() {
        return stack;
    }

    public CosmeticCuriosWrapper getCuriosInstance() {
        return curiosInstance;
    }

}