package example.com.androidut;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.robolectric.shadows.ShadowPackageManager;

/**
 * @Description: 广播测试
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.DEFAULT_MANIFEST_NAME, constants=BuildConfig.class, sdk = 23)
public class MyReceiverTest {

    private final String action = "com.example.androidut";

//    @Test
//    public void testRegister() throws Exception {
//        ShadowApplication shadowApplication = ShadowApplication.getInstance();
//        Intent intent = new Intent(action);
//        // 验证是否注册了相应的Receiver
//        assertTrue(shadowApplication.hasReceiverForIntent(intent));
//    }

    @Test
    public void testReceive() throws Exception {
        //发送广播
        Intent intent = new Intent(action);
        intent.putExtra("APP_NAME", "AndroidUT");

        MyReceiver myReceiver = new MyReceiver();
        myReceiver.onReceive(RuntimeEnvironment.application, intent);
        //验证广播的处理逻辑是否正确
        SharedPreferences preferences = RuntimeEnvironment.application
                .getSharedPreferences("data", Context.MODE_PRIVATE);
        assertEquals("AndroidUT", preferences.getString("NAME", ""));
    }

}
