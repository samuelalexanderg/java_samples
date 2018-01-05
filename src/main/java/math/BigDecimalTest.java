package math;

import java.math.BigDecimal;

/**
 * Created by sam on 8/11/17.
 */
public class BigDecimalTest {
    public static void main(String args[]) {
        BigDecimal bigDecimal = new BigDecimal(10000000);
        System.out.println(bigDecimal.compareTo(new BigDecimal(1E4)));
    }
}
