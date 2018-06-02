package mockitoSample;// 静态导入会使代码更简洁

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * mockito 框架基本用法
 */

public class MockitoDemo {

    @Test
    public void verify_behaviour(){
        // mock creation 创建mock对象
        List mockedList = mock(List.class);

        //利用 mock object 使用mock对象
        mockedList.add("one");
        mockedList.clear();

        //verification 验证
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }

    @Test(expected = RuntimeException.class)
    public void when_thenReturn(){
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        // 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 输出“first”
        System.out.println(mockedList.get(0));
        // 断言
        Assert.assertEquals(mockedList.get(0), "first");

        // 抛出异常
        System.out.println(mockedList.get(1));

        // 因为get(999) 没有打桩，因此输出null
        System.out.println(mockedList.get(999));

        // 验证get(0)被调用的次数
        verify(mockedList).get(0);
    }

    @Test
    public void with_arguments(){

        LinkedList mockedList = mock(LinkedList.class);

        // 使用内置的anyInt()参数匹配器
        when(mockedList.get(anyInt())).thenReturn("element");

        // 输出element
        //System.out.println(mockedList.get(100));
        //System.out.println(mockedList.get(100));
        Assert.assertEquals(mockedList.get(100), "element");

        // 你也可以验证参数匹配器
       verify(mockedList).get(anyInt());
    }
    @Test
    public void with_arguments2(){

        LinkedList mockedList = mock(LinkedList.class);

        // 使用自定义的参数匹配器( 在IsValid()类中返回你自己的匹配器实现 )
        when(mockedList.contains(argThat(new IsValid()))).thenReturn(true);

        assertTrue(mockedList.contains(1));
        assertTrue(!mockedList.contains(3));

    }

    private class IsValid implements ArgumentMatcher<Object> {
        @Override
        public boolean matches(Object argument) {
            return argument.equals(1) || argument.equals(2);
        }
    }


    @Test
    public void verifying_number_of_invocations(){
        @SuppressWarnings("unchecked")
        LinkedList<String> mockedList = mock(LinkedList.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        // 下面的两个验证函数效果一样,因为verify默认验证的就是times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        // 验证具体的执行次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        // 使用never()进行验证,never相当于times(0)
        verify(mockedList, never()).add("never happened");

        // 使用atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

    @Test
    public void verification_in_order(){
        // A. 验证mock一个对象的函数执行顺序
        @SuppressWarnings("unchecked")
        List<String> singleMock = mock(List.class);

        //使用单一mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        // 为该mock对象创建一个inOrder对象
        InOrder inOrder = inOrder(singleMock);

        // 确保add函数首先执行的是add("was added first"),然后才是add("was added second")
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B .验证多个mock对象的函数执行顺序
        @SuppressWarnings("unchecked")
        List<String> firstMock = mock(List.class);
        @SuppressWarnings("unchecked")
        List<String> secondMock = mock(List.class);

        //使用 mocks
        secondMock.add("was called second");
        firstMock.add("was called first");


        // 为这两个Mock对象创建inOrder对象
        InOrder inOrder2 = inOrder(firstMock, secondMock);

        // 验证它们的执行顺序
        inOrder2.verify(secondMock).add("was called second");
        inOrder2.verify(firstMock).add("was called first");
    }

    @Test(expected = RuntimeException.class)
    public void when_doThrow() throws RuntimeException {

        LinkedList mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        //following throws RuntimeException:
        // 下面的代码会抛出异常
        mockedList.clear();
    }

}
