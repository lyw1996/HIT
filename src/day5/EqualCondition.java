package day5;

/**
 * <h3>HIT</h3>
 * <p>等于条件</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 17:25
 **/
public class EqualCondition extends Condition{

    public EqualCondition(Property property, String input) {
        this.expression=property.toString()+" = "+input;
    }
}
