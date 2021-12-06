package com.reductos.frikandelbroodje.core.init;

import net.minecraft.world.food.FoodProperties;

@SuppressWarnings("SpellCheckingInspection")
public class FoodInit {

    public static final FoodProperties HORSE_MEAT = (new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).meat().build());

    public static final FoodProperties FRIKANDEL = (new FoodProperties.Builder().nutrition(7).saturationMod(0.7F).fast().meat().build());

    public static final FoodProperties FRIKANDELBROODJE = (new FoodProperties.Builder().nutrition(10).saturationMod(1.2F).meat().build());

}

