package net.graeyamber.graeystuff.item;

import net.graeyamber.graeystuff.GraeyStuff;
import net.graeyamber.graeystuff.item.custom.FluteItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    // add items to a list when loader loads the items
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, GraeyStuff.MODID);

    // items
    public static final RegistryObject<Item> RAW_NICKEL = ITEMS.register("raw_nickel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_NICKEL = ITEMS.register("ingot_nickel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_NICKEL = ITEMS.register("nugget_nickel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_COPPER = ITEMS.register("nugget_copper",
            () -> new Item(new Item.Properties()));

    // custom items
    public static final RegistryObject<Item> FLUTE = ITEMS.register("flute",
            () -> new FluteItem(new Item.Properties().durability(256)));

    //register registry
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
