package example.com.androidut;

import android.app.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.DEFAULT_MANIFEST_NAME, constants=BuildConfig.class, sdk = 23)
public class ResourcesTest {

    /**
     * 资源文件访问测试
     */
    @Test
    public void testResources() {
        Application application = RuntimeEnvironment.application;
        String appName = application.getString(R.string.app_name);
        assertEquals("AndroidUT", appName);
    }

}
