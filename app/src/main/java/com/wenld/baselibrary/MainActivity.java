package com.wenld.baselibrary;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.wenld.baselib.dialog.AlertDialog;
import com.wenld.baselib.http.HttpUtils;
import com.wenld.baselib.http.callback.EngineCallBack;

public class MainActivity extends Activity {
    String TAG = "MainActivity1";
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (dialog == null) {
            dialog = new AlertDialog.Builder(this)
                    .setContentView(R.layout.detail_comment_dialog).fullWidth()
                    .fromBottom(false)
                    .show();
        }


        //网络请求
        HttpUtils.getInstance().post()
                .url("https://app.qipai.com/appCenter/index.php")
                .addParam("controller", "appbox")
                .addParam("method", "requestAppList")
                .build()
                .execute(new EngineCallBack<String>() {

                    @Override
                    public void onError(Exception e, int id) {
                        Log.e(TAG, "异常");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, response);
                    }
                });

//        HttpUtils.getInstance().get().url("https://app.qipai.com/appCenter/version/appbox.apk")
//                .build()
//                .execute(new FileCallBack(Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS, getResources().getString(R.string.app_name)) {
//                    @Override
//                    public void onResponse(File response, int id) {
//
//                    }
//
//                    @Override
//                    public void onError(Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void inProgress(float progress, long total, int id) {
//                        super.inProgress(progress, total, id);
//                    }
//                });
    }
}
