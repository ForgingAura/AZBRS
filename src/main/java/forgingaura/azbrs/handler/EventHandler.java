package forgingaura.azbrs.handler;

import forgingaura.azbrs.capability.IRace;
import forgingaura.azbrs.provider.RaceTypeProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventHandler {

    @SubscribeEvent
    public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event) {

        EntityPlayer player = event.player;

        IRace race_type = player.getCapability(RaceTypeProvider.RACETYPE_CAP, null);


        //String message = String.format("Hello there, you have §7%d§r mana left.", (int) race_type.getRaceType());

        //player.addChatMessage(new TextComponentString(message));

    }



    @SubscribeEvent
    public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {

        EntityPlayer player = event.getEntityPlayer();

        IRace race_type = player.getCapability(RaceTypeProvider.RACETYPE_CAP, null);

        IRace old_race_type = event.getOriginal().getCapability(RaceTypeProvider.RACETYPE_CAP, null);


        race_type.setRaceType(old_race_type.getRaceType());

    }
}
