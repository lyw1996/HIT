package day4.Decorator;

import day4.Coffee.Beverage;
import day4.Coffee.Size;

/**
 * <h3>HIT</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-08-27 17:00
 **/
public class Mocha extends CondimentDecorator {

    Beverage beverage;
    int times;

    public Mocha(Beverage beverage,int times) {
        this.beverage=beverage;
        this.times=times;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription()+"   加摩卡淋酱";
    }


    @Override
    public Size getSize() {
        return this.beverage.getSize();
    }

    @Override
    public double cost() {
        return beverage.cost()+5*times;
    }


}
