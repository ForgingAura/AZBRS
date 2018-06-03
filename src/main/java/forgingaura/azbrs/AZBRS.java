package forgingaura.azbrs;

import forgingaura.azbrs.capability.IRace;
import forgingaura.azbrs.datastorage.RaceTypeStorage;
import forgingaura.azbrs.handler.Race;
import forgingaura.azbrs.race.RaceRenderHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = AZBRS.MODID, name = AZBRS.NAME, version = AZBRS.VERSION)
public class AZBRS {
    public static final String MODID = "azbrs";
    public static final String NAME = "Advanced Zoological or Bionic Race System";
    public static final String VERSION = "PreAlpha-1.0.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CapabilityManager.INSTANCE.register(IRace.class, new RaceTypeStorage(), Race.class);
        //CapabilityManager.INSTANCE.register(IRace.class, new RaceLevelStorage(), Race.class);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new forgingaura.azbrs.handler.EventHandler());
        MinecraftForge.EVENT_BUS.register(new RaceRenderHandler());
    }
}
