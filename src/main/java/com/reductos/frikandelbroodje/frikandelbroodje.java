package com.reductos.frikandelbroodje;

import com.reductos.frikandelbroodje.core.init.ItemInit;
import com.reductos.frikandelbroodje.core.init.LootInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("SpellCheckingInspection")
@Mod(frikandelbroodje.MODID)
public class frikandelbroodje {
    public static final String MODID = "frikandelbroodje";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final CreativeModeTab TAB_FRIKANDEL = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return ItemInit.FRIKANDELBROODJE.get().getDefaultInstance();
        }
    };

    public frikandelbroodje() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        LootInit.GLM.register(bus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }


}

