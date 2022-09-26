package net.kav.soul.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kav.soul.Soul;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Moditems {
    public static final Item Soul_Ingot = registerItem("soul_ingot",new Item(new FabricItemSettings().group(ItemGroup.MISC)));//Item is a class and registeritem is function from a class and Soul ingot registre as an object

    private  static Item registerItem(String name, Item item){//class to register the item where Item is a class
        return Registry.register(Registry.ITEM, new Identifier(Soul.MOD_ID,name),item);
    }
    public static void registerModItems(){
        Soul.LOGGER.info("Registering Mod Items for"+ Soul.MOD_ID);
    }
}
