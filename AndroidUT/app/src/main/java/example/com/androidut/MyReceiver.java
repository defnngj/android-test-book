package example.com.androidut;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


/**
 * @Description: 自定义广播接收器
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences.Editor editor = context
                .getSharedPreferences("data", Context.MODE_PRIVATE).edit();
        String appName = intent.getStringExtra("APP_NAME");
        editor.putString("NAME", appName);
        editor.apply();
    }

    /**
     * 通过Context.getSharedPreferences方法获取SharedPreferences对象，参数分别为存储的文件名和存储模式。
     * account 为存储的文件名
     * Context.MODE_PRIVATE：为默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容
     * getStringExtra(Key)，就可以获得你之前打包的那个数据了， 与 putExtra() 配合使用。
     * 调用Editor.putString()方法为插入数据，两个参数分别为键和值。
     */
}