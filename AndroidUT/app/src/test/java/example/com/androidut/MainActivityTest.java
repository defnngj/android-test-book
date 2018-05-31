package example.com.androidut;


import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowLog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.DEFAULT_MANIFEST_NAME, constants=BuildConfig.class, sdk = 24)
public class MainActivityTest {

    private MainActivity mainActivity;
    private EditText editMessage;
    private Button sendButton;

    @Before
    public void setUp() throws Exception{
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        editMessage = (EditText) mainActivity.findViewById(R.id.edit_message);
        sendButton = (Button) mainActivity.findViewById(R.id.send_button);
        //输出日志
        ShadowLog.stream = System.out;
    }

    /**
     * 最基本的Activity测试
     */
    @Test
    public void testActivity() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(mainActivity);
        assertEquals(mainActivity.getTitle(), "AndroidUT");
    }

    /**
     * 验证页面跳转
     */
    @Test
    public void testNextActivity() {
        //点击发送按钮跳转到一个DisplayMessageActivity
        editMessage.setText("tom");
        sendButton.performClick();
        Intent expectedIntent = new Intent(mainActivity, DisplayMessageActivity.class);
        Intent actualIntent = ShadowApplication.getInstance().getNextStartedActivity();
        Log.i("new activity:",expectedIntent.getComponent().getClassName());
        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
    }

    /**
     * Activity生命周期测试
     */
    @Test
    public void testLifecycle() {
        // 创建Activity控制器
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        MainActivity activity = controller.get();
        assertNull(activity.getLifecycleState());

        // 调用Activity的performCreate方法
        controller.create();
        assertEquals("onCreate", activity.getLifecycleState());

        // 调用Activity的performStart方法
        controller.start();
        assertEquals("onStart", activity.getLifecycleState());

        // 调用Activity的performResume方法
        controller.resume();
        assertEquals("onResume", activity.getLifecycleState());

        // 调用Activity的performPause方法
        controller.pause();
        assertEquals("onPause", activity.getLifecycleState());

        // 调用Activity的performStop方法
        controller.stop();
        assertEquals("onStop", activity.getLifecycleState());

        // 调用Activity的performRestart方法
        controller.restart();
        // 注意此处应该是onStart，因为performRestart不仅会调用restart，还会调用onStart
        assertEquals("onStart", activity.getLifecycleState());

        // 调用Activity的performDestroy方法
        controller.destroy();
        assertEquals("onDestroy", activity.getLifecycleState());
    }


}