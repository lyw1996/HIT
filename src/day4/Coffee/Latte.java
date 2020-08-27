package day4.Coffee;

/**
 * <h3>HIT</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-08-27 17:04
 **/
public class Latte extends Beverage {
    public Latte(){
        description="拿铁";
        size=Size.Large;
        temperature=Temperature.Normal;
    }

    @Override
    public double cost() {
        switch (getSize()){
            case Middle:return 27;
            case Large:return 30;
            case SuperLarge:return 33;
            default:return 30;
        }
    }
}
