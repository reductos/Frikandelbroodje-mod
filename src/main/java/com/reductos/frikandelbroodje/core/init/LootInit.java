package com.reductos.frikandelbroodje.core.init;

import com.reductos.frikandelbroodje.*;
import com.reductos.frikandelbroodje.client.*;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.LootTables;
import net.minecraft.resources.IFutureReloadListener;
import net.minecraft.util.*;
import net.minecraftforge.common.loot.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

import javax.annotation.*;

@Mod.EventBusSubscriber(modid = frikandelbroodje.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LootInit {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().register(new horse_meat_modifier.Serializer().setRegistryName(new ResourceLocation(frikandelbroodje.MODID, "horse_meat_modifier")));
    }

}
