package com.reductos.frikandelbroodje.core.init;

import com.reductos.frikandelbroodje.client.horse_meat_modifier;
import com.reductos.frikandelbroodje.frikandelbroodje;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = frikandelbroodje.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LootInit {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().register(new horse_meat_modifier.Serializer().setRegistryName(new ResourceLocation(frikandelbroodje.MODID, "horse_meat_modifier")));
    }

}
