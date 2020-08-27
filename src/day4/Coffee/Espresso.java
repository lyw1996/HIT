package day4.Coffee;

/**
 * <h3>HIT</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-08-27 17:34
 **/
public class Espresso extends Beverage {

    public Espresso() {
        description="浓缩咖啡";
        size=Size.Large;
        temperature=Temperature.Normal;
    }

    @Override
    public double cost() {
        switch (getSize()){
            case Middle:return 17;
            case Large:return 22;
            case SuperLarge:return 27;
            default:return 22;
        }
    }
}
