package com.reductos.frikandelbroodje.core.init;

import com.reductos.frikandelbroodje.frikandelbroodje;
import net.minecraft.item.*;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("SpellCheckingInspection")
public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, frikandelbroodje.MODID);

    //    public static final RegistryObject<Item> GOLDEN_APPLE = ITEMS.register("golden_apple", ()-> new Item((new Item.Properties()).tab(ItemGroup.TAB_FOOD).rarity(Rarity.RARE).food(Foods.GOLDEN_APPLE)));

    public static final RegistryObject<Item> horse_meat = ITEMS.register("horse_meat", () -> new Item(new Item.Properties().tab(frikandelbroodje.TAB_FRIKANDEL).food(FoodInit.HORSE_MEAT)));
    public static final RegistryObject<Item> FRIKANDEL = ITEMS.register("frikandel", () -> new Item(new Item.Properties().tab(frikandelbroodje.TAB_FRIKANDEL).food(FoodInit.FRIKANDEL)));
    public static final RegistryObject<Item> FRIKANDELBROODJE = ITEMS.register("frikandelbroodje", () -> new Item(new Item.Properties().tab(frikandelbroodje.TAB_FRIKANDEL).food(FoodInit.FRIKANDELBROODJE)));
//    public static final RegistryObject<Item> blikje_energy = ITEMS.register("blikje_energy", () -> new Item(new Item.Properties().tab(frikandelbroodje.TAB_FRIKANDEL).food(FoodInit.BLIKJE_ENERGY)));
//    public static final RegistryObject<Item> MUSIC_DISC_ = ITEMS.register("MUSIC_DISC_", () -> new MusicDiscItem(13, SoundEvents.MUSIC_DISC_PIGSTEP, (new Item.Properties()).stacksTo(1).tab(ItemGroup.TAB_MISC).rarity(Rarity.RARE)));

//    public static final Item MUSIC_DISC_PIGSTEP = registerItem("music_disc_pigstep", () -> new MusicDiscItem(13, SoundEvents.MUSIC_DISC_PIGSTEP, (new Item.Properties()).stacksTo(1).tab(ItemGroup.TAB_MISC).rarity(Rarity.RARE)));

}
