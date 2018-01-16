package mockThink;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import Think.*;

public class CalculaterTest {

    @Test
    public void mockDemo(){

        IMathUtils mathUtils = mock(IMathUtils.class); // 生成mock对象

        when(mathUtils.checkZero(1)).thenReturn(false); // 当num==1时，checkZero(num)返回false
        when(mathUtils.checkZero(0)).thenReturn(true); // 当num==0时，checkZero(num)返回true

        Calculater calculater = new Calculater(mathUtils);

        double result = calculater.divide(2,1);
        System.out.println(result);
        assertEquals(result, 2.0, .1); // 验证 divide(2,1) 结果是2

    }
}
