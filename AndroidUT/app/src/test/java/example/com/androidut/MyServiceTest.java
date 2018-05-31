package example.com.androidut;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ServiceController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

/**
 * @Description: 自定义服务测试
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.DEFAULT_MANIFEST_NAME, constants=BuildConfig.class, sdk = 23)
public class MyServiceTest {

    private ServiceController<MyService> controller;

    @Before
    public void setUp() throws Exception {
        controller = Robolectric.buildService(MyService.class);
        controller.get();
        ShadowLog.stream = System.out;  // 定义日志输出
    }

    /**
     * 控制Service生命周期进行验证
     *
     * @throws Exception
     */
    @Test
    public void testServiceLifecycle() throws Exception {
        controller.create();
        controller.startCommand(0, 0);
        controller.bind();
        controller.unbind();
        controller.destroy();
    }
}
