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
        assertEquals("select * from Table where companyName = Ernst Handel", condition.toString());
    }

    @Test
    public void singleConditionNotEqual(){
        Condition condition=new NotEqualCondition(Property.Id,"PICCO");
        assertEquals("select * from Table where id != PICCO",condition.toString());
    }

    @Test
    public void singleConditionContains(){
        Condition condition=new ContainsCondition(Property.ContactTitle,"Manager");
        assertEquals("select * from Table where contains(contactTitle, \"Manager\")",condition.toString());
    }

    @Test
    public void DoubleConditionand(){
        Condition condition1=new ContainsCondition(Property.ContactTitle,"Manager");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        assertEquals("select * from Table where contains(contactTitle, \"Manager\") and id != PICCO",condition1.and(condition2).toString());
    }

    @Test
    public void DoubleConditionor(){
        Condition condition1=new ContainsCondition(Property.ContactTitle,"Manager");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        assertEquals("select * from Table where contains(contactTitle, \"Manager\") or id != PICCO",condition1.or(condition2).toString().toString());
    }

    @Test
    public void TripleCondition2and(){
        Condition condition1=new EqualCondition(Property.CompanyName,"Ernst Handel");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        Condition condition3= new ContainsCondition(Property.ContactTitle,"Manager");
        assertEquals("select * from Table where companyName = Ernst Handel and id != PICCO and contains(contactTitle, \"Manager\")",condition1.and(condition2).and(condition3).toString());
    }

    @Test
    public void TripleCondition2or(){
        Condition condition1=new EqualCondition(Property.CompanyName,"Ernst Handel");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        Condition condition3= new ContainsCondition(Property.ContactTitle,"Manager");
        assertEquals("select * from Table where companyName = Ernst Handel or id != PICCO or contains(contactTitle, \"Manager\")",condition1.or(condition2).or(condition3).toString());
    }

    @Test
    public void TripleCondition1or1and(){
        Condition condition1=new EqualCondition(Property.CompanyName,"Ernst Handel");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        Condition condition3= new ContainsCondition(Property.ContactTitle,"Manager");
        assertEquals("select * from Table where companyName = Ernst Handel or id != PICCO and contains(contactTitle, \"Manager\")",condition1.or(condition2).and(condition3).toString());
    }
}
