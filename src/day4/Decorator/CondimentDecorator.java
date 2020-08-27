package day4.Decorator;

import day4.Coffee.Beverage;

/**
 * 装饰者类
 *
 * @author : liuyuwei
 * @date : 2020-08-27 16:24
 **/
public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;


    @Override
    public abstract String getDescription();
}
