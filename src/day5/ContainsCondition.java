package day5;

/**
 * <h3>HIT</h3>
 * <p>模糊查询</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 17:26
 **/
public class ContainsCondition extends Condition {

    public ContainsCondition(Property property, String input) {
        this.expression="contains("+property.toString()+", \""+input+"\")";
    }
}
