package com.reductos.frikandelbroodje.core.init;

import com.mojang.serialization.Codec;
import com.reductos.frikandelbroodje.client.horse_meat_modifier;
import com.reductos.frikandelbroodje.frikandelbroodje;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootInit {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, frikandelbroodje.MODID);

    public static final RegistryObject<Codec<horse_meat_modifier>> HORSE_MEAT_MODIFIER = GLM.register("horse_meat_modifier", horse_meat_modifier.CODEC);
}
