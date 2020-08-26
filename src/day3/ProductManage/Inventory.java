package day3.ProductManage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author : liuyuwei
 * @date : 2020-08-26 18:20
 **/

//该类体现了srp设计，记录所有库存
public class Inventory {
    private static List<Instrument> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    //此处体现srp
    public void addInstrument(String serialNumber, double price,
                              InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec);
        inventory.add(instrument);
    }

    public Instrument getBySerialNumber(String serialNumber) {
        for (Instrument instrument : inventory) {
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    private static List<Instrument> search(InstrumentSpec searchSpec) {
        return inventory.stream()
                .filter(instrument -> instrument.getSpec().matches(searchSpec))
                .collect(Collectors.toList());
    }
    //此处体现srp
    public static void searchFor(InstrumentSpec inputSpec) {

        List<Instrument> matchingInstruments = search(inputSpec);
        System.out.println(getselsctInfo(inputSpec));

        if (matchingInstruments.isEmpty()) {
            System.out.println("对不起，没有找到您想要的电脑.");
            return;
        }

        System.out.println("以下为您可能感兴趣的电脑:");
        matchingInstruments.forEach(Instrument::printIntro);
    }

    private static String getOrDefault(Enum item) {
        return item == null ? "" : (item.toString() + " ");
    }
    //此处体现srp
    static String getselsctInfo(InstrumentSpec inputSpec) {
        return "您的筛选条件为:" +
                getOrDefault(inputSpec.getInstrumentType()) +
                getOrDefault(inputSpec.getInstrumentClass()) +
                getOrDefault(inputSpec.getInstrumentClassification()) +
                getOrDefault(inputSpec.getInstrumentCPU()) +
                getOrDefault(inputSpec.getInstrumentBrand()) + "\n---";
    }

}
