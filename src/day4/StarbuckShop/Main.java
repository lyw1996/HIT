package day4.StarbuckShop;

import day4.Coffee.*;
import day4.Decorator.Mocha;
import day4.Decorator.Vanilla;

import java.util.Scanner;

/**
 * <h3>HIT</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-08-27 17:03
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("欢迎进入点单系统，请选择咖啡：");
        System.out.println("1.卡布奇诺    2.拿铁    3 浓缩咖啡    (任意键默认卡布奇诺)");
        Scanner scanner = new Scanner(System.in);
        int coffeeType = scanner.nextInt();
        Beverage coffee;
        switch (coffeeType) {
            case 1:
                coffee = new Cappuccino();
                break;
            case 2:
                coffee = new Latte();
                break;
            case 3:
                coffee = new Espresso();
                break;
            default:
                coffee = new Cappuccino();
        }
        System.out.println("请选择杯型：");
        System.out.println("1.中杯    2.大杯   3.超大杯  （任意键默认大杯）");
        int size = scanner.nextInt();
        switch (size) {
            case 1:
                coffee.setSize(Size.Middle);
                break;
            case 2:
                coffee.setSize(Size.Large);
                break;
            case 3:
                coffee.setSize(Size.SuperLarge);
                break;
        }
        System.out.println("请选择温度：");
        System.out.println(("1.加冰    2.常温   3.加热  （任意键默认常温）"));
        int tem = scanner.nextInt();
        switch (tem) {
            case 1:
                coffee.setTemperature(Temperature.Ice);
                break;
            case 2:
                coffee.setTemperature(Temperature.Normal);
                break;
            case 3:
                coffee.setTemperature(Temperature.Heating);
                break;
        }

        System.out.println("请选择加料：");
        System.out.println("1.香草糖浆    2.摩卡淋酱 （任意键默认不加）");
        int condimentType = scanner.nextInt();
        Beverage coffeeaddcondiment;
        int times=1;
        if(condimentType==1||condimentType==2){
            System.out.println("加料份数：（任意键默认一份）");
            times = scanner.nextInt();
        }

        switch (condimentType) {
            case 1:
                coffeeaddcondiment = new Vanilla(coffee, times);
                break;
            case 2:
                coffeeaddcondiment = new Mocha(coffee, times);
                break;
            default:
                coffeeaddcondiment = coffee;
        }

        System.out.println(coffeeaddcondiment.getDescription() + "   价格是：" + coffeeaddcondiment.cost());


    }
}
