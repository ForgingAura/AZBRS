package forgingaura.azbrs.race;

import forgingaura.azbrs.AZBRS;
import forgingaura.azbrs.race.cyborg.ModelCyborgFemale;
import forgingaura.azbrs.race.cyborg.ModelCyborgMale;
import forgingaura.azbrs.race.cyborg.RenderCyborgFemale;
import forgingaura.azbrs.race.cyborg.RenderCyborgMale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RaceRenderHandler {

    RenderLivingBase cyborgMaleRender = new RenderCyborgMale(Minecraft.getMinecraft().getRenderManager());
    ModelBiped cyborgMaleModel = new ModelCyborgMale(1F);

    RenderLivingBase cyborgFemaleRender = new RenderCyborgFemale(Minecraft.getMinecraft().getRenderManager());
    ModelBiped cyborgFemaleModel = new ModelCyborgFemale(0.95F);

    boolean hasAMale = true;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event) {
    }




    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void preRenderPlayer(RenderPlayerEvent.Pre event)
    {
        if(!this.hasAMale) {
            return;
        }
        else {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            event.setCanceled(true);
            cyborgMaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), cyborgMaleModel, 0.5F){
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return new ResourceLocation(AZBRS.MODID + ":" + "textures/race/cyborg_male.png");
                }
            };
            cyborgMaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        }
    }




    /*
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void preRenderPlayer(RenderPlayerEvent.Pre event) {
        if(hasAMale) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            event.setCanceled(true);
            cyborgMaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), cyborgMaleModel, 0.5F) {
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return new ResourceLocation(AZBRS.MODID + ":" + "textures/race/cyborg_male.png");
                }
            };
            cyborgMaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        } else {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            event.setCanceled(true);
            cyborgFemaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), cyborgFemaleModel, 0.5F) {
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return new ResourceLocation(AZBRS.MODID + ":" + "textures/race/cyborg_female.png");
                }
            };
            cyborgFemaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        }
    }
    */
}
