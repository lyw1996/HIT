package day5;

/**
 * <h3>HIT</h3>
 * <p>不相等条件</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 17:26
 **/
public class NotEqualCondition extends Condition{
    public NotEqualCondition(Property property, String input) {
        this.expression=property.toString()+" != "+input.toString();
    }
}
