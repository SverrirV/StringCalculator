package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

  @Test
  public void testEmptyString(){
    assertEquals(0,Calculator.add(""));
  }

  @Test
  public void testSingleNumbers(){
    assertEquals(1,Calculator.add("1"));
  }

  @Test
  public void testTwoNumbers(){
    assertEquals(3,Calculator.add("1,2"));
  }

  @Test
  public void testXNumbers(){
    assertEquals(6,Calculator.add("1,2,3"));
  }

  @Test
  (expected = IllegalArgumentException.class)
  public void testnoMinusNum(){
    assertEquals(1, Calculator.add("-1,2"));
    assertEquals(-4, Calculator.add("2,-4,3,-5"));
  }

  @Test
  public void testXSmallerThan1000(){
    assertEquals(3,Calculator.add("1001,3"));
    assertEquals(50,Calculator.add("2500,10,40,"));
  }

  @Test
  public void testDelimiter(){
  	assertEquals(3, Calculator.add("//;\n1;2"));
  	assertEquals(7, Calculator.add("//<\n3<4"));
  }

  

}
