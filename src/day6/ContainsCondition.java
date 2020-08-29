package day6;

/**
 * <h3>HIT</h3>
 * <p>模糊查询</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 17:26
 **/
public class ContainsCondition implements Condition{


    private String input;
    private Property property;

    public ContainsCondition(Property property,String input ) {
        this.input = input;
        this.property = property;
    }

    @Override
    public String and(Condition c) {
        return this.getExpression()+" and "+c.getExpression();
    }

    @Override
    public String or(Condition c) {
        return this.getExpression()+ " or "+c.getExpression();
    }

    @Override
    public String getExpression() {
        return "contains("+property.toString()+","+input+")";
    }
}
