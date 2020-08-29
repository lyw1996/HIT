package day6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <h3>HIT</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-08-29 18:35
 **/
public class SqlSelectTest {

    @Test
    public void TripleCondition2and(){
        Condition condition1=new EqualCondition(Property.CompanyName,"Ernst Handel");
        Condition condition2=new NotEqualCondition(Property.Id,"PICCO");
        Condition condition3=new NotEqualCondition(Property.Id,"PICCO");
        assertEquals("",condition1.and(condition2));
    }
}
