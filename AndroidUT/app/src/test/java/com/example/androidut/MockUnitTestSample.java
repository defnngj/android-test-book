package com.example.androidut;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import android.content.Context;

/**
 *  Mockito 在 Android 应用中的测试
 */

@RunWith(MockitoJUnitRunner.class)
public class MockUnitTestSample {

    private static final String FAKE_STRING = "HELLO WORLD";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {
        // 在被测试对象中注入一个mock的Context
        when(mMockContext.getString(R.string.hello_world))
                .thenReturn(FAKE_STRING);

        ClassUnderTest myObjectUnderTest = new ClassUnderTest(mMockContext);

        // 调用被测试对象返回字符串
        String result = myObjectUnderTest.getHelloWorldString();

        // 断言返回结果是否等于预期
        assertThat(result, is(FAKE_STRING));
    }

}
