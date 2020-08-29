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

    public Condition() {};

    public Condition(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return this.expression;
    }

    public Condition and(Condition condition){
       this.expression += " and "+condition.getExpression();
       return this;
    }

    public Condition or(Condition condition){
        this.expression += " or "+condition.getExpression();
        return this;
    }

    @Override
    public String toString() {
        return "select * from Table where "+this.expression;
    }
}
