package com.studyui.chuliangliang.studyui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityForTextView extends AppCompatActivity {

    private static final String TAG = "ActivityForTextView";
    private static final String CUSTOM_linkString = "自定义文字链接:我是链接一, 链接二: 我是链接二";
    private static final String CUSTOM_link1 = "我是链接一";
    private static final String CUSTOM_link2 = "我是链接二";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview_layout);

        //自定义文本点击事件
        TextView tView = (TextView) findViewById(R.id.textView_customLink);
        this.doInitForlinkTextView(tView);
    }



    //设置textView显示文字及可点击文字区域等
    private void doInitForlinkTextView(TextView textView)
    {


        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                if (widget instanceof TextView) {
                    link1OnClick();
                }
            }
        };
        ClickableSpan clickableSpanForServer = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                if (widget instanceof TextView) {
                    link2OnClick();
                }
            }
        };

        //第一个点击区域的文字开始与结束
        int link1StingStart = CUSTOM_linkString.indexOf(CUSTOM_link1);
        int link1StingEnd =  link1StingStart+CUSTOM_link1.length();

        int link2StingStart = CUSTOM_linkString.indexOf(CUSTOM_link2);
        int link2StingEnd =  link2StingStart+CUSTOM_link2.length();

        SpannableString sp = new SpannableString(CUSTOM_linkString);
        sp.setSpan(clickableSpan, link1StingStart, link1StingEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(clickableSpanForServer, link2StingStart, link2StingEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(sp);
        textView.setLinkTextColor(Color.GRAY);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setClickable(false);
        textView.setLongClickable(false);

    }


    //link1文本点击事件
    public void link1OnClick()
    {
        Log.d(TAG,CUSTOM_link1 + "点击事件");
        this.toast(CUSTOM_link1 + "点击事件");

    }
    //link2文本点击事件
    public void link2OnClick()
    {
        Log.d(TAG,CUSTOM_link2 + "点击事件");
        this.toast(CUSTOM_link2 + "点击事件");
    }

    private void toast(String str)
    {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}

