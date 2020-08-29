package day5;

/**
 * <h3>HIT</h3>
 * <p>抽象类 基类</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 17:20
 **/
public abstract class Condition {
    String expression;

    public Condition(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return this.expression;
    }

    public String and(Condition condition){

        return this.expression+" and "+condition.getExpression();
    }

    public String or(Condition condition){
        return this.expression+" or "+condition.getExpression();
    }
}
