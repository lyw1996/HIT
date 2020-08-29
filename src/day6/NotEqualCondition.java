package day6;



/**
 * <h3>HIT</h3>
 * <p>不相等条件</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 17:26
 **/
public class NotEqualCondition implements Condition{
    private String input;
    private Property property;

    public NotEqualCondition(Property property,String input ) {
        this.input = input;
        this.property = property;
    }

    @Override
    public String getExpression() {
        return property.toString()+" != "+input.toString();
    }
}
