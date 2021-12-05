package com.reductos.frikandelbroodje.core.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

@SuppressWarnings("SpellCheckingInspection")
public class FoodInit {

    //    public static final Food GOLDEN_APPLE = (new Food.Builder()).nutrition(4).saturationMod(1.2F).effect(new EffectInstance(Effects.REGENERATION, 100, 1), 1.0F).effect(new EffectInstance(Effects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build();
    //    public static final Food COOKED_BEEF = (new Food.Builder()).nutrition(8).saturationMod(0.8F).meat().build();public

    public static final Food HORSE_MEAT = (new Food.Builder().nutrition(3).saturationMod(0.3F).meat().build());

    public static final Food FRIKANDEL = (new Food.Builder().nutrition(7).saturationMod(0.7F).fast().meat().build());

    public static final Food FRIKANDELBROODJE = (new Food.Builder().nutrition(10).saturationMod(1.2F).meat().build());

//    public static final Food BLIKJE_ENERGY = (new Food.Builder().nutrition(4).saturationMod(0.5F).fast().alwaysEat().effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 1800, 1), 1).build());


}

