package example.com.androidut;

import android.content.Context;

/**
 * 被测试类，用于返回 Android 布局中的文本。
 */

public class ClassUnderTest{

    private Context context;

    public ClassUnderTest(Context context){
        this.context = context;
    }

    public String getHelloWorldString(){
        return context.getString(R.string.hello_world);
    }

}
