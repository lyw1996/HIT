package day4.Coffee;

/**
 * <h3>HIT</h3>
 * <p>温度</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-27 17:05
 **/
public enum  Temperature {
    Ice,Normal,Heating;

    @Override
    public String toString() {
        switch(this) {
            case Ice: return "加冰";
            case Normal: return "常温";
            case Heating: return "加热";
            default:       return "unspecified";
        }
    }
}
