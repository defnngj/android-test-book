package mockitoSample;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * mockito 另一种用法
 */

public class MockitoDemo2 {

    @Mock
    private List<String> mockedList;

    // 必须要初始化mock对象
    public MockitoDemo2(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

}
