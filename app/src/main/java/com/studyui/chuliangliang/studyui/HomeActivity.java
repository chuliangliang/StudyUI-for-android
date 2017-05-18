package com.studyui.chuliangliang.studyui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    //统一接口 跳转 Activity
    private void startActivityWithOtherActivity(Class otherClass)
    {
        Intent intent = new Intent(HomeActivity.this, otherClass);
        startActivity(intent);
    }



    //演示textView按钮点击事件
    public void btn_TextView(View view)
    {
        this.startActivityWithOtherActivity(ActivityForTextView.class);
    }

    //演示文本输入框
    public  void btn_editView(View view)
    {
        this.startActivityWithOtherActivity(ActivityForEditView.class);
    }


    //弹出AlertDialog
    public void btn_AlertDialog(View view)
    {

        AlertDialog.Builder dialog  = new AlertDialog.Builder(HomeActivity.this);
        dialog.setTitle("alert 标题");
        dialog.setMessage("我是消息内容");
        dialog.setCancelable(false);  //是否可以通过点击空白区域或者back键取消alert
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this, "您点击了 ok 按钮", Toast.LENGTH_SHORT).show();
            }
        });


        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this, "您点击了 Cancel 按钮", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNeutralButton("稍后", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this, "您点击了 稍后 按钮", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();


    }
    

    public  void btn_progressDialog(View view)
    {
        ProgressDialog pd = new ProgressDialog(HomeActivity.this);
        pd.setTitle("带有菊花的Alert标题");
        pd.setMessage("loading....(带有菊花的文字消息内容)");
        pd.setCancelable(true); //是否可以通过点击空白区域或者back键取消alert
        pd.show();
    }
}
