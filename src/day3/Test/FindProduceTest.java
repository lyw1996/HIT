package day3.Test;

import day3.Enums.*;
import day3.ProductManage.InstrumentSpec;
import day3.ProductManage.Inventory;

/**
 * @author : liuyuwei
 * @date : 2020-08-26 18:26
 **/
public class FindProduceTest {

    public static void main(String[] args) {
        // 建立产品仓库
        initializeInventory();

        //设置搜索条件
        InstrumentSpec whatBryanLikes = new InstrumentSpec()
                .setClass(InstrumentClass.DESKTOP)
                .setInstrumentBrand(InstrumentBrand.Apple);

        //搜索
        Inventory.searchFor(whatBryanLikes);
    }

    private static Inventory initializeInventory() {
        Inventory inventory = new Inventory();

        InstrumentSpec aDesktop = getSampleDesktop();
        inventory.addInstrument("123456", 4500, aDesktop);

        InstrumentSpec anotherInstrument = getAnotherInstrument();
        inventory.addInstrument("234567", 2000, anotherInstrument);

        InstrumentSpec instrument1 = getAnotherInstrument(InstrumentClass.SERVER);
        inventory.addInstrument("345678", 10000, instrument1);

        InstrumentSpec instrument2 = getAnotherInstrument(InstrumentClass.LAPTOP);
        inventory.addInstrument("456789", 6000, instrument2);

        return inventory;
    }

    private static InstrumentSpec getAnotherInstrument() {
        return new InstrumentSpec()
                .setInstrumentType(InstrumentType.COMPUTER)
                .setClass(InstrumentClass.LAPTOP)
                .setInstrumentBrand(InstrumentBrand.Apple)
                .setInstrumentClassification(InstrumentClassification.LIGHTBOOK)
                .setInstrumentCPU(InstrumentCPU.INTEL);
    }

    private static InstrumentSpec getAnotherInstrument(InstrumentClass instrumentclass) {
        return new InstrumentSpec()
                .setInstrumentType(InstrumentType.COMPUTER)
                .setClass(instrumentclass)
                .setInstrumentBrand(InstrumentBrand.Apple)
                .setInstrumentClassification(InstrumentClassification.LIGHTBOOK)
                .setInstrumentCPU(InstrumentCPU.INTEL);
    }

    private static InstrumentSpec getSampleDesktop() {
        return new InstrumentSpec()
                .setInstrumentType(InstrumentType.COMPUTER)
                .setClass(InstrumentClass.DESKTOP)
                .setInstrumentBrand(InstrumentBrand.Apple)
                .setInstrumentClassification(InstrumentClassification.GAMEBOOK)
                .setInstrumentCPU(InstrumentCPU.AMD);
    }
}
