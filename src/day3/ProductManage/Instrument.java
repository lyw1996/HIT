package day3.ProductManage;
/**
 * @author : liuyuwei
 * @date : 2020-08-26 18:20
 **/
//该类设计体现srp，分离职责，负责创建实例的基本属性

public class Instrument {
    private String serialNumber;
    private double price;
    private InstrumentSpec spec;

    public Instrument(String serialNumber, double price, InstrumentSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }

    String getDescription() {
        String instrumentClass = getOrDefault(spec.getInstrumentClass());
        String instrumentType = getOrDefault(spec.getInstrumentType());

        return instrumentClass +
                " " + instrumentType;
    }

    private String getOrDefault(Enum item) {
        return item == null ? "" : (item.toString() + " ");
    }

    String getPriceInfo() {
        return "符合您要求的电脑有这台:" +
                getOrDefault(spec.getInstrumentType()) +
                getOrDefault(spec.getInstrumentClass()) +
                getOrDefault(spec.getInstrumentClassification()) +
                getOrDefault(spec.getInstrumentCPU()) +
                getOrDefault(spec.getInstrumentBrand()) + "价格:" +
                getPrice() + "元\n---";
    }

    private String getIntro() {
        return this.getDescription() + "\n" +
                this.getPriceInfo();
    }

    public void printIntro() {
        System.out.println(getIntro());
    }

}
