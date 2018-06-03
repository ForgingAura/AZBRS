package forgingaura.azbrs.datastorage;

import forgingaura.azbrs.capability.IRace;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class RaceTypeStorage implements Capability.IStorage<IRace> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IRace> capability, IRace instance, EnumFacing side) {
        return new NBTTagInt(instance.getRaceType());
    }

    @Override
    public void readNBT(Capability<IRace> capability, IRace instance, EnumFacing side, NBTBase nbt) {
        instance.setRaceType(((NBTPrimitive) nbt).getInt());
    }
}
