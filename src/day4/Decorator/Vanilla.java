package day4.Decorator;

import day4.Coffee.Beverage;
import day4.Coffee.Size;

/**
 *
 * @author : liuyuwei
 * @date : 2020-08-27 16:45
 **/
public class Vanilla extends CondimentDecorator {
    Beverage beverage;
    int times;

    public Vanilla(Beverage beverage,int times) {
        this.beverage=beverage;
        this.times=times;
    }

    @Override
    public String getDescription() {

        return this.beverage.getDescription()+"   加香草糖浆";
    }

    @Override
    public double cost() {
        return beverage.cost()+3*times;
    }



    @Override
    public Size getSize() {
        return this.beverage.getSize();
    }
}
