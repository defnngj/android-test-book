package com.example.androidut;


import android.app.AlertDialog;
import android.util.Log;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.shadows.ShadowLog;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.DEFAULT_MANIFEST_NAME, constants=BuildConfig.class, sdk = 23)
public class DialogTest {

    private MainActivity mainActivity;
    private Button dialogButton;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        dialogButton = (Button) mainActivity.findViewById(R.id.dialog_button);
        //输出日志
        ShadowLog.stream = System.out;
    }

    /**
     * Dialog的测试
     */
    @Test
    public void testDialog() {
        //点击按钮，出现对话框
        dialogButton.performClick();
        AlertDialog latestAlertDialog = ShadowAlertDialog.getLatestAlertDialog();
        Log.i("dialog message:",latestAlertDialog.toString());
        assertNotNull(latestAlertDialog);
    }
}
