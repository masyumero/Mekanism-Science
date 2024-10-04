package com.fxd927.mekanismscience.registries;

import com.fxd927.mekanismscience.MekanismScience;
import com.fxd927.mekanismscience.gas.MSChemicalConstants;
import com.fxd927.mekanismscience.mixin.CoolantAccessor;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.attribute.GasAttributes;
import mekanism.common.registration.impl.GasDeferredRegister;
import mekanism.common.registration.impl.GasRegistryObject;

public class MSGases {
    public static final GasDeferredRegister GASES = new GasDeferredRegister(MekanismScience.MODID);

    public static final GasRegistryObject<Gas> AMERICIUM;
    //public static final GasRegistryObject<Gas> AMMONIA;
    public static final GasRegistryObject<Gas> BERYLLIUM;
    //public static final GasRegistryObject<Gas> CALIFORNIUM;
    //public static final GasRegistryObject<Gas> COMPRESSED_AIR;
    //public static final GasRegistryObject<Gas> CURIUM;

    //public static final GasRegistryObject<Gas> DECAYED_NUCLEAR_WASTE;
    //public static final GasRegistryObject<Gas> DECAYED_AMERICIUM;
    //public static final GasRegistryObject<Gas> DECAYED_PLUTONIUM;

    public static final GasRegistryObject<Gas> HELIUM;
    public static final GasRegistryObject<Gas> SUPERHEATED_HELIUM;
    //public static final GasRegistryObject<Gas> NITROGEN;
    //public static final GasRegistryObject<Gas> STRONTIUM;
    //public static final GasRegistryObject<Gas> YTTRIUM;

    private MSGases(){
    }
    
    static {
        AMERICIUM = GASES.register("americium", 13983840, new GasAttributes.Radiation(0.05));
        //AMMONIA = GASES.register(MSChemicalConstants.AMMONIA, new GasAttributes.Fuel(10, FloatingLong.create(20000)));
        BERYLLIUM = GASES.register(MSChemicalConstants.BERYLLIUM);
        //CALIFORNIUM = GASES.register("californium",0xFFF08B00, new GasAttributes.Radiation(1.00));
        //COMPRESSED_AIR = GASES.register(MSChemicalConstants.COMPRESSED_AIR);
        //CURIUM = GASES.register("curium",15725501, new GasAttributes.Radiation(0.07));

        //DECAYED_NUCLEAR_WASTE = GASES.register("decayed_nuclear_waste", 2498581, new ChemicalAttribute[0]);
        //DECAYED_AMERICIUM = GASES.register("decayed_americium", 13983840, new ChemicalAttribute[0]);
        //DECAYED_PLUTONIUM = GASES.register("decayed_plutonium", 2068892, new ChemicalAttribute[0]);

        HELIUM = GASES.register(MSChemicalConstants.HELIUM, Coolants.HELIUM_COOLANT);
        //NITROGEN = GASES.register(MSChemicalConstants.NITROGEN);
        SUPERHEATED_HELIUM = GASES.register(MSChemicalConstants.SUPERHEATED_HELIUM, Coolants.HEATED_HELIUM_COOLANT);
        //STRONTIUM = GASES.register(MSChemicalConstants.STRONTIUM);
        //YTTRIUM = GASES.register(MSChemicalConstants.YTTRIUM);
    }

    public static class Coolants{
        // MekanismScience のコンストラクターで呼び出される
        public static void init(){
            setHeliumCoolantConductivity();
            setSuperheatedHeliumCoolantConductivity();
        }

        public static final GasAttributes.CooledCoolant HELIUM_COOLANT = new GasAttributes.CooledCoolant(() -> SUPERHEATED_HELIUM.get(), 100, 1.0);
        public static final GasAttributes.HeatedCoolant HEATED_HELIUM_COOLANT = new GasAttributes.HeatedCoolant(() -> HELIUM.get(), 100, 1.0);

        public static void setHeliumCoolantConductivity() {
            ((CoolantAccessor) HELIUM_COOLANT).setConductivity(1.5);
        }
        public static void setSuperheatedHeliumCoolantConductivity() {
            ((CoolantAccessor) HEATED_HELIUM_COOLANT).setConductivity(1.5);
        }

          // 発展型
          // MekanismScience のコンストラクターでの MSGases.Coolants.init() の呼び出しを使用せずに、GasAttributes.Coolant のインスタンスを作成する方法
//        public static final GasAttributes.CooledCoolant HELIUM_COOLANT = makeCoolant(GasAttributes.CooledCoolant::new, () -> SUPERHEATED_HELIUM.get(), 100, 1.5);
//        public static final GasAttributes.HeatedCoolant HEATED_HELIUM_COOLANT = makeCoolant(GasAttributes.HeatedCoolant::new, () -> SUPERHEATED_HELIUM.get(), 100, 1.5);

          // 関数型インターフェイスとジェネリクスを用いて、GasAttributes.Coolantを継承するクラスのコンストラクターを引数に渡すために
//        @FunctionalInterface
//        private interface CoolantFactory<C extends GasAttributes.Coolant> {
//            C create(IGasProvider heatedGas, double thermalEnthalpy, double conductivity);
//        }

//        private static <C extends GasAttributes.Coolant> C makeCoolant(CoolantFactory<C> factory, IGasProvider heatedGas, double thermalEnthalpy, double conductivity) {
//            var coolant = factory.create(heatedGas, thermalEnthalpy, 1.0);
//            ((CoolantAccessor) coolant).setConductivity(conductivity);
//            return coolant;
//        }
    }
}
