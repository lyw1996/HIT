package day3.Enums;
/**
 * @author : liuyuwei
 * @date : 2020-08-26 20:43
 * CPU
 **/
public enum InstrumentCPU {
    //CPU类型
    AMD, INTEL,RuiLong;

    public String toString() {
        switch(this) {
            case AMD: return "AMD系列";
            case INTEL: return "Intel系列";
            case RuiLong: return "锐龙系列";
            default:       return "unspecified";
        }
    }
}
