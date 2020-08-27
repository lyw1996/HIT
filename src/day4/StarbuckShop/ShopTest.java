package day4.StarbuckShop;

import day4.Coffee.Beverage;
import day4.Coffee.Cappuccino;
import day4.Coffee.Latte;
import day4.Coffee.Size;
import day4.Decorator.Mocha;
import day4.Decorator.Vanilla;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author : liuyuwei
 * @date : 2020-08-27 16:42
 **/
public class ShopTest {
    private static final double TWO_DIGIT_PRECISION = 0.01;


    //测试价格
    @Test
    public void testCost1() {
        Beverage beverage = new Cappuccino();
        Beverage beverageaddContiment=new Mocha(beverage,1);
        assertEquals("cost",35.0,beverageaddContiment.cost(),TWO_DIGIT_PRECISION);

    }

    @Test
    public void testCost2() {
        Beverage beverage = new Latte();
        beverage.setSize(Size.Middle);
        Beverage beverageaddContiment=new Vanilla(beverage,2);
        assertEquals("cost",33.0,beverageaddContiment.cost(),TWO_DIGIT_PRECISION);

    }



}
