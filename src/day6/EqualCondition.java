package day6;



/**
 * <h3>HIT</h3>
 * <p>等于条件</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 17:25
 **/
public class EqualCondition implements Condition{

    private String input;
    private Property property;

    public EqualCondition( Property property,String input ) {

        this.input = input;
        this.property = property;
    }


    @Override
    public String getExpression() {
        return property.toString()+" = "+input;
    }
}
