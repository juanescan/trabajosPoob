import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//Gran parte de las pruebas se realizaron con ayuda de chatGPT

public class DataMatrixCalculatorTest {
    
    @Test
    public void testAssignMatrix() {
        DataMatrixCalculator calculator = new DataMatrixCalculator();
        String[][] prueba = {{"a", "b"}, {"c", "d"}};
        calculator.assign("test", prueba);
        assertEquals("[[a, b], [c, d]]", calculator.toString("test"));
    }
    
    @Test
    public void testAssignShape() {
        DataMatrixCalculator calculator = new DataMatrixCalculator();
        String[][] prueba = {{"1", "asd", "true"}, {"3", "s","false"}};
        calculator.assign("test1", prueba);
        calculator.assign("test2", 's', "test1");
        assertEquals("[[2, 3]]", calculator.toString("test2"));
    }
    
    @Test
    public void testAssignTranspose() {
        DataMatrixCalculator calculator = new DataMatrixCalculator();
        String[][] testData = {{"1", "2", "3"}, {"4", "5", "6"},{"7","8","9"}};
        calculator.assign("test1", testData);
        calculator.assign("test2", 't', "test1");
        assertEquals("[[1, 4, 7], [2, 5, 8], [3, 6, 9]]", calculator.toString("test2"));
    }
    
    @Test
    public void testBinaryAddition() {
        DataMatrixCalculator calculator = new DataMatrixCalculator();
        String[][] prueba1 = {{"1", "2"}, {"3", "4"}};
        String[][] prueba2 = {{"5", "6"}, {"7", "8"}};
        calculator.assign("A", prueba1);
        calculator.assign("B", prueba2);
        calculator.assign("C", "A", '+', "B");
        assertNotEquals("[[12, 132], [123, 12]]", calculator.toString("C"));
    }
    
    @Test
    public void testBinarySubtraction() {
        DataMatrixCalculator calculator = new DataMatrixCalculator();
        String[][] prueba1 = {{"false", "a"}, {"7", "8"}};
        String[][] prueba2 = {{"1", "d"}, {"3", "4"}};
        calculator.assign("test1", prueba1);
        calculator.assign("test2", prueba2);
        calculator.assign("test3", "test1", '-', "test2");
        assertNotEquals("[[false, d], [4, 4]]", calculator.toString("test3"));
    }
}
