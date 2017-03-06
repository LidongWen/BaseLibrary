package com.wenld.baselibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wenld.baselib.dialog.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new DefaultNavigationBar.Builder(this,null).create();

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setContentView(R.layout.detail_comment_dialog).fullWidth()
                .fromBottom(false)
                .show();
    }
}
