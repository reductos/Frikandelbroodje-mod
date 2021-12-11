package com.reductos.frikandelbroodje.core.init;

import com.reductos.frikandelbroodje.frikandelbroodje;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = frikandelbroodje.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VillagerInit {
    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event) {

        if (event.getType() == VillagerProfession.BUTCHER) {
            event.getTrades().get(5).add(new VillagerTrades.ItemsForEmeraldsTrade(ItemInit.FRIKANDELBROODJE.get(), 4, 2, 30));

        }
    }
}
