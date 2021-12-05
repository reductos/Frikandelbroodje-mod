package com.reductos.frikandelbroodje;

import com.reductos.frikandelbroodje.core.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("SpellCheckingInspection")
@Mod(frikandelbroodje.MODID)
public class frikandelbroodje {
    public static final String MODID = "frikandelbroodje";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup TAB_FRIKANDEL = new ItemGroup(MODID) {
        @Override
        public ItemStack makeIcon() {
            return ItemInit.FRIKANDELBROODJE.get().getDefaultInstance();
        }
    };

    public frikandelbroodje() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        bus.addListener(this::setup);
//        MinecraftForge.EVENT_BUS.register(new EventHandler());
        ItemInit.ITEMS.register(bus);
//        BlockInit.BLOCKS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }


}

//@Mod.EventBusSubscriber(modid = frikandelbroodje.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class EventHandlers {
//    @SubscribeEvent
//    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
//        event.getRegistry().register(new LootModifiers.Serializer().setRegistryName(new ResourceLocation(frikandelbroodje.MODID, "horse_meat")));
//    }
//}