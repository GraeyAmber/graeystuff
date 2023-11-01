package net.graeyamber.graeystuff.item;

import net.graeyamber.graeystuff.GraeyStuff;
import net.graeyamber.graeystuff.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GraeyStuff.MODID);

    public static final RegistryObject<CreativeModeTab> GRAEYSTUFF_TAB = CREATIVE_MODE_TABS.register("graeystuff_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INGOT_NICKEL.get()))
                    .title(Component.translatable("creativetab.graeystuff_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_NICKEL.get());
                        pOutput.accept(ModItems.INGOT_NICKEL.get());
                        pOutput.accept(ModItems.NUGGET_NICKEL.get());
                        pOutput.accept(ModItems.NUGGET_COPPER.get());

                        pOutput.accept(ModItems.FLUTE.get());

                        pOutput.accept(ModBlocks.RAW_NICKEL_BLOCK.get());
                        pOutput.accept(ModBlocks.NICKEL_BLOCK.get());
                        pOutput.accept(ModBlocks.NICKEL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_NICKEL_ORE.get());

                        pOutput.accept(ModBlocks.REDSTONE_GAUGE_BLOCK.get());
                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
