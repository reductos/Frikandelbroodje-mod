package com.reductos.frikandelbroodje.client;

import com.reductos.frikandelbroodje.frikandelbroodje;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

//@Mod.EventBusSubscriber(modid = frikandelbroodje.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {
    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        frikandelbroodje.LOGGER.info("jo items");
        frikandelbroodje.LOGGER.info(event.getItem().toString());
        System.out.println("Item picked up!");
    }
}
