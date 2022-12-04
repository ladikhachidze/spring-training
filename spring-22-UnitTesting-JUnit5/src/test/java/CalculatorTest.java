import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUpEach(){
        System.out.println("before each ");
    }
    @AfterEach
    void tearDownEach(){
        System.out.println("after each ");
    }


    @Test
    void add2(){
        System.out.println("Add2 method");
//        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(3,2));
        assertThrows(AccessDeniedException.class, () -> Calculator.add2(3,2));
    }



    @Test
    void add() {
        System.out.println("add method");
        int actual = Calculator.add(2,3);
        assertEquals(5,actual, "Test failed.");
    }

    @Test
    void testCase1(){
//        System.out.println("test case 1");
        fail("not implemented yet");
    }
    @Test
    void testCase2(){
        System.out.println("test case 2");
        assertEquals("add", Calculator.operator);
    }
    @Test
    void testCase3(){
        System.out.println("test case 3");
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3},"arrays not same");
    }
    @Test
    void testCase4(){
        System.out.println("test case 4");
        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);
    }
    @Test
    void testCase5(){
        System.out.println("test case 5");

        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1,c2);
        assertNotSame(c1,c3);

    }




}