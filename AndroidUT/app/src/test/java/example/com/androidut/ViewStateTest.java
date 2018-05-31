package example.com.androidut;


import android.widget.Button;
import android.widget.CheckBox;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.DEFAULT_MANIFEST_NAME, constants=BuildConfig.class, sdk = 23)
public class ViewStateTest {

    private MainActivity mainActivity;
    private Button inverseButton;
    private CheckBox checkBox;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        inverseButton = (Button) mainActivity.findViewById(R.id.inverse_button);
        checkBox = (CheckBox) mainActivity.findViewById(R.id.checkbox);
    }

    /**
     * 测试控件状态
     */
    @Test
    public void testViewState() {
        // 判断用户是否可以与控件交互
        assertTrue(inverseButton.isEnabled());
        checkBox.setChecked(true);
        //点击按钮，CheckBox反选
        inverseButton.performClick();
        assertTrue(!checkBox.isChecked());
        inverseButton.performClick();
        assertTrue(checkBox.isChecked());
    }

}
