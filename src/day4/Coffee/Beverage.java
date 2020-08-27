package day4.Coffee;

import day4.Coffee.Size;
import day4.Coffee.Temperature;

/**
 * @author : liuyuwei
 * @date : 2020-08-27 16:22
 * 抽象构造类
 **/
public abstract class Beverage {

    String description = "未知的咖啡";

    public String getDescription() {
        return description+getSize()+getTemperature();
    }

    public abstract double cost();

    //默认：大杯+常温
    Size size=Size.Large;
    Temperature temperature=Temperature.Normal;


    public void setSize(Size size) {
        this.size = size;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Size getSize() {
        return size;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
