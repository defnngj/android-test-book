package example.com.androidut;


import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.DEFAULT_MANIFEST_NAME, constants=BuildConfig.class, sdk = 23)
public class ToastTest {
    private MainActivity mainActivity;
    private Button toastButton;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        toastButton = (Button) mainActivity.findViewById(R.id.toast_button);
    }

    /**
     * Toast的测试
     */
    @Test
    public void testToast() {
        //点击按钮，出现吐司
        toastButton.performClick();
        assertEquals(ShadowToast.getTextOfLatestToast(), "This is a hint of information");
    }

}
