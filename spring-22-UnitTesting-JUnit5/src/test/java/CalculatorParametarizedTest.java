import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParametarizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String arg){


        Assertions.assertFalse(arg.isEmpty());


    }


    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void testCase2(int num){


        Assertions.assertEquals(0,num % 3);


    }



    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource
    @NullAndEmptySource
    void testCase3(String arg){


        Assertions.assertFalse(arg.isEmpty());


    }


    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 20, 40",
            "30, 20, 100"
    })
    void testcase4(int num1, int num2, int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2), "test failed");
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testcase5(int num1, int num2, int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2), "test failed");
    }




}
