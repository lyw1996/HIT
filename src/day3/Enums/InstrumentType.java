package day3.Enums;
/**
 * @author : liuyuwei
 * @date : 2020-08-26 18:22
 **/
public enum InstrumentType {
    COMPUTER;

    public String toString() {
        switch(this) {
            case COMPUTER:   return "电脑整机";
            default:       return "Unspecified";
        }
    }
}
