package day5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <h3>HIT</h3>
 * <p>sql查询语句测试</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 17:27
 **/
public class SqlSelectTest {

    @Test
    public void singleConditionEqual(){
        Condition condition = new EqualCondition(Property.CompanyName,"Ernst Handel");
        assertEquals("companyName = Ernst Handel", condition.getExpression());
    }

    @Test
    public void singleConditionNotEqual(){
        Condition condition=new NotEqualCondition(Property.Id,"PICCO");
        assertEquals("id != PICCO",condition.getExpression());
    }

    @Test
    public void singleConditionContains(){
        Condition condition=new ContainsCondition(Property.ContactTitle,"Manager");
        assertEquals("contains(contactTitle,Manager)",condition.getExpression());
    }

    @Test
    public void DoubleConditionand(){
        Condition condition1=new ContainsCondition(Property.ContactTitle,"Manager");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        assertEquals("contains(contactTitle,Manager) and id != PICCO",condition1.and(condition2));
    }

    @Test
    public void DoubleConditionor(){
        Condition condition1=new ContainsCondition(Property.ContactTitle,"Manager");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        assertEquals("contains(contactTitle,Manager) or id != PICCO",condition1.or(condition2));
    }

    @Test
    public void TripleCondition2and(){
        Condition condition1=new EqualCondition(Property.CompanyName,"Ernst Handel");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        Condition condition3=new NotEqualCondition(Property.Id,"PICCO");
        assertEquals("",condition1.and(condition2));
    }
}
