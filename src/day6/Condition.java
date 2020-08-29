package day6;

/**
 * <h3>HIT</h3>
 * <p>接口</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 18:17
 **/
public interface Condition {

    Condition and(Condition c);
    Condition or(Condition c);

    default String getExpression(){

    } 
}
