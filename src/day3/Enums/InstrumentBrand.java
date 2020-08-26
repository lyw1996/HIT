package day3.Enums;

/**
 * @author : liuyuwei
 * @date : 2020-08-26 18:22
 * 品牌
 **/
public enum InstrumentBrand {
    Lenovo, Thinkpad,Huawei,Dell,Hp,Asus,Xiaomi,Apple;
    @Override
    public String toString() {
        switch(this) {
            case Lenovo: return "联想";
            case Thinkpad: return "thinkpad";
            case Huawei: return "华为";
            case Dell:return "戴尔";
            case Hp:return "惠普";
            case Asus:return "华硕";
            case Xiaomi:return "小米";
            case Apple:return "苹果";
            default:       return "unspecified";
        }
    }
}
