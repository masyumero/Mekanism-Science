package com.fxd927.mekanismscience.common;

import com.fxd927.mekanismscience.common.registries.MSItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

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
