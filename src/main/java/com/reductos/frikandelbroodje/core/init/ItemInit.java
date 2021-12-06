package com.reductos.frikandelbroodje.core.init;

import com.reductos.frikandelbroodje.frikandelbroodje;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("SpellCheckingInspection")
public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, frikandelbroodje.MODID);


    public static final RegistryObject<Item> horse_meat = ITEMS.register("horse_meat", () -> new Item(new Item.Properties().tab(frikandelbroodje.TAB_FRIKANDEL).food(FoodInit.HORSE_MEAT)));
    public static final RegistryObject<Item> FRIKANDEL = ITEMS.register("frikandel", () -> new Item(new Item.Properties().tab(frikandelbroodje.TAB_FRIKANDEL).food(FoodInit.FRIKANDEL)));
    public static final RegistryObject<Item> FRIKANDELBROODJE = ITEMS.register("frikandelbroodje", () -> new Item(new Item.Properties().tab(frikandelbroodje.TAB_FRIKANDEL).food(FoodInit.FRIKANDELBROODJE)));

}
