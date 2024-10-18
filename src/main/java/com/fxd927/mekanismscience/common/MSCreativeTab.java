package com.fxd927.mekanismscience.common;

import com.fxd927.mekanismscience.common.registries.MSFluids;
import com.fxd927.mekanismscience.common.registries.MSItems;
import net.minecraft.core.NonNullList;
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
        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            super.fillItemList(items);

            // カスタムタブに表示させたいアイテムを一括で追加
            items.add(new ItemStack(MSItems.NEUTRON_SOURCE_PELLET));
            items.add(new ItemStack(MSItems.DUST_CALCIUM_OXIDE));
            items.add(new ItemStack(MSFluids.YTTRIUM.getBucket()));
            items.add(new ItemStack(MSFluids.BERYLLIUM.getBucket()));
            items.add(new ItemStack(MSFluids.HELIUM.getBucket()));
            items.add(new ItemStack(MSFluids.STRONTIUM.getBucket()));
            items.add(new ItemStack(MSFluids.SUPERHEATED_HELIUM.getBucket()));

        }
    };
}
