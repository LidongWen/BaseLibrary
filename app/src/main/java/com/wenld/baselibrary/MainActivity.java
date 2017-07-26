package com.wenld.baselibrary;

import android.view.View;
import android.widget.Button;

import com.wenld.baselib.base.BaseActivity;
import com.wenld.baselib.dialog.AlertDialog;
import com.wenld.baselibrary.test.TestActivity;

public class MainActivity extends BaseActivity {
    String TAG = "MainActivity1";
    AlertDialog dialog;
    Button btn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        if (dialog == null) {
            dialog = new AlertDialog.Builder(this)
                    .setContentView(R.layout.detail_comment_dialog).fullWidth()
                    .fromBottom(false)
                    .fullWidth()
                    .show();
        }

//
//        //网络请求
//        HttpUtils.getInstance().post()
//                .url("https://app.qipai.com/appCenter/index.php")
//                .addParam("controller", "appbox")
//                .addParam("method", "requestAppList")
//                .build()
//                .execute(new BaseApiCallback() {
//
//                    @Override
//                    public void onError(Exception e, int id) {
//                        Log.e(TAG, "异常");
//                    }
//
//                    @Override
//                    public void onResponse(BaseDataModel response, int id) {
//                        Log.e(TAG, response.toString());
//                    }
//                });
//
//        HttpUtils.getInstance().post().url("https://app.qipai.com/appCenter/version/appbox.apk")
//                .build()
//                .execute(new FileCallBack(Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS, getResources().getString(R.string.app_name)) {
//                    @Override
//                    public void onResponse(File response, int id) {
//
//                    }
//
//                    @Override
//                    public File parseNetworkResponse(Object response, int id) throws Exception {
//                        return null;
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

        btn = (Button) findViewById(R.id.btn);
    }

    @Override
    protected void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readyGo(TestActivity.class);
            }
        });
    }
}
