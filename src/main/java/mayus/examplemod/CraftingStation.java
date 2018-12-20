package mayus.examplemod;


import mayus.examplemod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CraftingStation.MODID, name = CraftingStation.MODNAME, version = CraftingStation.MODVERSION, dependencies = "required-after:forge@[14.23.5.2768,)", useMetadata = true)
public class CraftingStation {

    public static final String MODID = "examplemod";
    public static final String MODNAME = "Example Mod";
    public static final String MODVERSION= "0.0.1";

    @SidedProxy(clientSide = "mayus.examplemod.proxy.ClientProxy", serverSide = "mayus.examplemod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static CraftingStation instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
