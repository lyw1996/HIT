package day4.Coffee;

/**
 * 卡布奇诺
 * @author : liuyuwei
 * @date : 2020-08-27 16:39
 **/
public class Cappuccino extends Beverage {

    public Cappuccino(){
        description="卡布奇诺";
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
