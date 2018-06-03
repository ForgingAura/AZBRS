package forgingaura.azbrs.handler;

import forgingaura.azbrs.AZBRS;
import forgingaura.azbrs.provider.RaceTypeProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {

    public static final ResourceLocation RACETYPE_CAP = new ResourceLocation(AZBRS.MODID, "race_type");


    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event){

        if (!(event.getObject() instanceof EntityPlayer)) return;
        event.addCapability(RACETYPE_CAP, new RaceTypeProvider());

    }
}
