package com.fxd927.mekanismscience.common;

import com.fxd927.mekanismscience.common.registries.MSItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

//public class MSCreativeTab {
//    public static final CreativeTabDeferredRegister CREATIVE_TABS = new CreativeTabDeferredRegister(MekanismScience.MODID);
//
//    public static final CreativeTabRegistryObject MEKANISM_SCIENCE = CREATIVE_TABS.registerMain(MSLang.MEKANISM_SCIENCE, MSItems.NEUTRON_SOURCE_PELLET, builder ->
//              builder.withBackgroundLocation(MekanismScience.rl("textures/gui/creative_tab.png"))
//                      .withSearchBar(70)
//                      .withTabsBefore(MekanismCreativeTabs.MEKANISM.key())
//                      .displayItems((displayParameters, output) -> {
//                          CreativeTabDeferredRegister.addToDisplay(MSItems.ITEMS, output);
//                          //CreativeTabDeferredRegister.addToDisplay(MSBlocks.BLOCKS, output);
//                          CreativeTabDeferredRegister.addToDisplay(MSFluids.FLUIDS, output);
//                    })
//    );
//}
public class MSCreativeTab {

    // 新しいクリエイティブタブの定義
    public static final CreativeModeTab MEKANISM_SCIENCE = new CreativeModeTab("mekanism_science") {
        @Override
        public @NotNull ItemStack makeIcon() {
            // クリエイティブタブのアイコンに使用するアイテムを設定（例：ダイヤモンド）
            return new ItemStack(MSItems.NEUTRON_SOURCE_PELLET);
        }
    };
}
