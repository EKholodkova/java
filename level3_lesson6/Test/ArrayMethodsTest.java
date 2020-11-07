import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


class ArrayMethodsTest {
    static class Pair {
        int[] input;
        int[] output;
        Pair(int[] input, int[] output) {
            this.input = input;
            this.output = output;
        }
    }

    static class ArrBoolPair {
        int[] input;
        boolean out;
        ArrBoolPair(int[] input, boolean out) {
            this.input = input;
            this.out = out;
        }
    }

    static Stream<Pair> arraysSource() {
        return Stream.of(
                new Pair(new int[]{1,8,16,90,11,4,5,8}, new int[]{5,8}),
                new Pair(new int[]{1,8,16,90,11,4,5,8}, new int[]{45,8}),
                new Pair(new int[]{4,4,4,1,4,5,4}, new int[]{}),
                new Pair(new int[]{9,8,7,4,2,4,5,6,7,8}, new int[]{5,6,7,8}));
    }
    @ParameterizedTest
    @MethodSource("arraysSource")
    public void getNewArrayTest(Pair data) {
        int[] result = ArrayMethods.getNewArray(data.input);
        Assertions.assertArrayEquals(data.output, result);
    }

    static Stream<ArrBoolPair> arrBoolSource() {
        return Stream.of(
                new ArrBoolPair(new int[]{1,1,1,1,4,1,1,4}, true),
                new ArrBoolPair(new int[]{1,1,1,1,1,1}, true),
                new ArrBoolPair(new int[]{4,4,4,4}, false),
                new ArrBoolPair(new int[]{1,1,9,1,1,4,1,1,4}, false));
    }

    @ParameterizedTest
    @MethodSource("arrBoolSource")
    void checkArrayData1Test(ArrBoolPair data) {
        boolean result = ArrayMethods.checkArrayData1(data.input);
        Assertions.assertEquals(data.out, result);
    }

    @ParameterizedTest
    @MethodSource("arrBoolSource")
    void checkArrayDataTest(ArrBoolPair data) {
        boolean result = ArrayMethods.checkArrayData1(data.input);
        Assertions.assertEquals(data.out, result);
    }


    @Test
    public void checkRuntimeException() {
        class C implements Executable{
            @Override
            public void execute() throws Throwable {
                ArrayMethods.getNewArray(new int[] {0,0,0});
            }
        }
        Assertions.assertThrows(RuntimeException.class, new C());
    }
}