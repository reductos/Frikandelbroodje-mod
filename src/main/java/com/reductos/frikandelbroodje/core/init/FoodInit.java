package com.reductos.frikandelbroodje.core.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

@SuppressWarnings("SpellCheckingInspection")
public class FoodInit {

    public static final Food HORSE_MEAT = (new Food.Builder().nutrition(3).saturationMod(0.3F).meat().build());

    public static final Food FRIKANDEL = (new Food.Builder().nutrition(7).saturationMod(0.7F).fast().meat().build());

    public static final Food FRIKANDELBROODJE = (new Food.Builder().nutrition(10).saturationMod(1.2F).meat().build());

}

