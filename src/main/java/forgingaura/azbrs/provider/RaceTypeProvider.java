package forgingaura.azbrs.provider;

import forgingaura.azbrs.capability.IRace;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RaceTypeProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IRace.class)
    public static final Capability<IRace> RACETYPE_CAP = null;

    private IRace instance = RACETYPE_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == RACETYPE_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == RACETYPE_CAP ? RACETYPE_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return RACETYPE_CAP.getStorage().writeNBT(RACETYPE_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        RACETYPE_CAP.getStorage().readNBT(RACETYPE_CAP, this.instance, null, nbt);
    }
}
